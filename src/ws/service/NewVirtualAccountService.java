package ws.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

import jdk.nashorn.internal.runtime.Version;

public class NewVirtualAccountService {
  /**
   * Create NEW.
   * @param nomorRekening nomor Rekening.
   * @return String.
   * @throws Exception Exception.
   */
  public static String createNew(String nomorRekening) throws Exception {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(url, user, password);

      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      long cons = timestamp.getTime();
      long newVirtualAccountNumber = Long.parseLong(nomorRekening) + cons;

      PreparedStatement ps = con.prepareStatement(
          "select * from nasabah where no_rekening = " + nomorRekening + ";");
      ResultSet rs = ps.executeQuery();
      rs.next();

      int idRekening = rs.getInt("id");

      ps = con.prepareStatement(
          "insert into akun_virtual (no_akun_virtual, idRekening) "
              + "values (" + newVirtualAccountNumber + "," + idRekening + ");");
      ps.executeUpdate();

      String result = "Berhasil, dengan nomor akun virtual : " + newVirtualAccountNumber;
      return result;
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }
}
