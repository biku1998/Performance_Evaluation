package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceProvider;

@WebServlet(value="/deleteSelectedQuestion")
public class DeleteQuestions extends HttpServlet {

	private static final long serialVersionUID = -102792518900095631L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		
		try {
			
			String [] ques_id = req.getParameterValues("ques_id");
			
			if(ques_id == null || ques_id.length == 0) {
				resp.sendRedirect("deletequestion.jsp");
			}
			
			ServiceProvider.deleteQuestions(ques_id);
			
			resp.sendRedirect("deletequestion.jsp");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
