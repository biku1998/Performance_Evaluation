package controller;



import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import service.ServiceProvider;

@WebServlet(value = "/searchQuestions")
public class ShowQuestionToDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
	
		try {
			// getting the subject from jsp.
			
			String subject = req.getParameter("subject");
			
			ArrayList<Question> ques = ServiceProvider.getQuestions(subject);
			
			//System.out.println(ques);
			

			if(!ques.isEmpty()) {
				//System.out.println(ques);
				
				RequestDispatcher rd = req.getRequestDispatcher("showQuestionToDel.jsp");
				req.setAttribute("Subquestions", ques);
				rd.forward(req, resp);

			}else {
				resp.sendRedirect("deletequestion.jsp");
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("showQuestionToDel.jsp");
			req.setAttribute("questions", ques);
			rd.forward(req, resp);
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
