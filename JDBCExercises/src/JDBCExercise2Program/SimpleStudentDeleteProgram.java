package JDBCExercise2Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentDeleteProgram {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		System.out.println("=== Delete student ===");

		Scanner input = new Scanner(System.in);
		System.out.print("Enter student id: ");
		int id = Integer.parseInt(input.nextLine());

		try {
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);
			String sqlText = "DELETE FROM Student WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, id);

			int valueReturned = preparedStatement.executeUpdate();
			if (valueReturned == 0) {
				System.out.println("Nothing deleted. Unknown student id (" + id + ")");

			} else {
				System.out.println("Student deleted!");
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			// 8. The resources should be closed as soon as we don't need them anymore
			DbUtils.closeQuietly(preparedStatement, connection);
		}

	}

}
