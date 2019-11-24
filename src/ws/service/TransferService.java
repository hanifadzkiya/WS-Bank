package ws.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.Version;

public class TransferService {

  /**
   * Memvalidasi Nomor.
   * @param nomorPengirim Nomor Rekening Pengirim.
   * @param nomorPenerima Nomor Rekening Penerima.
   * @return boolean.
   * @throws Exception exception.
   */
  private static boolean validateNomor(
      String nomorPengirim, String nomorPenerima) throws Exception {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(url, user, password);

      PreparedStatement ps = con.prepareStatement(
          "select * from nasabah where no_rekening = " + nomorPengirim + ";");
      ResultSet rs = ps.executeQuery();
      if (!rs.next()) {
        System.out.println("Nomor pengirim tidak valid");
        return false;
      }

      ps = con.prepareStatement(
          "select * from nasabah where no_rekening = " + nomorPenerima + ";");
      ResultSet rs2 = ps.executeQuery();
      if (!rs2.next()) {
        ps = con.prepareStatement(
            "select * from akun_virtual where no_akun_virtual = " + nomorPenerima + ";");
        ResultSet rs3 = ps.executeQuery();
        if (!rs3.next()) {
          System.out.println("Nomor penerima tidak valid");
          return false;
        }
      }

      return true;
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }

  /**
   * Memvalidasi Saldo.
   * @param nomorPengirim Nomor Pengirim.
   * @param nominal Nominal.
   * @return Boolena.
   * @throws Exception exception.
   */
  private static boolean validateSaldo(String nomorPengirim, long nominal) throws Exception {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(url, user, password);

      PreparedStatement ps = con.prepareStatement(
          "select * from nasabah where "
              + "no_rekening = " + nomorPengirim + " and saldo >= " + nominal + ";");
      ResultSet rs = ps.executeQuery();
      if (!rs.next()) {
        System.out.println("Saldo kurang");
        return false;
      }

      return true;
    } catch (Exception e) {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }

  /**
   * Validasi.
   * @param nomorPengirim nomor Pengirim.
   * @param nomorPenerima nomor Penerima.
   * @param saldo saldo.
   * @return Boolean.
   * @throws Exception Exception.
   */
  public static boolean validate(
      String nomorPengirim, String nomorPenerima, long saldo) throws Exception {
    if (TransferService.validateNomor(nomorPengirim,nomorPenerima)
        && TransferService.validateSaldo(nomorPengirim, saldo)) {
      return true;
    }

    return false;
  }

  /**
   * Mentransfer .
   * @param nomorPengirim Nomor Pengirim.
   * @param nomorPenerima Nomor Penerima.
   * @param nominal Nominal.
   * @throws Exception exception.
   */
  public static void transfer(
      String nomorPengirim, String nomorPenerima, long nominal) throws Exception {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(url, user, password);

      PreparedStatement ps = con.prepareStatement(
          "update wsbank.nasabah set saldo = saldo - "
              + nominal + " where no_rekening = " + nomorPengirim + ";");
      ps.executeUpdate();

      ps = con.prepareStatement("select * from nasabah where no_rekening = " + nomorPenerima);
      ResultSet rs = ps.executeQuery();

      if (!rs.next()) {
        ps = con.prepareStatement(
            "update nasabah "
                + "inner join akun_virtual on nasabah.id = akun_virtual.id_rekening "
                + "set nasabah.saldo = nasabah.saldo + " + nominal
                + " where akun_virtual.no_akun_virtual = " + nomorPenerima + ";");
        ps.executeUpdate();
      } else {
        ps = con.prepareStatement(
            "update wsbank.nasabah set saldo = saldo + " + nominal
                + " where no_rekening = " + nomorPenerima + ";");
        ps.executeUpdate();

        ps = con.prepareStatement(
            "select nasabah.id from nasabah where nasabah.no_rekening = " + nomorPengirim + ";");
        ResultSet rs2 = ps.executeQuery();
        rs2.next();
        int id = rs2.getInt("id");

        ps = con.prepareStatement(
            "select nasabah.id from nasabah where nasabah.no_rekening = " + nomorPenerima + ";");
        ResultSet rs3 = ps.executeQuery();
        rs3.next();
        int id2 = rs3.getInt("id");
      }

      ps = con.prepareStatement(
          "insert into transaksi (no_rekening_1, jenis, jumlah, no_rekening_2, waktu_transaksi) "
              + "values ('" + nomorPengirim + "', 'debit', "
              + nominal + ", " + nomorPenerima + ", now());");
      ps.executeUpdate();

      ps = con.prepareStatement(
          "insert into transaksi (no_rekening_1, jenis, jumlah, no_rekening_2, waktu_transaksi) "
              + "values ('" + nomorPenerima + "', 'kredit', " + nominal
              + ", " + nomorPengirim + ", now());");
      ps.executeUpdate();
    } catch (Exception e)  {
      Logger lgr = Logger.getLogger(Version.class.getName());
      lgr.log(Level.SEVERE, e.getMessage(), e);
      throw e;
    }
  }
}
