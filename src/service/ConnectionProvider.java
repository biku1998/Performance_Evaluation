package service;

import java.sql.*;

public class ConnectionProvider {
	
	static Connection conn;

    public static Connection getConnection()
    {
    	String url = "jdbc:mysql://localhost:3306/Perf_Eval?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "rootuser";	
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            return conn;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       return null;
    }
	}
	
