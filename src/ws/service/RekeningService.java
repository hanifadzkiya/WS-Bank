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
import ws.model.Rekening;
import ws.model.RekeningBuilder;
import ws.util.RekeningRequest;

public class RekeningService {
  private static Connection con;
  private static String url =
      "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
  private static String user = "engimabp";
  private static String password = "Bankpro234";

  /**
   * executeQuery.
   * @param query query.
   * @return ResultSet.
   * @throws Exception exception.
   */
  private static ResultSet executeQuery(String query) throws Exception {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      return rs;
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }

  /**
   * GetListRekeningFromResultSet.
   * @param rs rs.
   * @return List Rekening.
   * @throws Exception exception.
   */
  private static List<Rekening> getListRekeningFromResultSet(ResultSet rs) throws Exception {
    try {
      List<Rekening> arrRekening = new ArrayList<Rekening>();
      while (rs.next()) {
        int id = rs.getInt("id");
        String nama = rs.getString("nama");
        String noRekening = rs.getString("no_rekening");
        String namaBank = rs.getString("nama_bank");
        int saldo = rs.getInt("saldo");

        Rekening rekening = new RekeningBuilder(id, nama, noRekening, namaBank, saldo)
            .build();

        arrRekening.add(rekening);
      }
      return arrRekening;
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }

  /**
   * Get Rekening BY No Rekening.
   * @param rekeningRequest rekeningRequest.
   * @return List Rekening.
   * @throws Exception exception.
   */
  private static List<Rekening>
      getRekeningByNoRekening(RekeningRequest rekeningRequest) throws Exception {
    String noRekening = rekeningRequest.getNoRekening();

    String query = "SELECT * FROM nasabah WHERE no_rekening = " + noRekening;
    try {
      con = DriverManager.getConnection(url, user, password);
      ResultSet rs = executeQuery(query);
      List<Rekening> arrRekening = getListRekeningFromResultSet(rs);
      con.close();
      return arrRekening;
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }

  /**
   * Mengecek ketersediaan nomor Rekening.
   * @param rekeningRequest Rekening Request.
   * @return Boolean.
   */
  public static boolean isExistNomorRekening(RekeningRequest rekeningRequest) {
    try {
      List<Rekening> arrRekening = getRekeningByNoRekening(rekeningRequest);
      boolean exist = !arrRekening.isEmpty();
      if (exist) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Get Rekening Detail.
   * @param rekeningRequest rekeningRequest.
   * @return Rekening.
   */
  public static Rekening getRekeningDetail(RekeningRequest rekeningRequest) {
    try {
      List<Rekening> arrRekening = getRekeningByNoRekening(rekeningRequest);
      boolean exist = !arrRekening.isEmpty();
      if (exist) {
        return arrRekening.get(0);
      } else {
        return new Rekening();
      }
    } catch (Exception e) {
      return new Rekening();
    }
  }
}
