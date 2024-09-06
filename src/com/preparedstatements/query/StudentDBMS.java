package com.preparedstatements.query;

import java.util.Scanner;

public class StudentDBMS {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char ch;
		while(true)
		{
			System.out.print("\n\t SELECT AN OPTION");
			System.out.print("\n\t 1.INSERT A NEW STUDENT DATA");
			System.out.print("\n\t 2.VIEW THE SELECTED STUDENT");
			System.out.print("\n\t 3.UPDATE THE EXISTING STUDENT AGE");
			System.out.print("\n\t 4.DELETE A STUDENT DATA COMPLETELY");
			System.out.print("\n\t 5.SHOW WHOLE DATABASE");
			System.out.print("\n\t 9.EXIT THE OPTIONS");
			System.out.print("\n\t ENTER THE ACTION: ");
			
			ch = sc.next().charAt(0);
			switch(ch) {
				case '1':
					InsertQuery.insert();
					break;
				case '2':
					SelectQuery.select();
					break;
				case '3':
					UpdateQuery.update();
					break;
				case '4':
					DeleteQuery.delete();
					break;
				case '5':
					ShowTable.showTable();
					break;
				case '9':
					System.exit(0);
				default :
					System.out.println("\n Chhose a valid option");
					break;
			}
		}
	}

}
