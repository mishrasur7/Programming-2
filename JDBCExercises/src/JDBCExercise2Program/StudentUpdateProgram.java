package JDBCExercise2Program;

import java.util.Scanner;

import Model.Student;
import data_access.StudentDAO;

public class StudentUpdateProgram {

	public static void main(String[] args) {
		System.out.println("=== Update student ===");
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
		int errorCode = studentDAO.updateStudent(student); 
		
		if(errorCode == 1) {
			System.out.println("Student data updated!");
		} else if (errorCode == 0) {
			System.out.println("Nothing updated. Unknown student id (" + id + ") !");
		} else {
			System.out.println("Database errow! Please try again later.");
		}
	}

}
