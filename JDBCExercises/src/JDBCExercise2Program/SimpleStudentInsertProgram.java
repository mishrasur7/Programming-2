package JDBCExercise2Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentInsertProgram {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		System.out.println("=== Student === \n");
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

		try {
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) "
					+ "VALUES (?, ?, ?, ?, ?,?)";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setString(4, streetAddress);
			preparedStatement.setString(5, postCode);
			preparedStatement.setString(6, postOffice);

			preparedStatement.executeUpdate();

			System.out.println("Student data added!");

		} catch (SQLException sqle) {
			// First, check if the problem is primary key violation (the error code is
			// vendor-dependent)
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("\nCannot insert the student. The student id " + id + " is already in use.");
			} else {
				System.out.println("\nThe database is temporarily unavailable. Please try again later " + sqle.getMessage());
			}

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

	}

}
