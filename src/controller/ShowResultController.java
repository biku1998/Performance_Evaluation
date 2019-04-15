package controller;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// In this class we will store student grades in the database.

import model.Question;
import service.ConnectionProvider;

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
		Connection conn  = null;
		try {
			
			session   = req.getSession();
			out = resp.getWriter();
			// debug : printing the all the ans , q_id and current User Info.
			
			// getting the questions : 
			
			ArrayList<Question>	questions = (ArrayList<Question>)session.getAttribute("Questions");
			
			LinkedHashMap<String, String> answers = (LinkedHashMap<String, String>)session.getAttribute("ansStore");
			
			ArrayList<String>  ans = new ArrayList<String>(answers.values());
			
			String curr_usr_email = String.valueOf(session.getAttribute("currentUser"));
			
			String current_subject = String.valueOf(session.getAttribute("currentSubject"));
			
			// getching the current user name .
			
			conn = ConnectionProvider.getConnection();
			
			Statement st  = conn.createStatement();
			
			String sql = String.format("select * from student where email = '%s'",curr_usr_email);
			
			ResultSet rs = st.executeQuery(sql);
			
			String curr_user_name = "";
			
			while(rs.next())
			{
				curr_user_name = rs.getString("name");
			}
			
			
			
			
			int total_marks = questions.size() * 10; // 10 marks per question.
			
			int marks_obtained = 0;
			
			
			
			/*
			
			For debug.
			
			for(Question s : questions) {
				out.println(s.getCorrect_ans());
			}
			
			for(String s:ans) {
				out.println(s);
			} */
			
			for (int i = 0; i < questions.size(); i++) {
				if((questions.get(i).getCorrect_ans()).equalsIgnoreCase(ans.get(i))) {
					marks_obtained += 10;
				}
			}
			
			float percentage = ((float)marks_obtained / (float)total_marks) * 100;
			
			
			// storing user marks in database.
			
			String sql2 = String.format("insert into examresult values('%s','%s','%s')",curr_usr_email,
					current_subject,String.valueOf(percentage));
			
			st.execute(sql2);
			
			
			String [] info  = {curr_user_name,curr_usr_email,current_subject,
					String.valueOf(marks_obtained),String.valueOf(total_marks)
					,String.valueOf(percentage)};
			
			session.setAttribute("userReportInfo", info);
			
			resp.sendRedirect("studentReportView.jsp");
			
			
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
