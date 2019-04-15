package controller;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Company;
import service.ServiceProvider;

@SuppressWarnings("serial")
@WebServlet(value = "/CompanyListAdmin")
public class CompanyListAdminController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		
		try
		{
			HttpSession session = req.getSession();
			ArrayList<Company> allCompany = ServiceProvider.getAllCompanyList();
			
			if(!(allCompany == null))
			{
				// sending user to display all the student list.
				session.setAttribute("all_Company", allCompany);
				resp.sendRedirect("showCompToAdmin.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
