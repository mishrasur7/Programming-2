package servlet_exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import student_example_model.Student;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsontest")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student1 = new Student(12, "Suraj", "Mishra", "Pakilantie", "00560", "helsinki");
		Student student2 = new Student(13, "Alpo", "Remes", "Pakilanto", "00570", "Espoo");

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);

		Gson gson = new Gson();
		String jsonString = gson.toJson(studentList);
		response.getWriter().append(jsonString);
	}

}
