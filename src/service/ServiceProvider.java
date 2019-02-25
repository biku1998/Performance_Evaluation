package service;

import java.sql.*;

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
	
	public static boolean authAdmin(String admin_id,String admin_password)
	{
		// for checking admin credentials.
		
		try
		{
			Connection conn = ConnectionProvider.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = String.format("select * from admin_PE where admin_id = '%s' and password = '%s'", 
					admin_id,admin_password);
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return false;
	}

}
