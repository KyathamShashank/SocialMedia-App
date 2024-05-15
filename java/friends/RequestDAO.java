package insta.friends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RequestDAO {
	static int ifollowed; static int getfollow;
	 public static int following(String me, String friend)
	 {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			PreparedStatement pstmt= con.prepareStatement("insert into insta_users_following values(?,?)");
			pstmt.setString(1,me);
			pstmt.setString(2,friend);
			ifollowed=pstmt.executeUpdate();
			
		 }catch(Exception e) {System.out.println(e);}
		 return ifollowed;
	 }
	 
	 
	 
	 public static int follower(String friend, String me)
	 {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			
			PreparedStatement pstmt1= con.prepareStatement("insert into insta_users_followers values(?,?)");
			pstmt1.setString(1,friend);
			pstmt1.setString(2,me);
			getfollow=pstmt1.executeUpdate();
			
			
		

			}catch(Exception e) {System.out.println(e);}
		 return getfollow;
	 }
	 
	static ResultSet alreadyFollowing;
	public static ResultSet alreadyFollow(String friend,String me)
	{
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
			
			PreparedStatement pstmt1= con.prepareStatement("select followers from insta_users_followers where username=? and followers=?");
			pstmt1.setString(1,friend);
			pstmt1.setString(2,me);
			alreadyFollowing=pstmt1.executeQuery();
			
			}catch(Exception e) {System.out.println(e);}
		 return alreadyFollowing;
	}
}
