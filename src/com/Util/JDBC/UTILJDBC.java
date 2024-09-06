package com.Util.JDBC;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class UTILJDBC {

	public static Connection getJBDCConnection() {
		FileInputStream fis = null;
		Connection connection = null;
		try {
			 fis = new FileInputStream("Application.properties");
		} catch(Exception e) {}
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch(Exception e) {}
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		System.out.println(user);
		try {
		 connection = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeResource(Connection connection, Statement statement) throws SQLException {
		if(connection != null)
			connection.close();
		if(statement != null)
			statement.close();
	}
	
	public static void closeResource(Connection connection, PreparedStatement preaparedstatement) throws SQLException {
		if(connection != null)
			connection.close();
		if(preaparedstatement != null)
			preaparedstatement.close();
	}
	
	public static void closeResource(Connection connection, PreparedStatement preaparedstatement, ResultSet resultset) throws SQLException {
		if(connection != null)
			connection.close();
		if(preaparedstatement != null)
			preaparedstatement.close();
		if(resultset != null)
			resultset.close();		
		
	}
}
