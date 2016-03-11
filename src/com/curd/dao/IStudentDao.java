package com.curd.dao;

import java.util.List;

import com.curd.model.Student;

public interface IStudentDao {

	public void addStudent(final Student student);

	public void deletStudent(final int studentID);

	public void updateStucent(final Student student);

	public List<Student> getAllStudents();

	public Student getStudentByID(final int studentID);

}
