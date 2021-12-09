package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data_access.StudentDAO;
import student_example_model.Student;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/addStudent")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentId = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String streetAddress = request.getParameter("streetAddress");
		String postCode = request.getParameter("postCode");
		String postOffice = request.getParameter("postOffice");

		StudentDAO studentDAO = new StudentDAO();
		Student student = new Student(studentId, firstName, lastName, streetAddress, postCode, postOffice);
		int errorCode = studentDAO.insertStudent(student);

		Gson gson = new Gson();
		String json = gson.toJson(new Status(errorCode));
		PrintWriter out = response.getWriter();
		out.print(json);

	}

}
