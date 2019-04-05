package controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Exam;
import service.ConnectionProvider;
import service.ServiceProvider;

@WebServlet(value = "/SearchStudentFromCompany")
public class SearchStudentFromCompanyController extends HttpServlet {

	/**
	 * In this class we will fetch the company requirement and select the students
	 * who Qualifies the criteria.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {

//		String name_student = req.getParameter("name");

//		String email_student = req.getParameter("email");

		String gender = req.getParameter("gender");

//		String city_student = req.getParameter("city");

		String[] education = req.getParameterValues("edu");

		String[] passout = req.getParameterValues("passout");

		String[] lang = req.getParameterValues("lang");

		String grade = req.getParameter("grade");

		PrintWriter out = null;

		Connection conn = null;
		
		HttpSession session = null;

		try {
			out = resp.getWriter();

			/*
			 * 
			 * // for debug. out.println(name_student); out.println(email_student);
			 * out.println(gender); out.println(city_student);
			 * 
			 */

			/*
			 * // for debug. for(String s : education) { out.println(s); } for(String s :
			 * passout) { out.println(s); } for(String s : lang) { out.println(s); }
			 * out.println(grade);
			 * 
			 */

			int[] min_max = ServiceProvider.minMaxFromString(grade);

			int min = min_max[0];
			int max = min_max[1];

			conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			ArrayList<Exam> AllStudent = new ArrayList<>();

			ArrayList<Exam> selected_student = new ArrayList<>();

			String sql = "select  student.email,name,gender,city,contact,education,passout,lang,grade from student inner join examresult on  student.email = examresult.email;";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				AllStudent.add(new Exam(rs.getString("email"),rs.getString("lang"), rs.getString("grade"),rs.getString("name"), rs.getString("gender"),
						rs.getString("city"), rs.getString("contact"), rs.getString("education"),
						rs.getString("passout")));
			}

			
			/*
			for(Exam sel:AllStudent) {
				
				out.println(sel.getEmail());
				out.println(sel.getGrade());
				out.println(sel.getName());
				
				out.println(sel.getCity());
				out.println(sel.getGender());
				out.println(sel.getContact());
				out.println(sel.getPassout());
				out.println(sel.getLang());
				out.println(sel.getEducation());
				
				
			} */
			
			// Now filtering our students and add to selected student list .

			
			
			for (Exam s : AllStudent) {
				boolean resEdu = Arrays.asList(education).contains(s.getEducation());

				boolean resPas = Arrays.asList(passout).contains(s.getPassout());

				boolean resProgLang = Arrays.asList(lang).contains(s.getLang());

				float s_grade = Float.parseFloat(s.getGrade());

				boolean resGrade = (s_grade >= min && s_grade <= max);

				boolean resGender = s.getGender().equalsIgnoreCase(gender);

				if (resEdu && resPas && resProgLang && resGrade && resGender) {
					selected_student.add(s);
				}

			/*	else if (s.getName().equalsIgnoreCase(name_student)) {
					if (!selected_student.contains(s)) {
						selected_student.add(s);
					}
				}

				else if (s.getEmail().equalsIgnoreCase(email_student)) {
					if (!selected_student.contains(s)) {
						selected_student.add(s);
					}
				}

				else if (s.getCity().equalsIgnoreCase(city_student)) {
					if (!selected_student.contains(s)) {
						selected_student.add(s);
					}
				} */

			}
			
			
			/* for debug.
			for(Exam sel:selected_student) {
				out.println(sel.getEmail());
				out.println(sel.getGrade());
				out.println(sel.getName());
			}
			*/
			
			// sending company to result page.
			
			session = req.getSession();
			
			session.setAttribute("selectedStudent", selected_student);
			
			resp.sendRedirect("showSelectedStudent.jsp");
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
