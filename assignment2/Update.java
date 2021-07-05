package com.te.jdbc.assignment2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Update {
	
	public static void updateStatic() {
		Connection connection=null;
		Statement statement=null;
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
			
			statement=connection.createStatement();
			System.out.println("What do you want to update:");
			System.out.println("n:Name\ts:Standard\tm:Marks\td:Date of Birth");
			String choice=sc.next();
			if (choice.charAt(0)=='n') {
				String query=properties.getProperty("queryUpdateName");
				statement=connection.prepareStatement(query);
				int result=statement.executeUpdate(query);
				
				if (result!=0) {
					System.out.println("Data Updated successfully");
				}
			}else if(choice.charAt(0)=='s') {
				String query=properties.getProperty("queryUpdateStd");
				statement=connection.prepareStatement(query);
				int result=statement.executeUpdate(query);
				
				if (result!=0) {
					System.out.println("Data Updated successfully");
				}
			}else if(choice.charAt(0)=='m') {
				String query=properties.getProperty("queryUpdateMarks");
				statement=connection.prepareStatement(query);
				int result=statement.executeUpdate(query);
				
				if (result!=0) {
					System.out.println("Data Updated successfully");
				}
			}else if(choice.charAt(0)=='d') {
				String query=properties.getProperty("queryUpdateDate");
				statement=connection.prepareStatement(query);
				int result=statement.executeUpdate(query);
				
				if (result!=0) {
					System.out.println("Data Updated successfully");
				}
			}else {
				System.out.println("Invalid Choice.... Nothing is updated");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				
				if (statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
