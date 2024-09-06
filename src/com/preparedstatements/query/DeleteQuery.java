package com.preparedstatements.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.Util.JDBC.UTILJDBC;

public class DeleteQuery {

	public static void delete() {
		Connection connection = null;
		PreparedStatement pstatement = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = UTILJDBC.getJBDCConnection();
			String deletequery = "delete from student where id=?";
			pstatement = connection.prepareStatement(deletequery);
			
			System.out.println("\n Enter row id which you want to delete: ");
			int id = sc.nextInt();
			
			pstatement.setInt(1, id);
			
			int roweffected = pstatement.executeUpdate();
			
			if(roweffected == 1)
				System.out.println("\n Row deleted Successfully.");
		}catch(Exception e)
		{e.printStackTrace();
		}finally {
			
			try {
				UTILJDBC.closeResource(connection, pstatement);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
