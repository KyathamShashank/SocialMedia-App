package insta.home;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;

import insta.register.InstaRegBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@MultipartConfig()
@WebServlet("/uploadimage")
public class ImagesServlet extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 InstaRegBean b= InstaRegBean.getBean();
	 
	String userName=b.getUserName();
	
	Part img= req.getPart("pic");
	String fileName=img.getSubmittedFileName();
	int uploadImg=ImageDAO.upload(userName, fileName);
	
	String uploadPath="C:/Users/kyath/OneDrive/Desktop/Myprojects/SocialMediaApplication/src/main/webapp/"+fileName;
	FileOutputStream fos = new FileOutputStream(uploadPath);
	
	InputStream is=img.getInputStream();
	byte[] data=new byte[is.available()];
	is.read(data);
	fos.write(data);
	fos.close();
	
	
	
	
	if(uploadImg>0)
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
