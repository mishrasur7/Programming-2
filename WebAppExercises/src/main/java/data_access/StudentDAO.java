package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import student_example_model.Student;

public class StudentDAO {

	public StudentDAO() {
		// In Tomcat 8 environment, the JDBC driver must be explicitly loaded as below
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	public List<Student> getAllStudents() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> studentList = new ArrayList<Student>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstName, lastName, streetAddress, postCode, postOffice FROM Student ORDER BY lastName";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String streetAddress = resultSet.getString("streetaddress");
				String postCode = resultSet.getString("postcode");
				String postOffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstName, lastName, streetAddress, postCode, postOffice));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudents() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		}

		return studentList;
	}

	public Student getStudentById(int givenId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = new Student();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, givenId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String streetAddress = resultSet.getString("streetaddress");
				String postCode = resultSet.getString("postcode");
				String postOffice = resultSet.getString("postoffice");

				student.setId(id);
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setStreetAddress(streetAddress);
				student.setPostCode(postCode);
				student.setPostOffice(postOffice);
				return student;

			}

		} catch (SQLException sqle) {
			System.out.println("[ERROR] StudentDAO: getStudentBYId() failed. " + sqle.getMessage() + "\n");

		}

		return null;
	}

	public String getAllStudentsJSON() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> studentList = new ArrayList<Student>();
		Gson gson = new Gson();
		String jsonString = "";

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstName, lastName, streetAddress, postCode, postOffice FROM Student ORDER BY lastName";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String streetAddress = resultSet.getString("streetaddress");
				String postCode = resultSet.getString("postcode");
				String postOffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstName, lastName, streetAddress, postCode, postOffice));
				jsonString = gson.toJson(studentList);
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudents() failed. " + sqle.getMessage() + "\n");
			jsonString = null;

		}

		return jsonString;
	}

	public int insertStudent(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int errorCode = -1;

		try {
			connection = openConnection();
			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) "
					+ "VALUES (?, ?, ?, ?, ?,?)";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setString(4, student.getStreetAddress());
			preparedStatement.setString(5, student.getPostCode());
			preparedStatement.setString(6, student.getPostOffice());

			preparedStatement.executeUpdate();
			errorCode = 0;
		} catch (SQLException sqle) {
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				errorCode = 1;
			} else {
				System.out.println("\n[ERROR] StudentDAO: insertStudent() failed. " + sqle.getMessage() + "\n");
				errorCode = -1;
			}
		}
		return errorCode;
	}

	public int deleteStudent(int studentId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int errorCode = -1;

		try {
			connection = openConnection();
			String sqlText = "DELETE FROM Student WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentId);
			errorCode = preparedStatement.executeUpdate();
		} catch (SQLException sqle) {

			System.out.println("\n[ERROR] StudentDAO: deleteStudent() failed. " + sqle.getMessage() + "\n");
			errorCode = -1;
		}

		return errorCode;
	}

	public int updateStudent(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int errorCode = -1;

		try {
			connection = openConnection();
			String sqlText = "UPDATE Student set firstname = ?, lastname = ?, streetaddress = ?, postcode = ?, postoffice = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getStreetAddress());
			preparedStatement.setString(4, student.getPostCode());
			preparedStatement.setString(5, student.getPostOffice());
			preparedStatement.setInt(6, student.getId());

			errorCode = preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			if (sqle.getErrorCode() != ConnectionParameters.PK_VIOLATION_ERROR) {
				errorCode = 1;
			} else {
				errorCode = -1;
			}
		}
		return errorCode;
	}

}
