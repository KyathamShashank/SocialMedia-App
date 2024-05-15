package insta.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import insta.common.AllDetails;
import insta.register.InstaRegBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 InstaRegBean b = InstaRegBean.getBean();
 b.setUserName(req.getParameter("username"));
 b.setPassword(req.getParameter("password"));
 
 AllDetails.setUserName(req.getParameter("username"));
 AllDetails.setPassword(req.getParameter("password"));
 
 ResultSet isUserExist=LoginDAO.loginUser(b);
 try {
	if(isUserExist.next())
	 {
		RequestDispatcher rd = req.getRequestDispatcher("socialHome.jsp");
		rd.forward(req, resp);
	 }
	else
	{
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}
    } catch (SQLException e) {e.printStackTrace();}
}
}
