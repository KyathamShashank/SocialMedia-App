package insta.home;

import java.io.IOException;
import java.io.PrintWriter;

import insta.common.AllDetails;
import insta.register.InstaRegBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deleteAccount")
public class DeleteAccount extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String userName=req.getParameter("username");
	String password=req.getParameter("password");
	
//	String u=AllDetails.getUserName();
//	String p=AllDetails.getPassword();
//	PrintWriter pw = resp.getWriter();
//	
//	pw.print(userName);
//	pw.print(u);
//	pw.print(password);
//	pw.print(p);
	
	 
	 if(AllDetails.getUserName().equals(userName) && AllDetails.getPassword().equals(password))
	 {
	  int deleted=DeleteDAO.deleteAccount(userName, password);
	  if(deleted>0)
	   {
		RequestDispatcher rd= req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	    }
	   else
	   {
		
		RequestDispatcher rd= req.getRequestDispatcher("delete.html");
		rd.forward(req, resp);
	   }
	 }
	 else
	 {
		 RequestDispatcher rd= req.getRequestDispatcher("delete.html");
			rd.forward(req, resp);
	 }
 }
}
