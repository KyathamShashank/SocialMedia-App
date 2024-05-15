package insta.friends;

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

@WebServlet("/request")
public class RequestServlet extends HttpServlet
 {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String me =AllDetails.getUserName();
	String friend=req.getParameter("friendname");
	PrintWriter pw = resp.getWriter();
	ResultSet alreadyFollowing=RequestDAO.alreadyFollow(friend,me);
	
	try {
		 if(alreadyFollowing.next())
		 {
		   RequestDispatcher rd = req.getRequestDispatcher("socialHome.jsp");
		   rd.forward(req, resp);
		 }
		else
		{
			int ifollowed=RequestDAO.following(me, friend);
			int getfollow =RequestDAO.follower(friend,me);
		    if(ifollowed>0 && getfollow>0) {
		    	RequestDispatcher rd = req.getRequestDispatcher("socialHome.jsp");
				   rd.forward(req, resp);
		    }
			else {
				RequestDispatcher rd = req.getRequestDispatcher("fail.html");
				   rd.forward(req, resp);
			}
			
		}
	} catch (SQLException e) {e.printStackTrace();}
	
}
}
