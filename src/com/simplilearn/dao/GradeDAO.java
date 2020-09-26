package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.Grade;
import com.simplilearn.model.Student;
import com.simplilearn.model.TeacherSubjectGrade;



public class GradeDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/project_simplilearn?useSSL=false";
	private String jdbcstudentname = "root";
	private String jdbcpassword = "tutorindia00";
	
	private static final String INSERT_GRADES_SQL = "INSERT INTO grade"+" (standard) VALUES"+"(?);";
	
	
	private static final String SELECT_GRADE_BY_ID = "select gid,standard from grade where gid = ?";
	private static final String SELECT_ALL_GRADES = "select*from grade";
	//private static final String DELETE_GRADES_SQL= "delete from grade where gid = ?;";
	private static final String UPDATE_GRADES_SQL = "update grade set standard = ? where gid = ?;";
	private static final String SELECT_GRADE_STUDENTS = "SELECT * FROM Student_Name INNER JOIN grade ON Student_Name.Cls_id = grade.gid WHERE gid = ?"; 
	private static final String SELECT_GRADE_STUDENTS_SUBJECTS = "SELECT subjectName, FirstName, LastName, standard FROM teachers t, Subjects s, Teachers_Subject t_s, grade g WHERE s.sid = t_s.subjectid AND t_s.teacherid = t.srno AND  t_s.classid = g.gid AND g.gid = ?";
	
	
	public GradeDAO() {
	}

	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcstudentname, jdbcpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	return connection;
	}
	
	public void insertGrade(Grade grade) throws SQLException{
		System.out.println(INSERT_GRADES_SQL);
		try(Connection connection = getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_GRADES_SQL)){
			preparedstatement.setString(1, grade.getStandard());
			System.out.println(preparedstatement);
			preparedstatement.executeUpdate();
		} catch(SQLException e) {
			printSQLException(e);
		}
	}
		
	//
	public  List<Student> selectGradeWiseStudents(int gid) {
		List<Student> student_name = new ArrayList<>();
		
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRADE_STUDENTS);) {
			
					preparedStatement.setInt(1, gid);
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs);
				int srno = rs.getInt("srno");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				int Cls_id = rs.getInt("Cls_id");
				student_name.add(new Student(srno, FirstName, LastName, Cls_id));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student_name;
	}
	//
	
	//
	public  List<TeacherSubjectGrade> selectTeacherSubjectGrade(int gid) {
		
		List<TeacherSubjectGrade> selectTeacherSubjectGrade = new ArrayList<>();
		
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRADE_STUDENTS_SUBJECTS);) {
			
					preparedStatement.setInt(1, gid);
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs);
				String SubjectName = rs.getString("SubjectName");
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String standard = rs.getString("standard");
				selectTeacherSubjectGrade.add(new TeacherSubjectGrade(SubjectName, FirstName, LastName, standard));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return selectTeacherSubjectGrade;
	}
	//
	
	
		public boolean updateGrade(Grade grade) throws SQLException{
			boolean rowUpdated;
			try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_GRADES_SQL);){
				statement.setString(1, grade.getStandard());
				statement.setInt(2, grade.getGid());
				
				rowUpdated = statement.executeUpdate() > 0;
			} 
			
			return rowUpdated;
	}
	
		public Grade selectGrade(int gid) {
			Grade grade = null;
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRADE_BY_ID);) {
				preparedStatement.setInt(1, gid);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String Standard = rs.getString("Standard");
					grade = new Grade(gid, Standard);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return grade;
		}
		
		public  List<Grade> selectAllGrades() {
			List<Grade> grade = new ArrayList<>();
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GRADES);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					int gid = rs.getInt("gid");
					String Standard = rs.getString("Standard");
					grade.add(new Grade(gid, Standard));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return grade;
		}
			
		/*public boolean deleteGrade(int gid) throws SQLException{
			boolean rowDeleted;
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_GRADES_SQL);) {
				
				statement.setInt(1, gid);
				rowDeleted = statement.executeUpdate() > 0;
				
			}
			return rowDeleted;
		}*/
		
		private void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		
		}

	
}
