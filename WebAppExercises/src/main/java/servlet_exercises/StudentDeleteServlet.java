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

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/deleteStudent")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id")); 
		
		StudentDAO studentDAO = new StudentDAO(); 
		int errorCode = studentDAO.deleteStudent(studentId); 
		
		//creating Gson object
		Gson gson = new Gson(); 
		
		//creating json string to pass to response body
		String json = gson.toJson(new Status(errorCode)); 
		
		//creating PrintWriter object 
		PrintWriter writer = response.getWriter(); 
		
		//finally printing to browser
		writer.print(json); 
		
	}

}
