package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceProvider;

@SuppressWarnings("serial")
@WebServlet(value = "/deleteSelectedStudent")
public class DeleteSelectedStudentController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		
		String []student_emails = req.getParameterValues("stu_email");
		
		try
		{
			if(student_emails == null || student_emails.length == 0) {
				resp.sendRedirect("Search.jsp");
			}
			
			ServiceProvider.deleteUsers(student_emails);
			
			resp.sendRedirect("Search.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
