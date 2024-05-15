package insta.friends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FollowingDAO {
	static ResultSet following;
	 public static ResultSet getFollowing(String me)
	 {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			PreparedStatement pstmt= con.prepareStatement("select following from insta_users_following where username=?");
			pstmt.setString(1,me);
			
			following=pstmt.executeQuery();
			}catch(Exception e) {System.out.println(e);}
		 return following;
	 }
}
