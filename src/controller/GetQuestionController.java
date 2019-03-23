package controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;
import service.ConnectionProvider;

@WebServlet(value = "/getQuestions")
public class GetQuestionController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
	
		String subject = req.getParameter("subject");
		PrintWriter out = null;
		
		ArrayList<Question> questions = new ArrayList<>();
		
		try
		{
//			out = resp.getWriter();
//			out.println(subject);
			
			Connection conn = ConnectionProvider.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = String.format("select * from question where subject = '%s'", subject);
			
			ResultSet rs = st.executeQuery(sql);
			
			HttpSession session = req.getSession();
			
			HashMap<String, String> userAnswer = new HashMap<>();
			
			while(rs.next()) {
				questions.add(new Question(rs.getString("subject"),
						rs.getString("ques_id"), rs.getString("ques"),rs.getString("option1")
						,rs.getString("option2"),rs.getString("option3"),rs.getString("correct_ans")));
			}
			
			// creating placeholder for tracking question number and answers for the user.
			
			//System.out.println(questions);
			
			
			
			
			
			
//			RequestDispatcher rd  = req.getRequestDispatcher("startQuiz.jsp");
//			
//			req.setAttribute("Questions", questions);
//			
//			rd.forward(req, resp);
			
			// putting questions , q_no and answer storage in session.
			
			session.setAttribute("q_no", 0);
			
			session.setAttribute("ansStore", userAnswer);
			
			session.setAttribute("Questions", questions);
			
			resp.sendRedirect("startQuiz.jsp");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
