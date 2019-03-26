package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ConnectionProvider;

@WebServlet(value = "/CompanyRegister")
public class CompanyRegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp){
		
		Connection conn  = null;
		HttpSession session = null;
		
		try
		{
			String company_name = req.getParameter("compnameReg");
			String company_pass = req.getParameter("passwordReg");
			
			conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			
			String sql = String.format("insert into company values('%s','%s')",
					company_name,company_pass);
			
			String sql2 = String.format("select * from company where company_name = '%s' and password = '%s'",
					company_name,company_pass);
			
			ResultSet rs = st.executeQuery(sql2);
			
			session = req.getSession();
			
			if(rs.next()) {
				// company exists.
				resp.sendRedirect("company.jsp");
			}else {
				st.execute(sql);
				
				session.setAttribute("curr_company", company_name);
				resp.sendRedirect("companyDashboard.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
