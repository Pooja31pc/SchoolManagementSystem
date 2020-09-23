package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.model.Grade;



public class GradeDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/project_simplilearn?useSSL=false";
	private String jdbcstudentname = "root";
	private String jdbcpassword = "tutorindia00";
	
	private static final String INSERT_GRADES_SQL = "INSERT INTO grade"+" (standard) VALUES"+"(?, ?, ?);";
	
	
	private static final String SELECT_GRADE_BY_ID = "select cid,standard from grade where cid = ?";
	private static final String SELECT_ALL_GRADES = "select*from grade";
	private static final String DELETE_GRADES_SQL= "delete from grade where cid = ?;";
	private static final String UPDATE_GRADES_SQL = "update grade set standard = ? where cid = ?;";
	
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
		
		public boolean updateGrade(Grade grade) throws SQLException{
			boolean rowUpdated;
			try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_GRADES_SQL);){
				statement.setString(1, grade.getStandard());
				statement.setInt(2, grade.getCid());
				
				rowUpdated = statement.executeUpdate() > 0;
			} 
			
			return rowUpdated;
	}
	
		public Grade selectGrade(int cid) {
			Grade grade = null;
			
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRADE_BY_ID);) {
				preparedStatement.setInt(1, cid);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					String Standard = rs.getString("Standard");
					grade = new Grade(cid, Standard);
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
					int cid = rs.getInt("cid");
					String Standard = rs.getString("Standard");
					grade.add(new Grade(cid, Standard));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return grade;
		}
			
		public boolean deleteGrade(int cid) throws SQLException{
			boolean rowDeleted;
			try(Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_GRADES_SQL);) {
				
				statement.setInt(1, cid);
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
