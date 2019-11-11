package ws.service;

import jdk.nashorn.internal.runtime.Version;
import ws.model.Transaction;
import ws.model.TransactionBuilder;
import ws.util.TransactionRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreditTransactionService {
    private static final int CREDIT_TRANSACTION_TYPE = 1;

    private static List<Transaction> executeQuery(String query, int type) throws Exception{
        String url = "jdbc:mysql://localhost:3306/wsbank";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(type == CREDIT_TRANSACTION_TYPE){
                List<Transaction> transactions = new ArrayList<Transaction>();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int idNasabah = rs.getInt("id_nasabah");
                    String jenis = rs.getString("jenis");
                    Double jumlah = rs.getDouble("jumlah");
                    String nomorTerkait = rs.getString("nomor_terkait");
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

    private static List<Transaction> getCreditTransactions(TransactionRequest transactionRequest) throws Exception{
        String nomorTekait = transactionRequest.getNomorTerkait();
        Double jumlah = transactionRequest.getJumlah();
        String startTime = transactionRequest.getStartTime();
        String endTime = transactionRequest.getEndTime();

//        String query = "SELECT * FROM transaksi WHERE jenis = 'kredit';";
        String query = "SELECT * FROM transaksi WHERE jenis = 'kredit' AND nomor_terkait = '";
        query = query + nomorTekait + "' AND jumlah = " + jumlah.toString() + "AND waktu_transaksi > '" + startTime + "'";
        query = query + "AND waktu_transaksi < '" + endTime + "';";
        try{
            return executeQuery(query, CREDIT_TRANSACTION_TYPE);
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    public static String isExistCreditTransaction(TransactionRequest transactionRequest){
        try{
            List<Transaction> transactions = getCreditTransactions(transactionRequest);
            boolean exist = !transactions.isEmpty();
            if(exist){
                String nomorTerkait = transactions.get(0).getNomorTerkait();
                return "Transaksi dengan nomor terkait " + nomorTerkait + " ditemukan";
            } else{
                return "Tidak ada hasil dengan nomor: " + transactionRequest.getNomorTerkait();
            }
        } catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }
}
