package insta.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchDAO {
 static ResultSet users;
 
 public static ResultSet getUsers(String searchUser)
 {
 	 try {
 		 Class.forName("oracle.jdbc.driver.OracleDriver");
 		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
 		PreparedStatement pstmt= con.prepareStatement("select username from insta_users_table where username like ? || '%'");
 		pstmt.setString(1,searchUser);
 		users=pstmt.executeQuery();

 		}catch(Exception e) {System.out.println(e);}
 	 return users;
 }
}
