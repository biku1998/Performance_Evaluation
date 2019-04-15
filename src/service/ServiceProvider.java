package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import model.Company;
import model.Question;
import model.Student;

public class ServiceProvider {

	// for uploading Student object in the database.

	public static void uploadStudentToDatabase(Student student) {

		try {
			// getting Connection of DB from Connection Provider.

			Connection conn = ConnectionProvider.getConnection();

			if (!(conn == null)) {

				// getting statement..

				Statement statement = conn.createStatement();

				String sql = String.format("insert into student values('%s','%s','%s','%s','%s','%s','%s','%s')",
						student.getEmail(), student.getName(), student.getPassword(), student.getGender(),
						student.getCity(), student.getContact(), student.getEducation(), student.getPassout());

				statement.execute(sql);

			} else {
				System.out.println("Connection not found......");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean authAdmin(String admin_id, String admin_password) {
		// for checking admin credentials.

		try {
			Connection conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			String sql = String.format("select * from admin_PE where admin_id = '%s' and password = '%s'", admin_id,
					admin_password);

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean authStudent(String email_id, String password) {
		try {
			Connection conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			String sql = String.format("select * from student where email = '%s' and password = '%s'", email_id,
					password);

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean addQuestionToDB(Question q) {
		try {
			Connection conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			String sql = String.format("insert into question values('%s','%s','%s','%s','%s','%s','%s')",
					q.getSubject(), q.getQues_id(), q.getQues(), q.getOption1(), q.getOption2(), q.getOption3(),
					q.getCorrect_ans());

			boolean rs = st.execute(sql);
			// System.out.println(rs);

			if (rs == false) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	public static ArrayList<Question> getQuestions(String subject) {

		// this function will return all the questions for the given subject.

		ArrayList<Question> ques = new ArrayList<>();

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();

			String sql = String.format("select * from question where subject = '%s'", subject);

			// String sql = "select * from question";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				ques.add(new Question(rs.getString("subject"), rs.getString("ques_id"), rs.getString("ques"),
						rs.getString("option1"), rs.getString("option2"), rs.getString("option3"),
						rs.getString("correct_ans")));
			}

			return ques;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteQuestions(String[] ques_id) {
		// this function will delete the question for the provided id.
		try {

			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			for (String q_id : ques_id) {
				String sql = String.format("delete from question where ques_id = '%s'", q_id);
				st.execute(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteUsers(String[] user_email) {
		// this function will delete the question for the provided id.
		try {

			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			for (String email : user_email) {
				String sql = String.format("delete from examresult where email = '%s'", email);
				String sq2 = String.format("delete from student where email = '%s'", email);
				st.execute(sql);
				st.execute(sq2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteCompany(String[] comp_names) {
		// this function will delete the question for the provided id.
		try {

			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			for (String comp : comp_names) {
				String sql = String.format("delete from company where company_name = '%s'", comp);
				
				st.execute(sql);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LinkedHashSet<String> getSubjects() {
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			LinkedHashSet<String> sub = new LinkedHashSet<String>();
			String sql = "select * from question";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				sub.add(rs.getString("subject").trim().toLowerCase());
			}

			return sub;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static LinkedHashSet<String> getPassoutList() {

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			LinkedHashSet<String> passout = new LinkedHashSet<String>();
			String sql = "select (passout) from student";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				passout.add(rs.getString("passout"));
			}
			passout.remove("null");
			return passout;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static LinkedHashSet<String> getEducationList() {

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			LinkedHashSet<String> eduList = new LinkedHashSet<String>();
			String sql = "select (education) from student";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				eduList.add(rs.getString("education"));
			}
			eduList.remove("null");
			return eduList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int[] minMaxFromString(String data) {

		// data = "30-60"

		String[] sub_array = data.split("-");
		int min = Integer.parseInt(sub_array[0].trim());
		int max = Integer.parseInt(sub_array[1].trim());

		return new int[] { min, max };

	}

	public static ArrayList<Student> getAllstudentList() {

		ArrayList<Student> allStudent = new ArrayList<>();

		try {
			Connection conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			String sql = "select * from student";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Student s = new Student(rs.getString("email"), rs.getString("name"), rs.getString("password"),
						rs.getString("gender"), rs.getString("city"), rs.getString("contact"),
						rs.getString("education"), rs.getString("passout"));

				allStudent.add(s);

			}

			return allStudent;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static ArrayList<Company> getAllCompanyList() {

		ArrayList<Company> allCompany = new ArrayList<>();

		try {
			Connection conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			String sql = "select * from company";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Company c = new Company(rs.getString("company_name"), rs.getString("password"));
				allCompany.add(c);
			}

			return allCompany;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
