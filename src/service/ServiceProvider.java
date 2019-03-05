package service;

import java.sql.*;
import java.util.ArrayList;


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

			String sql = String.format("insert into question values('%s','%s','%s','%s','%s','%s','%s')",q.getSubject(),
			q.getQues_id(),q.getQues(),q.getOption1(),q.getOption2(),q.getOption3(),q.getCorrect_ans());

			boolean rs = st.execute(sql);
			//System.out.println(rs);

			if (rs == false) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	public static ArrayList<Question> getQuestions(String subject){
		
		// this function will return all the questions for the given subject.
		
		ArrayList<Question> ques = new ArrayList<>();
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			
			String sql = String.format("select * from question where subject = '%s'", subject);
			
			//String sql = "select * from question";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				ques.add(new Question(rs.getString("subject"), rs.getString("ques_id"), rs.getString("ques"),
						rs.getString("option1"),rs.getString("option2"), rs.getString("option3"), 
						rs.getString("correct_ans")));
			}
			
			return ques;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void deleteQuestions(String [] ques_id) {
		// this function will delete the question for the provided id.
		try {

			Connection conn  = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			for(String q_id : ques_id) {
				String sql = String.format("delete from question where ques_id = '%s'", q_id);
				st.execute(sql);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
