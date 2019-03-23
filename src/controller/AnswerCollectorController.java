package controller;

import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/answerCollector")
public class AnswerCollectorController extends  HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// job of this servlet is to collect the answer and pass the user to the quiz page again.
	
	HashMap<String, String> ans = null;	
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		
		String q_id  = req.getParameter("ques_id");
		String user_ans = req.getParameter("opn");
		
		try {
			HttpSession session = req.getSession();
			ans = (HashMap<String, String>)session.getAttribute("ansStore");
			ans.put(q_id, user_ans);
			
//			System.out.println(ans);
			
			// store the ans Storage back to session.
			session.setAttribute("ansStore", ans);
			int q_no = Integer.parseInt((String.valueOf(session.getAttribute("q_no"))));
//			System.out.println(q_no);
			q_no = q_no + 1;
//			System.out.println(q_no);
			session.setAttribute("q_no", q_no);
			// send the user back 
			resp.sendRedirect("startQuiz.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
}
