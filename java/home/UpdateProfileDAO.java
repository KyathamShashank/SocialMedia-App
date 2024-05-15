package insta.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;

public class UpdateProfileDAO {
	static int uploadProfile;static ResultSet getprofile;

	public static int uploadProfile(String userName, String fileName)
	{

		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			PreparedStatement pstmt= con.prepareStatement("update insta_users_profilepic set profilepicname=? where username=?");
			pstmt.setString(1,fileName);
			pstmt.setString(2,userName);
			
			uploadProfile=pstmt.executeUpdate();

			}catch(Exception e) {System.out.println(e);}
		 return uploadProfile;
	}

	public static ResultSet getProfile(String userName)
	{
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			PreparedStatement pstmt= con.prepareStatement("select profilepicname from insta_users_profilepic where username=?");
			pstmt.setString(1,userName);
			getprofile=pstmt.executeQuery();

			}catch(Exception e) {System.out.println(e);}
		 return getprofile;
	}
}
