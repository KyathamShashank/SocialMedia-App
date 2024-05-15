package insta.home;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageDAO {
static int uploadImg;static ResultSet imgs;

public static int upload(String userName, String fileName)
{

	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
		PreparedStatement pstmt= con.prepareStatement("insert into insta_users_photos values(?,?)");
		pstmt.setString(1,userName);
		pstmt.setString(2,fileName);
		
		uploadImg=pstmt.executeUpdate();

		}catch(Exception e) {System.out.println(e);}
	 return uploadImg;
}

public static ResultSet getImages(String userName)
{
	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
		PreparedStatement pstmt= con.prepareStatement("select imgname from insta_users_photos where username=?");
		pstmt.setString(1,userName);
		imgs=pstmt.executeQuery();

		}catch(Exception e) {System.out.println(e);}
	 return imgs;
}

}
