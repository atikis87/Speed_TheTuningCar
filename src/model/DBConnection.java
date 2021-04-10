package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	//DATABASE CONNECTION URL
	private final String url = "jdbc:mysql://localhost:3306/tuningcarmanagement?useSSL=false";
	
	//USERNAME
	private final String user = "root"; // <== ADD YOUR USERNAME
	
	//PASSWORD
	private final String pass = "Ka5970"; // <== ADD YOUR PASSWORD. FOR ME IT'S EMPTY.
	
	//CONNECTION OBJECT
	private static Connection connection;

	//CONSTRUCTOR
	private DBConnection()
	{
		try
		{
			connection = DriverManager.getConnection(url, user, pass);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	// THIS METHOD RETURNS THE CONNECTION INSTANCE IF ALREADY CREATED OR CREATE AN INSTANCE
	public static Connection getInstance()
	{
		if(connection == null)
			new DBConnection();
		return connection;
	}

	public void finalize() throws Throwable
	{

	}

}