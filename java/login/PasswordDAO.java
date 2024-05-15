package insta.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import insta.register.InstaRegBean;

public class PasswordDAO {
	static int updatePassword;
	 public static int updatePassword(String password,String userName,int mobile)
	 {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			PreparedStatement pstmt= con.prepareStatement("update insta_users_table set password=? where username=? and mobilenumber=?");
			pstmt.setString(1,password);
			pstmt.setString(2,userName);
			pstmt.setInt(3, mobile);
			
            updatePassword=pstmt.executeUpdate();			 
			}catch(Exception e) {System.out.println(e);}
		 return updatePassword;
	 }
}
