package insta.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteDAO {
	static int deleted;
	 public static int deleteAccount(String userName,String password)
	 {
	 	 try {
	 		 Class.forName("oracle.jdbc.driver.OracleDriver");
	 		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
	 		PreparedStatement pstmt= con.prepareStatement("delete from insta_users_table where username=? and password=?");
	 		pstmt.setString(1,userName);
	 		pstmt.setString(2,password);
	 		deleted=pstmt.executeUpdate();

	 		}catch(Exception e) {System.out.println(e);}
	 	 return deleted;
	 }
}
