package insta.friends;

import java.io.IOException;

import insta.common.AllDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getfollowing")
public class FollowingServlet extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher rd = req.getRequestDispatcher("socialHome.jsp");
    rd.forward(req, resp);
}
}
