package JDBCExercise2Program;

import java.util.List;
import java.util.Scanner;

import Model.Student;
import data_access.StudentDAO;

public class StudentSearchProgram {

	public static void main(String[] args) {

		System.out.println("=== Find student by id (DAO version) ===");
		System.out.print("Enter student id: ");
		Scanner input = new Scanner(System.in);
		int givenId = Integer.parseInt(input.nextLine());

		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.getStudentById(givenId); 

		if(student == null) {
			System.out.println("Unknown student id (" + givenId + ")");
		} else {
			System.out.println(student.getId() + ": " + student.getFirstName() + " " + student.getLastName() + ", "
					+ student.getStreetAddress() + ", " + student.getPostCode() + " " + student.getPostOffice());
		}

	}

}
