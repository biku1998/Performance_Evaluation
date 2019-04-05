package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import model.Question;

public class TestDebug {
	
	public static void main(String[] args) {
		
		
		
		try
		{
			Connection conn  = ConnectionProvider.getConnection();
			
			Statement st = conn.createStatement();
			
			System.out.println("Connected...");
			
			
//			String [] ar = {"abc","def"};
//			
//			boolean test = Arrays.asList(ar).contains("asbc");
//			
//			System.out.println(test);
//			
			
			
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		
		
	}

}
