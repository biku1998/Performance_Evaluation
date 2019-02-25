package service;

import java.sql.Connection;

public class TestDebug {
	
	public static void main(String[] args) {
		
		
		Connection conn  = ConnectionProvider.getConnection();
		
		if(!(conn == null))
		{
			System.out.println("Connected...");
		}
		else {
			System.out.println("Connection failed...");
		}
		
	}

}
