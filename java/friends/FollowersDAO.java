package insta.friends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import insta.register.InstaRegBean;

public class FollowersDAO {
	static ResultSet followers;
	 public static ResultSet getFollowers(String userName)
	 {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			PreparedStatement pstmt= con.prepareStatement("select followers from insta_users_followers where username=?");
			pstmt.setString(1,userName);
			
			followers=pstmt.executeQuery();
			}catch(Exception e) {System.out.println(e);}
		 return followers;
	 }
}
