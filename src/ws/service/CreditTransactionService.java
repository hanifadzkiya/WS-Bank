package ws.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.Version;
import ws.model.Transaction;
import ws.model.TransactionBuilder;
import ws.util.TransactionRequest;

public class CreditTransactionService {
  private static final int CREDIT_TRANSACTION_TYPE = 1;

  /**
   * executreQuery.
   * @param query query.
   * @param type type.
   * @return List Transaction.
   * @throws Exception exceptions.
   */
  private static List<Transaction> executeQuery(String query, int type) throws Exception {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(url, user, password);

      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);

      if (type == CREDIT_TRANSACTION_TYPE) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        while (rs.next()) {
          int id = rs.getInt("id");
          String idNasabah = rs.getString("no_rekening_1");
          String jenis = rs.getString("jenis");
          Double jumlah = rs.getDouble("jumlah");
          String nomorTerkait = rs.getString("no_rekening_2");
          String waktuTransaksi = rs.getString("waktu_transaksi");

          Transaction transaction = new TransactionBuilder(id, idNasabah)
              .setJenis(jenis)
              .setJumlah(jumlah)
              .setNomorTerkait(nomorTerkait)
              .setWaktuTransaksi(waktuTransaksi)
              .build();

          transactions.add(transaction);
        }
        con.close();
        return transactions;
      } else {
        con.close();
        throw new Exception("Unknown type of transaction");
      }
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }

  /**
   * GetCreditTransactions.
   * @param transactionRequest transactionRequest.
   * @return ListTransaction.
   * @throws Exception exception.
   */
  private static List<Transaction> getCreditTransactions(
      TransactionRequest transactionRequest) throws Exception {
    String nomorTekait = transactionRequest.getNomorTerkait();
    Double jumlah = transactionRequest.getJumlah();
    String startTime = transactionRequest.getStartTime();
    String endTime = transactionRequest.getEndTime();

    String query = "SELECT * FROM transaksi WHERE jenis = 'kredit' AND no_rekening_2 = '";
    query = query + nomorTekait + "' AND jumlah = "
        + jumlah.toString() + "AND waktu_transaksi >= '" + startTime + "'";
    query = query + "AND waktu_transaksi <= '" + endTime + "';";
    try {
      return executeQuery(query, CREDIT_TRANSACTION_TYPE);
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }

  /**
   * isExistCredit.
   * @param transactionRequest transactionRequest.
   * @return Boolean.
   */
  public static Boolean isExistCreditTransaction(TransactionRequest transactionRequest) {
    try {
      List<Transaction> transactions = getCreditTransactions(transactionRequest);
      boolean exist = !transactions.isEmpty();
      if (exist) {
        String nomorTerkait = transactions.get(0).getNomorTerkait();
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }
}
