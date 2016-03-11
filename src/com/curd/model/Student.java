package com.curd.model;

public class Student {
	private int studentID;
	private String firstName;
	private String lastName;
	private String course;
	private int year;

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Student [StudentID = " + studentID + " FirstName = "
				+ firstName + " LastName = " + lastName + " Course = " + course
				+ " Year = " + year + " ]";
	}
}
