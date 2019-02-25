package service;

import java.sql.*;

import model.Student;

public class ServiceProvider {

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

}
