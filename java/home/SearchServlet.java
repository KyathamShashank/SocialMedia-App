package insta.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import insta.common.AllDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class SearchServlet extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String searchUser=req.getParameter("searchBar");
	ResultSet usersList = SearchDAO.getUsers(searchUser);
	
	ArrayList<String> users= new ArrayList<String>();
	int i=0;
	try {
		while(usersList.next())
		{
			String user=usersList.getString(1);
			users.add(user);
			i++;
		}
		AllDetails.setUsersList(users);
	} catch (SQLException e) {e.printStackTrace();}
	
		RequestDispatcher rd = req.getRequestDispatcher("socialHome.jsp");
		rd.forward(req, resp);
	
	
}
}
