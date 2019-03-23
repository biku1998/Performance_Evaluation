package controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/showResult")
public class ShowResultController extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
	
		PrintWriter out = null;
		HttpSession session = null;
		try {
			
			session   = req.getSession();
			out = resp.getWriter();
			// debug : printing the all the ans , q_id and current User Info.
			
			HashMap<String, String> answers = (HashMap<String, String>)session.getAttribute("ansStore");
			
			String curr_usr_email = String.valueOf(session.getAttribute("currentUser"));
			
			out.println(answers);
			out.println(curr_usr_email);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
