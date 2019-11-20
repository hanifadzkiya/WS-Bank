package ws.service;

import jdk.nashorn.internal.runtime.Version;
import ws.model.Rekening;
import ws.model.RekeningBuilder;
import ws.util.NasabahRequest;
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
    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/wsbank";
    private static String user = "root";
    private static String password = "1256";
    private static ResultSet executeQuery(String query) throws Exception{
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

    private static List<Rekening> getListRekeningFromResultSet(ResultSet rs) throws Exception{
        try {
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
            return arrRekening;
        } catch (Exception e) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    private static int getSaldoFromResultSet(ResultSet rs) throws Exception{
        try {
            int saldo;
            while(rs.next()){
                saldo = rs.getInt("saldo");
            }
            return 2000;
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
            con = DriverManager.getConnection(url, user, password);
            ResultSet rs = executeQuery(query);
            List<Rekening> arrRekening = getListRekeningFromResultSet(rs);
            con.close();
            return arrRekening;
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    private static List<Rekening> getRekeningByidNasabah(NasabahRequest nasabahRequest) throws Exception{
         String idNasabah = nasabahRequest.getIdNasabah();

        String query = "SELECT * FROM nasabah WHERE id = " + idNasabah;
        try{
            con = DriverManager.getConnection(url, user, password);
            ResultSet rs = executeQuery(query);
            List<Rekening> arrRekening = getListRekeningFromResultSet(rs);
            con.close();
            return arrRekening;
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    public static int getSaldoByNoRekeningQuery(RekeningRequest rekeningRequest) throws Exception{
        String nomorTekait = rekeningRequest.getNoRekening();

        String query = "SELECT * FROM nasabah WHERE no_rekening = " + rekeningRequest.getNoRekening();
        try{
            con = DriverManager.getConnection(url, user, password);
            ResultSet rs = executeQuery(query);
            List<Rekening> arrRekening = getListRekeningFromResultSet(rs);
            con.close();
            return 20000;
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }


    public static int getSaldoByIdNasabah(NasabahRequest nasabahRequest){
        return 2000;
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

    public static Rekening getRekeningDetailByIdNasabah(NasabahRequest nasabahRequest){
        try{
            List<Rekening> arrRekening = getRekeningByidNasabah(nasabahRequest);
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
