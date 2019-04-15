package controller;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import service.ServiceProvider;

@SuppressWarnings("serial")
@WebServlet(value = "/StudentListAdmin")
public class StudentListAdminController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {

		try
		{
			HttpSession session = req.getSession();
			ArrayList<Student> allStudent = ServiceProvider.getAllstudentList();
			
			if(!(allStudent == null))
			{
				// sending user to display all the student list.
				session.setAttribute("all_Student", allStudent);
				resp.sendRedirect("showStuToAdmin.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
