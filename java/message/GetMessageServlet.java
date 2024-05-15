package insta.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import insta.common.AllDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/getMessages")
public class GetMessageServlet extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	AllDetails.setFriendName(req.getParameter("friendname"));
	String user=AllDetails.getUserName();
	String fr=AllDetails.getFriendName();
	
	
	PrintWriter pw = resp.getWriter();
	
	ResultSet rs = MessageDAO.getMessages(user,fr);
	try {
		while(rs.next())
		{
			pw.print(rs.getString(1));
		}
	} catch (SQLException e) {e.printStackTrace();}
	
	RequestDispatcher rd = req.getRequestDispatcher("messages.jsp");
	rd.forward(req, resp);
}
}
