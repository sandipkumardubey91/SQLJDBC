package com.preparedstatements.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.Util.JDBC.UTILJDBC;

public class UpdateQuery {

	public static void update() {
		Connection connection = null;
		PreparedStatement pstatement = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = UTILJDBC.getJBDCConnection();
			String updatequery = "update student set age=? where id=?";
			pstatement = connection.prepareStatement(updatequery);
			
			System.out.println("\nEnter id where updates will be done:");
			int id = sc.nextInt();
			System.out.println("\nEnter updated age:");
			int age = sc.nextInt();
			
			pstatement.setInt(1, age);
			pstatement.setInt(2, id);
			
			int roweffected = pstatement.executeUpdate();
			if(roweffected == 1)
				System.out.println("Updated Successfully");
		}catch(Exception e) 
		{
			e.printStackTrace();
		}finally {
			try {
				UTILJDBC.closeResource(connection, pstatement);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
