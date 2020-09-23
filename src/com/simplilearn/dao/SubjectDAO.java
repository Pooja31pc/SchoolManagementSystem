package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.Subject;

public class SubjectDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/project_simplilearn?useSSL=false";
	private String jdbcstudentname = "root";
	private String jdbcpassword = "tutorindia00";
	
	private static final String INSERT_SUBJECTS_SQL = "INSERT INTO Subjects"+" (subjectName) VALUES"+"(?);";
	
	
	private static final String SELECT_SUBJECT_BY_ID = "select sid,subjectName from Subjects where srno = ?";
	private static final String SELECT_ALL_SUBJECTS = "select*from Subjects";
	private static final String DELETE_SUBJECTS_SQL= "delete from Subjects where sid = ?;";
	private static final String UPDATE_SUBJECTS_SQL = "update Subjects set subjectName = ?;";
	
	public SubjectDAO() {
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
	
	public void insertSubject(Subject subject) throws SQLException{
		System.out.println(INSERT_SUBJECTS_SQL);
		try(Connection connection = getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_SUBJECTS_SQL)){
			preparedstatement.setString(1, subject.getSubjectName());
			System.out.println(preparedstatement);
			preparedstatement.executeUpdate();
		} catch(SQLException e) {
			printSQLException(e);
		}
	}
		
		public boolean updateSubject(Subject subject) throws SQLException{
			boolean rowUpdated;
			try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_SUBJECTS_SQL);){
				statement.setString(1, subject.getSubjectName());
				statement.setInt(2, subject.getSid());
				
				rowUpdated = statement.executeUpdate() > 0;
			} 
			
			return rowUpdated;
	}
	
		public Subject selectSubject(int sid) {
			Subject subject = null;
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUBJECT_BY_ID);) {
				preparedStatement.setInt(1, sid);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String SubjectName = rs.getString("SubjectName");
					subject = new Subject(sid, SubjectName);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return subject;
		}
		
		public  List<Subject> selectAllSubjects() {
			List<Subject> Subjects = new ArrayList<>();
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUBJECTS);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					int sid = rs.getInt("sid");
					String SubjectName = rs.getString("SubjectName");
					Subjects.add(new Subject(sid, SubjectName));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return Subjects;
		}
			
		public boolean deleteSubject(int sid) throws SQLException{
			boolean rowDeleted;
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_SUBJECTS_SQL);) {
				
				statement.setInt(1, sid);
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
