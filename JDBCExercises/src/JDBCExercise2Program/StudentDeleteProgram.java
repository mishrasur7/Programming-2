package JDBCExercise2Program;

import java.util.Scanner;

import data_access.StudentDAO;

public class StudentDeleteProgram {

	public static void main(String[] args) {
		System.out.println("=== Delete student (DAO version)===");

		Scanner input = new Scanner(System.in);
		System.out.print("Enter student id: ");
		int id = Integer.parseInt(input.nextLine());

		StudentDAO studentDAO = new StudentDAO();
		int errorCode = studentDAO.deleteStudent(id);

		if (errorCode == 1) {
			System.out.println("Student deleted!");
		} else if (errorCode == 0) {
			System.out.println("Nothing deleted. Unknown student id (" + id + ")");
		} else {
			System.out.println("Database error! Please try agian later.");
		}

	}

}
