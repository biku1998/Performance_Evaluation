package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ConnectionProvider;
import service.EmailServer;

@WebServlet(value = "/ForgotPassword")
public class ForgotPasswordController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {

		// This Module will send password of the user to their email.

		PrintWriter out = null;
		Connection conn = null;

		HttpSession session = null;

		try {

			String email = req.getParameter("email");

			out = resp.getWriter();

			conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			String password = "";

			String sql = String.format("select * from student where email = '%s'", email);

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				password = rs.getString("password");
			}

			final String passFinal = password;

			session = req.getSession();
			session.setAttribute("email_user", email);

			// Running code on 2 threads.

			Thread thread1 = new Thread() {
				public void run() {
					EmailServer.sendMail(email, passFinal);
				}
			};

			Thread thread2 = new Thread() {
				public void run() {
					try {
						resp.sendRedirect("wait.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			thread2.start();
			Thread.sleep(2000);
			thread1.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
