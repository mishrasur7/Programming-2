package JDBCExercise2Program;

import data_access.StudentDAO;

public class StudentJSONProgram {

	public static void main(String[] args) {

		System.out.println("=== Print students using GSON (DAO version) ===");
		StudentDAO studentDAO = new StudentDAO();
		String jsonString = studentDAO.getAllStudentsJSON();

		if (jsonString == null) {
			System.out.println("The database is temporarily unavailable. Please try again later.");
		} else {
			System.out.println(jsonString);
		}

	}

}
