package Sql;
import java.sql.*;
import java.util.Scanner;


public class weekendbank extends Weekend_bank_methods{

	public static void main(String[] args) throws SQLException {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fed","root","root");
		Statement s=c.createStatement();
		String sql1 = "insert into customer_details(cus_name,cus_age)" + " values (?, ?)";
		PreparedStatement ps=c.prepareStatement(sql1);
		
		
		weekendbank obj = new weekendbank();
		obj.create(c, s);
		
		char option='\0';
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Select an option");
		System.out.println("A.Insert to database");
		System.out.println("B.Show database contents");
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner1.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			switch(option) {
			case 'A':
				System.out.print("Enter your name: ");
				String cus_name = scanner.nextLine();
				
				System.out.print("Enter your age ");
				int cus_age = scanner.nextInt();
				
				obj.insert(c, ps,cus_name,cus_age);
				
	            break;
			case 'B':
				obj.display(c, s);
				break;
		}}
			while(option!='B');
			System.out.println("Thank you");
		}
		
		
		
		
		
		

		

	}


