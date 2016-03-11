package com.curd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import com.curd.dao.IStudentDao;
import com.curd.dao.StudentDAOImpl;
import com.curd.model.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4248867790303346443L;
	private IStudentDao dao;

	private static final String LIST_STUDENTS = "/listStudents.jsp";
	private static final String INSERT_OR_EDIT_STUDENT = "/student.jsp";

	public StudentController(){
		dao = new StudentDAOImpl();
	}
	protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert")){
			forward = INSERT_OR_EDIT_STUDENT;
		}else{
			forward = LIST_STUDENTS;
			System.out.println(forward);
			request.setAttribute("students", dao.getAllStudents());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setFirstName( request.getParameter( "firstName" ) );
        student.setLastName( request.getParameter( "lastName" ) );
        student.setCourse( request.getParameter( "course" ) );
        student.setYear( Integer.parseInt( request.getParameter( "year" ) ) );
        String studentId = request.getParameter("studentID");
 
        if( studentId == null || studentId.isEmpty() )
            dao.addStudent(student);
        else {
            student.setStudentID( Integer.parseInt(studentId) );
            dao.addStudent(student);
        }
        RequestDispatcher view = request.getRequestDispatcher( LIST_STUDENTS );
        request.setAttribute("students", dao.getAllStudents());
        view.forward(request, response);
    }
}
