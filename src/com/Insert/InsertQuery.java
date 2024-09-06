package com.Insert;

import java.sql.*;

import com.Util.JDBC.UTILJDBC;

public class InsertQuery {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = UTILJDBC.getJBDCConnection();
			if(connection != null) {
				try {
					statement = connection.createStatement();
					String myinsertquery = "insert into student(rollno,name,age) values"
							+ "(91,'Sandip',20)";
					int roweffected = statement.executeUpdate(myinsertquery);
					
					if(roweffected == 1)
						System.out.println("Row inserted");
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				UTILJDBC.closeResource(connection, statement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
