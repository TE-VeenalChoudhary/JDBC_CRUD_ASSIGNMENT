package com.te.jdbc.assignment2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class UpdateDynamic {

	public static void updateDyanmicQuery() {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the ID you want to update: ");
		int id=sc.nextInt();
		
		Connection connection=null;
		PreparedStatement prepare=null;
		
		try {
			FileInputStream file= new FileInputStream("directory.properties");
			Properties properties= new Properties();
			properties.load(file);
			String driver=properties.getProperty("driver");
			String dburl=properties.getProperty("dburl");
			String user=properties.getProperty("user");
			String password=properties.getProperty("password");
			
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			System.out.println("What do you want to update:");
			System.out.println("n:Name\ts:Standard\tm:Marks\td:Date of Birth");
			String choice=sc.next();
			if (choice.charAt(0)=='n') {
				System.out.println("Enter the updated name: ");
				String name=sc.next();
				String query=properties.getProperty("queryUpdateDynamicName");
				prepare=connection.prepareStatement(query);
				prepare.setInt(2, id);
				prepare.setString(1, name);
			}else if(choice.charAt(0)=='s') {
				System.out.println("Enter the updated standard: ");
				int std=sc.nextInt();
				String query=properties.getProperty("queryUpdateDynamicStd");
				prepare=connection.prepareStatement(query);
				prepare.setInt(2, id);
				prepare.setInt(1, std);
			}else if(choice.charAt(0)=='m') {
				System.out.println("Enter the updated marks: ");
				double marks=sc.nextDouble();
				String query=properties.getProperty("queryUpdateDynamicMk");
				prepare=connection.prepareStatement(query);
				prepare.setInt(2, id);
				prepare.setDouble(1, marks);
			}else if(choice.charAt(0)=='d') {
				System.out.println("Enter the updated Date of birth: (YYYY-MM-DD) ");
				String date=sc.next();
				String query=properties.getProperty("queryUpdateDynamicDate");
				prepare=connection.prepareStatement(query);
				prepare.setInt(2, id);
				prepare.setString(1, date);
			}else {
				System.out.println("Invalid Choice.... Nothing is updated");
			}

			
			
			int result=prepare.executeUpdate();
			
			if (result!=0) {
				System.out.println("Data Updated successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				
				if (prepare!=null)
					prepare.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
