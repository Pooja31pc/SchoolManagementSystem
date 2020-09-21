package com.simplilearn.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.StudentDAO;
import com.simplilearn.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	public void init() {
		studentDAO = new StudentDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String action = request.getServletPath();
		
		try {
		
		switch (action) {
		case "/newStudentForm":
			showNewStudentForm(request, response);
			break;
		case "/listStudent":
			showStudentList(request, response);
			break;
		case "/student":
			showStudentPage(request, response);
			break;
		case "/insertStudent":
				insertStudent(request, response);
			break;
		case "/delete":
				deleteStudent(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
				updateStudent(request, response);
			break;
			default:
				//handle list
				home(request, response);
				break;
		}
		
	} catch (SQLException ex) {
		throw new ServletException(ex);
	}
	}
	
	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("HOME.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showStudentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Student> listStudent = studentDAO.selectAllStudents();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentlist.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		int Cls_id = Integer.parseInt(request.getParameter("Cls_id"));
		
		Student book = new Student(srno, FirstName, LastName, Cls_id);
		studentDAO.updateStudent(book);
		response.sendRedirect("list");
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		studentDAO.deleteStudent(srno);
		response.sendRedirect("list");
	}
	
	private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentform.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		int Cls_id = Integer.parseInt(request.getParameter("Cls_id"));
		Student newStudent = new Student(FirstName, LastName, Cls_id);
		studentDAO.insertStudent(newStudent);
		response.sendRedirect("student");
		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		Student existingStudent = studentDAO.selectStudent(srno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
