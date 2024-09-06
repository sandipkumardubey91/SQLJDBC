package com.preparedstatements.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Util.JDBC.UTILJDBC;

public class SelectQuery {

	public static void select() {
		Scanner sc = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet result = null;
		
		try {
			connection = UTILJDBC.getJBDCConnection();
			
			String selectquery = "select * from student where id=?";
			pstatement = connection.prepareStatement(selectquery);
			System.out.println("\n Enter the id which you want to show from database: ");
			int id = sc.nextInt();
			
			pstatement.setInt(1,id);
			
			result = pstatement.executeQuery();
			
			if(result != null) {
				if(result.next()) {
					System.out.println("ID \t ROLLNUM \t NAME \t AGE");
					System.out.println(result.getInt(1) + " \t " + result.getInt(2) + " \t\t " + result.getString(3) + "  " + result.getInt(4));
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				UTILJDBC.closeResource(connection, pstatement, result);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
