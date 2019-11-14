package ws.service;

import jdk.nashorn.internal.runtime.Version;
import ws.model.Rekening;
import ws.model.RekeningBuilder;
import ws.util.RekeningRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RekeningService {
    private static List<Rekening> executeQuery(String query) throws Exception{
        String url = "jdbc:mysql://localhost:3306/wsbank";
        String user = "root";
        String password = "1256";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            List<Rekening> arrRekening = new ArrayList<Rekening>();
            while(rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String noRekening = rs.getString("no_rekening");
                String namaBank = rs.getString("nama_bank");

                Rekening rekening = new RekeningBuilder(id, nama, noRekening, namaBank)
                        .build();

                arrRekening.add(rekening);
            }
            con.close();
            return arrRekening;
        } catch (Exception e) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }
    private static List<Rekening> getRekeningByNoRekening(RekeningRequest rekeningRequest) throws Exception{
        String nomorTekait = rekeningRequest.getNoRekening();

        String query = "SELECT * FROM nasabah WHERE no_rekening = " + rekeningRequest.getNoRekening();
        try{
            return executeQuery(query);
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    public static Rekening getRekeningDetail(RekeningRequest rekeningRequest){
        try{
            List<Rekening> arrRekening = getRekeningByNoRekening(rekeningRequest);
            boolean exist = !arrRekening.isEmpty();
            if(exist){
                return arrRekening.get(0);
            } else{
                return new Rekening();
            }
        } catch (Exception e){
            return new Rekening();
        }
    }
}
