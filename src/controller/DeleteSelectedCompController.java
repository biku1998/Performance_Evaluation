package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceProvider;

@SuppressWarnings("serial")
@WebServlet(value = "/deleteSelectedComp")
public class DeleteSelectedCompController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		
		String []comp_names = req.getParameterValues("cmp_name");
		
		try
		{
			if(comp_names == null || comp_names.length == 0) {
				resp.sendRedirect("Search.jsp");
			}
			
			ServiceProvider.deleteCompany(comp_names);
			
			resp.sendRedirect("Search.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
