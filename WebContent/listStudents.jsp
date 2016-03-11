<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show all Students</title>
</head>
<body>
	<table border="2" background="" bgcolor="#C16623">
		<thead>
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Course</th>
				<th>Year</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.studentID }" /></td>
					<td><c:out value="${student.firstName }" /></td>
					<td><c:out value="${student.lastName }" /></td>
					<td><c:out value="${student.course }" /></td>
					<td><c:out value="${student.year }" /></td>
					<td><a
						href="StudentController.do?action=edit&studentID=<c:out value ="${student.studentID }"/>">Update</a></td>
					<td><a
						href="StudentController.do?action=delete&studentID=<c:out value ="${student.studentID }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="StudentController.do?action=insert">Add Student</a>
	</p>
</body>
</html>