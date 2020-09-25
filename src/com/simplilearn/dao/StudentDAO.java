package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.Student;

//import com.projectsample.model.User;

public class StudentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/project_simplilearn?useSSL=false";
	private String jdbcstudentname = "root";
	private String jdbcpassword = "tutorindia00";
	
	private static final String INSERT_STUDENTS_SQL = "INSERT INTO student_name"+" (FirstName, LastName, Cls_id) VALUES"+"(?, ?, ?);";
	
	
	private static final String SELECT_STUDENT_BY_ID = "select srno,FirstName,LastName,Cls_id from student_name where srno = ?";
	private static final String SELECT_ALL_STUDENTS = "select*from student_name";
	private static final String DELETE_STUDENTS_SQL= "delete from student_name where srno = ?;";
	private static final String UPDATE_STUDENTS_SQL = "update student_name set FirstName = ?, LastName = ?, Cls_id = ? where srno = ?;";
	
	
	public StudentDAO() {
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
	
	public void insertStudent(Student student) throws SQLException{
		System.out.println(INSERT_STUDENTS_SQL);
		try(Connection connection = getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_STUDENTS_SQL)){
			preparedstatement.setString(1, student.getFirstName());
			preparedstatement.setString(2, student.getLastName());
			preparedstatement.setInt(3, student.getClsId());
			System.out.println(preparedstatement);
			preparedstatement.executeUpdate();
		} catch(SQLException e) {
			printSQLException(e);
		}
	}
		
		public boolean updateStudent(Student student) throws SQLException{
			boolean rowUpdated;
			try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);){
				statement.setString(1, student.getFirstName());
				statement.setString(2, student.getLastName());
				statement.setInt(3, student.getClsId());
				statement.setInt(4, student.getSrno());
				
				rowUpdated = statement.executeUpdate() > 0;
			} 
			
			return rowUpdated;
	}
	
		public Student selectStudent(int srno) {
			Student student = null;
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
				preparedStatement.setInt(1, srno);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String FirstName = rs.getString("FirstName");
					String LastName = rs.getString("LastName");
					int Cls_id = rs.getInt("Cls_id");
					student = new Student(srno, FirstName, LastName, Cls_id);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return student;
		}
		
		public  List<Student> selectAllStudents() {
			List<Student> student_name = new ArrayList<>();
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
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
			
		public boolean deleteStudent(int srno) throws SQLException{
			boolean rowDeleted;
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
				
				statement.setInt(1, srno);
				rowDeleted = statement.executeUpdate() > 0;
				
			}
			return rowDeleted;
		}
		
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
