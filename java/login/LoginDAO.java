package insta.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import insta.register.InstaRegBean;

public class LoginDAO 
{
	 static ResultSet isUserExist;
	 public static ResultSet loginUser(InstaRegBean b)
	 {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			PreparedStatement pstmt= con.prepareStatement("select * from insta_users_table where username=? and password=?");
			pstmt.setString(1,b.getUserName());
			pstmt.setString(2,b.getPassword());
			
		    isUserExist=pstmt.executeQuery();
			}catch(Exception e) {System.out.println(e);}
		 return isUserExist;
	 }
}
