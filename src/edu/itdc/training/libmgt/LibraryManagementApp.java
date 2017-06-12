package edu.itdc.training.libmgt;

import java.util.Scanner;

public class LibraryManagementApp {
	private static Scanner input;
	
	public static void main(String[] args) {
		
		input = new Scanner (System.in);
		boolean mainMenu = true;
		while (mainMenu) {
			switch (mainOptions()) {
			//case "1":	addNewBooks();	break;
			case "2":	
			
			}
		}
		
		
	}
	
	public static String mainOptions () {
		String choice = input.nextLine();
		return choice;
	}

}
