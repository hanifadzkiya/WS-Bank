package ws.service;

import jdk.nashorn.internal.runtime.Version;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewVirtualAccountService{

    public static String createNew(String nomorRekening) throws Exception{
        String url = "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
        String user = "engimabp";
        String password = "Bankpro234";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);

            long cons = 1999072746;
            long newVirtualAccountNumber = Long.parseLong(nomorRekening) + cons;

            PreparedStatement ps = con.prepareStatement
                    ("select * from nasabah where no_rekening = "+nomorRekening+";");
            ResultSet rs = ps.executeQuery();
            rs.next();

            int id_rekening = rs.getInt("id");

            ps = con.prepareStatement
                    ("insert into akun_virtual (no_akun_virtual, id_rekening) " +
                            "values ("+newVirtualAccountNumber+","+id_rekening+");");
            ps.executeUpdate();

            String result = "Berhasil, dengan nomor akun virtual : "+newVirtualAccountNumber;
            return result;
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }
}
