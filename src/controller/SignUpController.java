package controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import service.ServiceProvider;

@SuppressWarnings("serial")
@WebServlet( value = "/signupStudent")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		
		PrintWriter out;
		
		try
		{
			out = resp.getWriter();
			
			// getting the data of HTML to insert into database.
			
			String name = req.getParameter("name");
			String email  = req.getParameter("email");
			String password = req.getParameter("password");
			String gender = req.getParameter("gender");
			String city = req.getParameter("city");
			String contact = req.getParameter("contact");
			String education = req.getParameter("education");
			String passout = req.getParameter("passout");
			
			/* For debug.
			out.println("<h3>"+name+"</h3>");
			out.println("<h3>"+email+"</h3>");
			out.println("<h3>"+password+"</h3>");
			out.println("<h3>"+gender+"</h3>");
			out.println("<h3>"+city+"</h3>");
			out.println("<h3>"+contact+"</h3>");
			out.println("<h3>"+education+"</h3>");
			out.println("<h3>"+passout+"</h3>");
	
			*/
			
			// creating object of Student and passing it to service provider to insert into DB.
			
			Student student = new Student(email, name, password, gender, city, contact, education, passout);
			
			ServiceProvider.uploadStudentToDatabase(student);
			
			// for debug.
			
//			out.println("Done ......");
			
			HttpSession session = req.getSession();
			
			session.setAttribute("currentUser", email);
			
			resp.sendRedirect("examSelection.jsp");
			
			
			
			
			
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
	}

}
