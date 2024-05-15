package insta.message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MessageDAO {
static int msgsent;

public static int sendMessage(String sender,String receiver,String message)
{
	try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
		PreparedStatement pstmt= con.prepareStatement("insert into insta_users_messages values(?,?,?)");
		pstmt.setString(1,sender);
		pstmt.setString(2,receiver);
		pstmt.setString(3,message);
		
		
	    msgsent=pstmt.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
	 return msgsent;
}

static ResultSet msgs;
public static ResultSet getMessages(String receiver,String sender)
{
	try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LION");
		PreparedStatement pstmt= con.prepareStatement("select message from insta_users_messages where receiver=? and sender=?");
		pstmt.setString(1,receiver);
		pstmt.setString(2,sender);
		
		msgs=pstmt.executeQuery();
		
		}catch(Exception e) {System.out.println(e);}
	 return msgs;
}
}
