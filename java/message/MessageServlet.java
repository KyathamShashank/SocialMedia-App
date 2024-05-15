package insta.message;

import java.io.IOException;
import java.io.PrintWriter;

import insta.common.AllDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/sendmsg")
public class MessageServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String sender=AllDetails.getUserName();
	String receiver=req.getParameter("friendname");
	String message=req.getParameter("message");
	
	PrintWriter pw =resp.getWriter();
	int msgsent=MessageDAO.sendMessage(sender, receiver, message);
	if(msgsent>0)pw.print("Messsage sent");
	else pw.print("Message not sent");
	RequestDispatcher rd = req.getRequestDispatcher("messages.jsp");
	rd.forward(req, resp);
	
}
}
