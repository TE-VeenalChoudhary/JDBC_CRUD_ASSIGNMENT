package com.te.jdbc.assignment2;

import java.util.Scanner;

public class StudentMain {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		char opt;
		do {
		System.out.println("------------------------------------------");
		System.out.println("        Welcome To Student Database");
		System.out.println("------------------------------------------");
		System.out.println();
		System.out.println("What do you want to perform ");
		System.out.println("1. CRUD Static");
		System.out.println("2. CRUD Dynamic");
		System.out.println("3. Exit");
		System.out.println();
		System.out.println("Enter your choice:");
		int ch = scanner.nextInt();
		
		switch (ch) {
		case 1:
			System.out.println("What do you want to perform ");
			System.out.println("1. Insert New Student Data");
			System.out.println("2. Update data of an existing student");
			System.out.println("3. Delete data of an existing student");
			System.out.println("4. View all the student's data present in the database");
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Insert.insertStatic();
				break;
			case 2:
				System.out.println("What do you want to update:");
				System.out.println("n:Name\ts:Standard\tm:Marks\td:Date of Birth");
				String option=scanner.next();
				Update.updateStatic(option);
				break;
			case 3:
				Delete.deleteStatic();
				break;
			case 4:
				Select.selectStatic();
				break;
			default: System.out.println("Invalid Choice ");
				break;
			}
			break;
		case 2:
			System.out.println("What do you want to perform ");
			System.out.println("1. Insert New Student Data");
			System.out.println("2. Update data of an existing student");
			System.out.println("3. Delete data of an existing student");
			System.out.println("4. View a student's data present in the database");
			System.out.println("Enter your choice:");
			int choice2 = scanner.nextInt();
			switch (choice2) {
			case 1:
				InsertDynamic.insertDynamicQuery();
				break;
			case 2:System.out.println("What do you want to update:\n");
				System.out.println("n:Name\ts:Standard\tm:Marks\td:Date of Birth");
				String option=scanner.next();
				UpdateDynamic.updateDyanmicQuery(option);
				break;
			case 3:
				DeleteDynamic.deleteDynamicQuery();
				break;
			case 4:
				SelectDynamic.selectDynamicQuery();
				break;
			default:System.out.println("Invalid Choice ");
				break;
			}
			break;
			
		case 3:System.out.println("\nThank You");
			System.exit(0);
			break;
		default:System.out.println("Invalid choice");
			break;
		}
		System.out.println();
		System.out.println("Do you want to continue?");
		System.out.println("Enter 'y' for yes or 'n' for no: ");
		opt = scanner.next().charAt(0);
	} while (opt != 'n');
	System.out.println("\nThank You");
	}

}
