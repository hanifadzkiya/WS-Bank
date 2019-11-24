package ws.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TokenValidator {
  /**
   * executreQuery.
   * @param token String
   * @return boolean
   */
  public static Boolean validateToken(String token) {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";
    String query = "SELECT * FROM banktoken WHERE token = '" + token + "';";
  
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(url, user, password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);

      if (rs.next()) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }
}
