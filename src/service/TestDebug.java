package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Question;

public class TestDebug {
	
	public static void main(String[] args) {
		
		
		ArrayList<Question> q = ServiceProvider.getQuestions("Java");
		
		System.out.println(q);
		System.out.println(q.size());
		
		try
		{
			Connection conn  = ConnectionProvider.getConnection();
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from student");
			
			
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		
		
	}

}
