package controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;
import service.ServiceProvider;

@WebServlet(value = "/addQuestion")
public class AddQuestionController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		try
		{
			PrintWriter out;
			
			// getting the data from html.
			String subject = req.getParameter("subject");
			String ques_id = req.getParameter("id");
			String ques = req.getParameter("ques");
			String option1 = req.getParameter("option1");
			String option2 = req.getParameter("option2");
			String option3 = req.getParameter("option3");
			String correct_ans = req.getParameter("correct_ans");
			
			// packing the data into Question object.
			Question q = new Question(subject, ques_id, ques, option1, option2, option3, correct_ans);
			
			// sending the packet to service provider to insert into database.
			
			if(ServiceProvider.addQuestionToDB(q) == false) {
				String htmlCode = "<script>alert('question added.')</script>";
				out = resp.getWriter();
				out.println(htmlCode);
				resp.sendRedirect("addquestion.jsp");
				
			}
			else {
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
