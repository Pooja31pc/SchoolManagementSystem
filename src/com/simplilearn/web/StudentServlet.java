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
import javax.servlet.http.HttpSession;

import com.simplilearn.dao.GradeDAO;
//import com.simplilearn.dao.LoginDAO;
import com.simplilearn.dao.StudentDAO;
import com.simplilearn.dao.SubjectDAO;
import com.simplilearn.dao.TeacherDAO;
import com.simplilearn.model.Grade;
import com.simplilearn.model.Student;
import com.simplilearn.model.Subject;
import com.simplilearn.model.Teacher;
import com.simplilearn.model.TeacherSubjectGrade;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			case "/updateGrade":
				updateGrade(request, response);
			case "/choosegrade":
				showParticularGradeDetails(request, response);
				break;
			//
			case "/insertteachersubject":
				insertTeacherSubject(request, response);
				break;
			case "/gradewisedetails":
				gradeWiseDetails(request, response);
				break;
			case "/teacherSubjectForm":
				assignTeacherSubjectForm(request, response);
				break;
			case "/home":
				home(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/login":
				login(request, response);
				break;
			default:
				welcomepage(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		if (uname != null && pass != null && uname.equals("simplilearn") && pass.equals("simplilearn")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("HOME.jsp");
		}

		else {
			response.sendRedirect("login.jsp");
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();

		response.sendRedirect("welcomepage.jsp");
	}

	//

	private void welcomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcomepage.jsp");
		dispatcher.forward(request, response);
	}

	private void home(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("HOME.jsp");
		dispatcher.forward(request, response);
	}

	private void showStudentPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
		dispatcher.forward(request, response);
	}

	private void showStudentList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Student> listStudent = studentDAO.selectAllStudents();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentlist.jsp");
		dispatcher.forward(request, response);
	}

	//
	private void gradeWiseDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int gid = Integer.parseInt(request.getParameter("gid"));

		List<Student> listGradeWiseStudent = gradeDAO.selectGradeWiseStudents(gid);
		request.setAttribute("listGradeWiseStudent", listGradeWiseStudent);

		List<TeacherSubjectGrade> listSubjectTeacherGrade = gradeDAO.selectTeacherSubjectGrade(gid);
		request.setAttribute("listSubjectTeacherGrade", listSubjectTeacherGrade);

		RequestDispatcher dispatcher = request.getRequestDispatcher("gradewisedetails.jsp");// make a jsp file for this
		dispatcher.forward(request, response);
	}
	//

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		int Cls_id = Integer.parseInt(request.getParameter("Cls_id"));

		Student book = new Student(srno, FirstName, LastName, Cls_id);
		studentDAO.updateStudent(book);
		response.sendRedirect("list");
	}

	private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentform.jsp");
		dispatcher.forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		int Cls_id = Integer.parseInt(request.getParameter("Cls_id"));
		Student newStudent = new Student(FirstName, LastName, Cls_id);
		studentDAO.insertStudent(newStudent);
		response.sendRedirect("student");

	}

	private void showTeacherPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher.jsp");
		dispatcher.forward(request, response);
	}

	private void showTeacherList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Teacher> listTeacher = teacherDAO.selectAllTeachers();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherlist.jsp");
		dispatcher.forward(request, response);
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int srno = Integer.parseInt(request.getParameter("srno"));
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));

		Teacher book = new Teacher(srno, FirstName, LastName, gender, age);
		teacherDAO.updateTeacher(book);
		response.sendRedirect("list");
	}

	private void showNewTeacherForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherform.jsp");
		dispatcher.forward(request, response);
	}

	private void assignTeacherSubjectForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("assignteachersubject.jsp");
		dispatcher.forward(request, response);
	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		Teacher newTeacher = new Teacher(FirstName, LastName, gender, age);
		teacherDAO.insertTeacher(newTeacher);
		response.sendRedirect("teacher");

	}

	//
	private void insertTeacherSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int classid = Integer.parseInt(request.getParameter("classid"));
		int subjectid = Integer.parseInt(request.getParameter("subjectid"));
		int teacherid = Integer.parseInt(request.getParameter("teacherid"));
		// Teacher newTeacher = new Teacher(Classid, Subjectid, Teacherid);
		teacherDAO.insertTeacherSubject(classid, subjectid, teacherid);
		response.sendRedirect("teacher");

	}

	private void showSubjectPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject.jsp");
		dispatcher.forward(request, response);
	}

	private void showSubjectList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Subject> listSubject = subjectDAO.selectAllSubjects();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectlist.jsp");
		dispatcher.forward(request, response);
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		String SubjectName = request.getParameter("SubjectName");

		Subject book = new Subject(sid, SubjectName);
		subjectDAO.updateSubject(book);
		response.sendRedirect("list");
	}

	private void showNewSubjectForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectform.jsp");
		dispatcher.forward(request, response);
	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String SubjectName = request.getParameter("SubjectName");
		Subject newSubject = new Subject(SubjectName);
		subjectDAO.insertSubject(newSubject);
		response.sendRedirect("subject");

	}

	private void showGradePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("grade.jsp");
		dispatcher.forward(request, response);
	}

	private void showGradeList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Grade> listGrade = gradeDAO.selectAllGrades();
		request.setAttribute("listGrade", listGrade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("gradelist.jsp");
		dispatcher.forward(request, response);
	}

	private void updateGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		String Standard = request.getParameter("Standard");

		Grade book = new Grade(gid, Standard);
		gradeDAO.updateGrade(book);
		response.sendRedirect("list");
	}

	private void showNewGradeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("gradeform.jsp");
		dispatcher.forward(request, response);
	}

	private void insertGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String Standard = request.getParameter("Standard");
		Grade newGrade = new Grade(Standard);
		gradeDAO.insertGrade(newGrade);
		response.sendRedirect("grade");

	}

	private void showParticularGradeDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Grade> listGrade = gradeDAO.selectAllGrades();
		request.setAttribute("listGrade", listGrade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("grade_options.jsp");
		dispatcher.forward(request, response);
	}

//
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
