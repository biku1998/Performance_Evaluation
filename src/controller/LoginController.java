package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceProvider;

@SuppressWarnings("serial")
@WebServlet(value = "/studentAuthentication")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		// getting data from html.
		String email_id = req.getParameter("email");
		String password = req.getParameter("password");

		boolean res = ServiceProvider.authStudent(email_id, password);
		try {
			if (res) {
				resp.sendRedirect("examSelection.jsp");
			} else {
				resp.sendRedirect("signup.jsp");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
