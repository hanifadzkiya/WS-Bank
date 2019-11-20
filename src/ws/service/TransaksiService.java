package ws.service;

import jdk.nashorn.internal.runtime.Version;
import ws.model.Transaksi;
import ws.model.TransaksiBuilder;
import ws.model.Transaksi;
import ws.util.TransaksiRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaksiService {
    private static List<Transaksi> executeQuery(String query) throws Exception{
        String url = "jdbc:mysql://localhost:3306/wsbank";
        String user = "root";
        String password = "1256";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            List<Transaksi> arrTransaksi = new ArrayList<Transaksi>();
            while(rs.next()){
                int id = rs.getInt("id");
                int idNasabah = rs.getInt("id_nasabah");
                String jenis = rs.getString("jenis");
                int jumlah = rs.getInt("jumlah");
                String nomorTerkait = rs.getString("nomor_terkait");
                String waktuTransaksi = rs.getString("waktu_transaksi");

                Transaksi transaksi = new TransaksiBuilder(id, idNasabah, jenis, jumlah, nomorTerkait, waktuTransaksi)
                        .build();

                arrTransaksi.add(transaksi);
            }
            con.close();
            return arrTransaksi;
        } catch (Exception e) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }
    private static List<Transaksi> getTransaksiByIdNasabah(TransaksiRequest transaksiRequest) throws Exception{
        String idNasabah = transaksiRequest.getIdNasabah();

        String query = "SELECT * FROM transaksi WHERE id_nasabah = " + idNasabah;
        try{
            return executeQuery(query);
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    public static List<Transaksi> getAllNasabahTransaksi(TransaksiRequest transaksiRequest){
        try{
            List<Transaksi> arrTransaksi = getTransaksiByIdNasabah(transaksiRequest);
            return arrTransaksi;
        } catch (Exception e){
            return null;
        }
    }
}
