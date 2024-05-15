package insta.home;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import insta.common.AllDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@MultipartConfig()
@WebServlet("/uploadprofile")
public class UpdateProfileServlet extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String userName=AllDetails.getUserName();
	 Part img= req.getPart("profilepic");
		String fileName=img.getSubmittedFileName();
		int updateProfile=UpdateProfileDAO.uploadProfile(userName, fileName);
		
		String uploadPath="C:/Users/kyath/OneDrive/Desktop/Myprojects/SocialMediaApplication/src/main/webapp/"+fileName;
		FileOutputStream fos = new FileOutputStream(uploadPath);
		
		InputStream is=img.getInputStream();
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		
		if(updateProfile>0)
		{	
			RequestDispatcher rd= req.getRequestDispatcher("socialHome.jsp");
			rd.forward(req, resp);
		}
		else
		{
			PrintWriter pw = resp.getWriter();
			pw.print("image failed");
		}
}
}
