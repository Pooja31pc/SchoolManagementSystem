package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.Teacher;



public class TeacherDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/project_simplilearn?useSSL=false";
	private String jdbcstudentname = "root";
	private String jdbcpassword = "tutorindia00";
	
	private static final String INSERT_TEACHERS_SQL = "INSERT INTO teachers"+" (FirstName, LastName, subject, gender, age) VALUES"+"(?, ?, ?, ?, ?);";
	
	
	private static final String SELECT_TEACHER_BY_ID = "select srno,FirstName,LastName,subject,gender,age from teachers where srno = ?";
	private static final String SELECT_ALL_TEACHERS = "select*from teachers";
	private static final String DELETE_TEACHERS_SQL= "delete from teachers where srno = ?;";
	private static final String UPDATE_TEACHERS_SQL = "update teachers set FirstName = ?, LastName = ?, subject = ?, gender = ?, age = ? where srno = ?;";
	
	public TeacherDAO() {
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
	
	public void insertTeacher(Teacher teacher) throws SQLException{
		System.out.println(INSERT_TEACHERS_SQL);
		try(Connection connection = getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_TEACHERS_SQL)){
			preparedstatement.setString(1, teacher.getFirstName());
			preparedstatement.setString(2, teacher.getLastName());
			preparedstatement.setString(3, teacher.getSubject());
			preparedstatement.setString(4, teacher.getGender());
			preparedstatement.setInt(5, teacher.getAge());
			System.out.println(preparedstatement);
			preparedstatement.executeUpdate();
		} catch(SQLException e) {
			printSQLException(e);
		}
	}
		
		public boolean updateTeacher(Teacher teacher) throws SQLException{
			boolean rowUpdated;
			try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHERS_SQL);){
				statement.setString(1, teacher.getFirstName());
				statement.setString(2, teacher.getLastName());
				statement.setString(3, teacher.getSubject());
				statement.setString(4, teacher.getGender());
				statement.setInt(5, teacher.getAge());
				statement.setInt(6, teacher.getSrno());
				
				rowUpdated = statement.executeUpdate() > 0;
			} 
			
			return rowUpdated;
	}
	
		public Teacher selectTeacher(int srno) {
			Teacher teacher = null;
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_BY_ID);) {
				preparedStatement.setInt(1, srno);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String FirstName = rs.getString("FirstName");
					String LastName = rs.getString("LastName");
					String subject = rs.getString("subject");
					String gender = rs.getString("gender");
					int age = rs.getInt("age");
					teacher = new Teacher(srno, FirstName, LastName, subject, gender, age);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return teacher;
		}
		
		public  List<Teacher> selectAllTeachers() {
			List<Teacher> teachers = new ArrayList<>();
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					int srno = rs.getInt("srno");
					String FirstName = rs.getString("FirstName");
					String LastName = rs.getString("LastName");
					String subject = rs.getString("subject");
					String gender = rs.getString("gender");
					int age = rs.getInt("age");
					teachers.add(new Teacher(srno, FirstName, LastName, subject, gender, age));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return teachers;
		}
			
		public boolean deleteTeacher(int srno) throws SQLException{
			boolean rowDeleted;
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_TEACHERS_SQL);) {
				
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
