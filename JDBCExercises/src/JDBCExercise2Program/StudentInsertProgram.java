package JDBCExercise2Program;

import java.util.Scanner;

import Model.Student;
import data_access.StudentDAO;

public class StudentInsertProgram {

	public static void main(String[] args) {
		System.out.println("=== Student using DAO=== \n");
		Scanner input = new Scanner(System.in);
		System.out.print("Id: ");
		int id = Integer.parseInt(input.nextLine());
		System.out.print("First name: ");
		String firstName = input.nextLine();
		System.out.print("Last name: ");
		String lastName = input.nextLine();
		System.out.print("Street: ");
		String streetAddress = input.nextLine();
		System.out.print("Postcode: ");
		String postCode = input.nextLine();
		System.out.print("Post office: ");
		String postOffice = input.nextLine();
		
		Student student = new Student(id, firstName, lastName, streetAddress, postCode, postOffice); 
		
		StudentDAO studentDAO = new StudentDAO(); 
		int errorCode = studentDAO.insertStudent(student); 
		
		if(errorCode == 0) {
			System.out.println("Student data added!");
		} else if (errorCode == 1){
			System.out.println("\nCannot insert the student. The student id " + id + " is already in use.");
		} else {
			System.out.println("\nThe database is temporarily unavailable. Please try again later ");
		}

	}

}
