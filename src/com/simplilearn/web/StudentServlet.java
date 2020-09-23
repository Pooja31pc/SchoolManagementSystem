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

import com.simplilearn.dao.GradeDAO;
import com.simplilearn.dao.StudentDAO;
import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.dao.TeacherDAO;
import com.simplilearn.model.Grade;
import com.simplilearn.model.Student;
import com.simplilearn.model.Subject;
import com.simplilearn.model.Teacher;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
	private TeacherDAO teacherDAO;
	private SubjectDAO subjectDAO;
	private GradeDAO gradeDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	public void init() {
		studentDAO = new StudentDAO();
		teacherDAO = new TeacherDAO();
		subjectDAO = new SubjectDAO();
		gradeDAO = new GradeDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String action = request.getServletPath();
		
		try {
		
		switch (action) {
		case "/newTeacherForm":
			showNewTeacherForm(request, response);
			break;
		case "/listTeacher":
			showTeacherList(request, response);
			break;
		case "/teacher":
			showTeacherPage(request, response);
			break;
		case "/insertTeacher":
				insertTeacher(request, response);
			break;
		case "/deleteTeacher":
				deleteTeacher(request, response);
			break;
		case "/editTeacher":
			showEditTeacherForm(request, response);
			break;
		case "/updateTeacher":
				updateTeacher(request, response);
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
		case "/deleteStudent":
				deleteStudent(request, response);
			break;
		case "/editStudent":
			showEditStudentForm(request, response);
			break;
		case "/updateStudent":
				updateStudent(request, response);
			break;
		case "/newSubjectForm":
			showNewSubjectForm(request, response);
			break;
		case "/listSubject":
			showSubjectList(request, response);
			break;
		case "/subject":
			showSubjectPage(request, response);
			break;
		case "/insertSubject":
				insertSubject(request, response);
			break;
		case "/deleteSubject":
				deleteSubject(request, response);
			break;
		case "/editSubject":
			showEditSubjectForm(request, response);
			break;
		case "/updateSubject":
				updateSubject(request, response);
		case "/newGradeForm":
			showNewGradeForm(request, response);
			break;
		case "/listGrade":
			showGradeList(request, response);
			break;
		case "/grade":
			showGradePage(request, response);
			break;
		case "/insertGrade":
				insertGrade(request, response);
			break;
		case "/deleteGrade":
				deleteGrade(request, response);
			break;
		case "/editGrade":
			showEditGradeForm(request, response);
			break;
		case "/updateGrade":
				updateGrade(request, response);
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
		response.sendRedirect("student");
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
	
	private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		Student existingStudent = studentDAO.selectStudent(srno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);
		
	}
	
	private void showTeacherPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showTeacherList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Teacher> listTeacher = teacherDAO.selectAllTeachers();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherlist.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String subject = request.getParameter("subject");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Teacher book = new Teacher(srno, FirstName, LastName, subject, gender, age);
		teacherDAO.updateTeacher(book);
		response.sendRedirect("list");
	}
	
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		teacherDAO.deleteTeacher(srno);
		response.sendRedirect("list");
	}
	
	private void showNewTeacherForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherform.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String subject = request.getParameter("subject");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		Teacher newTeacher = new Teacher(FirstName, LastName, subject, gender, age);
		teacherDAO.insertTeacher(newTeacher);
		response.sendRedirect("teacher");
		
	}
	
	private void showEditTeacherForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		Teacher existingTeacher = teacherDAO.selectTeacher(srno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		request.setAttribute("teacher", existingTeacher);
		dispatcher.forward(request, response);
	}
	//
	private void showSubjectPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showSubjectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Subject> listSubject = subjectDAO.selectAllSubjects();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectlist.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		String SubjectName = request.getParameter("SubjectName");
		
		Subject book = new Subject(sid, SubjectName);
		subjectDAO.updateSubject(book);
		response.sendRedirect("list");
	}
	
	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		subjectDAO.deleteSubject(sid);
		response.sendRedirect("list");
	}
	
	private void showNewSubjectForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectform.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String SubjectName = request.getParameter("SubjectName");
		Subject newSubject = new Subject(SubjectName);
		subjectDAO.insertSubject(newSubject);
		response.sendRedirect("subject");
		
	}
	
	private void showEditSubjectForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		Subject existingSubject = subjectDAO.selectSubject(sid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-form.jsp");
		request.setAttribute("subject", existingSubject);
		dispatcher.forward(request, response);
		
	}
	//
	private void showGradePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("grade.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void showGradeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Grade> listGrade = gradeDAO.selectAllGrades();
		request.setAttribute("listGrade", listGrade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("gradelist.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void updateGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String Standard = request.getParameter("Standard");
		
		Grade book = new Grade(cid, Standard);
		gradeDAO.updateGrade(book);
		response.sendRedirect("list");
	}
	
	private void deleteGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		gradeDAO.deleteGrade(cid);
		response.sendRedirect("list");
	}
	
	private void showNewGradeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("gradeform.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String Standard = request.getParameter("Standard");
		Grade newGrade = new Grade(Standard);
		gradeDAO.insertGrade(newGrade);
		response.sendRedirect("grade");
		
	}
	
	private void showEditGradeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Grade existingGrade = gradeDAO.selectGrade(cid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("grade-form.jsp");
		request.setAttribute("grade", existingGrade);
		dispatcher.forward(request, response);
		
	}
//
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
