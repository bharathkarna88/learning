package com.curd.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curd.model.Student;
import com.curd.util.DBUtils;

public class StudentDAOImpl implements IStudentDao {

	private Connection con;

	public StudentDAOImpl() {
		con = DBUtils.getCinnection();
	}

	@Override
	public void addStudent(final Student student) {
		try {
			String query = "insert into student(studentID, firstName, lastName, course, year) value (?,?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, student.getStudentID());
			pStatement.setString(2, student.getFirstName());
			pStatement.setString(3, student.getLastName());
			pStatement.setString(4, student.getCourse());
			pStatement.setInt(5, student.getYear());
			pStatement.executeUpdate();
			pStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletStudent(final int studentID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStucent(final Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement =  con.createStatement();
            ResultSet resultSet =  statement.executeQuery( "select * from hr.STUDENT" );
            while(resultSet.next()){
            	Student student = new Student();
            	student.setStudentID(resultSet.getInt("studentID"));
            	student.setFirstName(resultSet.getString("firstName"));
            	student.setLastName(resultSet.getString("lastName"));
            	student.setCourse(resultSet.getString("course"));
            	student.setYear(resultSet.getInt("year"));
            	students.add(student);
            }
            resultSet.close();
            statement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(students);
		return students;
	}

	@Override
	public Student getStudentByID(final int studentID) {
		// TODO Auto-generated method stub
		return null;
	}

}
