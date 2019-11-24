package ws.service;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class TokenService {
  /**
   * validateToken yang diinginkan.
   * @param token String
   * @return boolean
   */
  public static boolean validateToken(String token) {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";
    String query = "SELECT * FROM banktoken WHERE token = '" + token + "'";
  
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

  /**
   * getRequestToken.
   * @return boolean
   */
  public static String getRequestToken() {
    String url =
        "jdbc:mysql://database-1.cxqar33fjxpj.ap-southeast-1.rds.amazonaws.com:3306/wsbank";
    String user = "engimabp";
    String password = "Bankpro234";
    String query = "SELECT * FROM banktoken WHERE ";
    query += " (TIME_TO_SEC(TIMEDIFF(NOW(), created_at)) < 3600);";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection con = DriverManager.getConnection(url, user, password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);

      if (rs.next()) {
        return rs.getString("token");
      } else {
        String generatedString = generateRandomString();
        query = "DELETE  FROM banktoken WHERE token = '" + generatedString + "';";
        st.execute(query);
        query = "INSERT INTO banktoken(token) VALUES '" + generatedString + "';";
        st.execute(query);
        return generatedString;
      }
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  /**
   * generateRandomString.
   * @return boolean
   */
  private static String generateRandomString() {
    byte[] array = new byte[10];
    new Random().nextBytes(array);
    String generatedString = new String(array, Charset.forName("UTF-8"));
    return generatedString;
  }
}
