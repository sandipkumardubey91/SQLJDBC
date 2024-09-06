package com.preparedstatements.query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.Util.JDBC.UTILJDBC;

public class InsertQuery {

	public static void insert() {
		Connection connection = null;
		PreparedStatement pstatement = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = UTILJDBC.getJBDCConnection();
			if(connection != null) {
				String insertquery = "insert into student(rollno,name,age) values(?,?,?)";
				
				pstatement =connection.prepareStatement(insertquery);
				
				System.out.print("\n Enter rollno: ");
				int rollno = sc.nextInt();
				System.out.print("\n Enter name: ");
				String name = sc.next();
				System.out.print("\n Enter age: ");
				int age= sc.nextInt();
				
				pstatement.setInt(1,rollno);
				pstatement.setString(2, name);
				pstatement.setInt(3, age);
				
				int roweffected = pstatement.executeUpdate();
				
				if(roweffected == 1)
					System.out.println("\n Row inserted;");
				else
					System.out.println("\n Row did not insert;");
			}
		}catch(Exception e) {
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
