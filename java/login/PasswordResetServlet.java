package insta.login;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/reset")
public class PasswordResetServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String userName=req.getParameter("username");
	int mobile= Integer.parseInt(req.getParameter("mobile"));
	String password=req.getParameter("newPassword");
	
	int updatePassword=PasswordDAO.updatePassword(password, userName, mobile);
	
	if(updatePassword>0)
	{
		RequestDispatcher rd= req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}
	else
	{
		RequestDispatcher rd= req.getRequestDispatcher("passwordReset.html");
		rd.forward(req, resp);
	}
}
}
