package controller;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// In this class we will store student grades in the database.

import model.Question;

@WebServlet(value = "/showResult")
public class ShowResultController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
	
		PrintWriter out = null;
		HttpSession session = null;
		try {
			
			session   = req.getSession();
			out = resp.getWriter();
			// debug : printing the all the ans , q_id and current User Info.
			
			// getting the questions : 
			
			ArrayList<Question>	questions = (ArrayList<Question>)session.getAttribute("Questions");
			
			HashMap<String, String> answers = (HashMap<String, String>)session.getAttribute("ansStore");
			
			ArrayList<String>  ans = new ArrayList<String>(answers.values());
			
			String curr_usr_email = String.valueOf(session.getAttribute("currentUser"));
			
			String current_subject = String.valueOf(session.getAttribute("currentSubject"));
			
			
			int total_marks = questions.size() * 10; // 10 marks per question.
			
			int marks_obtained = 0;
			
			
			for (int i = 0; i < questions.size(); i++) {
				if((questions.get(i).getCorrect_ans()).equalsIgnoreCase(ans.get(i))) {
					marks_obtained += 10;
				}
			}
			
			out.print(total_marks);
			out.print(marks_obtained);
			
			
	
			/* For debug
			
			out.println(answers);
			
			out.println(curr_usr_email);
			
			out.println(current_subject);
			
			out.println(questions); */
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
