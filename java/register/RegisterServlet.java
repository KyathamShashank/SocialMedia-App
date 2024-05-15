package insta.register;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	InstaRegBean userDetails=InstaRegBean.getBean();
     
	userDetails.setMailId(req.getParameter("gmail"));
	userDetails.setNumber(Integer.parseInt(req.getParameter("mobile")));
	userDetails.setUserName(req.getParameter("username"));
	userDetails.setPassword(req.getParameter("password"));

	int insert =RegistrationDAO.registerNewUser(userDetails);
	if(insert>0)
	{
		RequestDispatcher rd= req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}
	else
	{
		PrintWriter pw = resp.getWriter();
		pw.print("RegistrationFail");
		RequestDispatcher rd= req.getRequestDispatcher("register.html");
		rd.include(req, resp);
	}
	}
	}


