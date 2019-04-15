package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Question;

public class Utility_class {
	
	public static void main(String[] args) {
		

		try
		{
			
			Connection conn  = ConnectionProvider.getConnection();
			
			Statement st  = conn.createStatement();
			
			ArrayList<Question> q =  new ArrayList<>();
			
			String sql = "select * from question";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
