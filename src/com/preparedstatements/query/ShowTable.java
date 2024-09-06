package com.preparedstatements.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Util.JDBC.UTILJDBC;

public class ShowTable {

	public static void showTable(){
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet result = null;
		
		try {
			connection = UTILJDBC.getJBDCConnection();
			
			String selectquery = "select * from student";
			pstatement = connection.prepareStatement(selectquery);

			result = pstatement.executeQuery();
			
			if(result != null) {
				
				while(result.next()) {
					System.out.println("ID \t ROLLNUM \t NAME \t\t AGE");
					System.out.println(result.getInt(1) + " \t " + result.getInt(2) + " \t\t " + result.getString(3) + " \t " + result.getInt(4));
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
