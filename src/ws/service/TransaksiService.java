package ws.service;

import jdk.nashorn.internal.runtime.Version;
import ws.model.Rekening;
import ws.model.Transaksi;
import ws.model.TransaksiBuilder;
import ws.model.Transaksi;
import ws.util.RekeningRequest;
import ws.util.RekeningRequestBuilder;
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
        String url = "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
        String user = "engimabp";
        String password = "Bankpro234";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            List<Transaksi> arrTransaksi = new ArrayList<Transaksi>();
            while(rs.next()){
                int id = rs.getInt("id");
                String noRekening_1 = rs.getString("no_rekening_1");
                String jenis = rs.getString("jenis");
                int jumlah = rs.getInt("jumlah");
                String noRekening_2 = rs.getString("no_rekening_2");
                String waktuTransaksi = rs.getString("waktu_transaksi");

                Transaksi transaksi = new TransaksiBuilder(id, noRekening_1, jenis, jumlah, noRekening_2, waktuTransaksi)
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

    private static List<Transaksi> getTransaksiByNoRekening(RekeningRequest rekeningRequest,int idNasabah) throws Exception{
        String noRekening = rekeningRequest.getNoRekening();

        String query = "SELECT * from transaksi WHERE no_rekening_1 = " + noRekening + " OR (no_rekening_1 in (SELECT no_akun_virtual FROM akun_virtual WHERE id_rekening= " + idNasabah + "))";
        try{
            return executeQuery(query);
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    public static List<Transaksi> getAllNasabahTransaksi(RekeningRequest rekeningRequest){
        try{
            Rekening resultDetailRekening = RekeningService.getRekeningDetail(rekeningRequest);
            int idNasabah = resultDetailRekening.getId();
            List<Transaksi> arrTransaksi = getTransaksiByNoRekening(rekeningRequest,idNasabah);
            return arrTransaksi;
        } catch (Exception e){
            return null;
        }
    }
}
