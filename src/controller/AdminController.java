package controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceProvider;

@SuppressWarnings("serial")
@WebServlet(value = "/adminVerify")
public class AdminController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out = null;
		try {
			out = resp.getWriter();
//			out.print("Hello admin");  // for debug.
			HttpSession session = req.getSession();
			// getting the admin info from html.

			String admin_id = req.getParameter("adminid");
			String admin_password = req.getParameter("password");

			// sending data to ServiceProvider to authorize.

			boolean res = ServiceProvider.authAdmin(admin_id, admin_password);

			if (res) {
				// sending admin to admin panel.
				//session.setAttribute("logedIn", "yes");
				resp.sendRedirect("adminPanel.jsp");

			} else {
				resp.sendRedirect("admin.jsp");
				String htmlCode = "<script>alert('Incorrect id or password.')</script>";
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
