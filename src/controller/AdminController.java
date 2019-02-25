package controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value="/adminVerify")
public class AdminController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out = null;
		try
		{
			out = resp.getWriter();
			out.print("Hello admin");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
