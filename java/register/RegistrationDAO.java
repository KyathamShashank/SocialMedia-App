package insta.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationDAO 
{
 static int insert;
 public static int registerNewUser(InstaRegBean b)
 {
	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
		PreparedStatement pstmt= con.prepareStatement("insert into insta_users_table values(?,?,?,?,user_id.nextval)");
		pstmt.setString(1,b.getUserName());
		pstmt.setString(2,b.getPassword());
		pstmt.setString(3,b.getMailId());
		pstmt.setInt(4,b.getNumber());
		insert=pstmt.executeUpdate();
		PreparedStatement pstmt1= con.prepareStatement("insert into insta_users_profilepic values(?,'')");
		pstmt1.setString(1,b.getUserName());
		pstmt1.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
	 return insert;
 }
}
