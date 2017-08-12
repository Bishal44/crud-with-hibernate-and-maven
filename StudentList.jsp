<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student list</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<a href="StudentController?actions=add_new"><button class="btn btn-info navbar-btn" style="margin-left: 90%;">Add
					Student</button></a>
	<c:if test="${!empty students}">
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Id</th>
					<th>Student Name</th>
					<th>College Name</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Roll</th>
					<th>DOB</th>
					<th>Subject</th>
					<th>Departments</th>
					<th>photo</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td><c:out value="${student.id}"></c:out></td>
						<td><c:out value="${student.studentName}"></c:out></td>
						<td><c:out value="${student.collegeName}"></c:out></td>
						<td><c:out value="${student.gender}"></c:out></td>
						<td><c:out value="${student.email}"></c:out></td>
						<td><c:out value="${student.roll}"></c:out></td>
						<td><c:out value="${student.dob}"></c:out></td>
						<td><c:out value="${student.subject}"></c:out></td>
						<td><c:out value="${student.department}"></c:out></td>
						<td> <img alt="profile pic" src="ImageDisplayServlet?id=${student.id }"height="50" width="50"></td>
						<td><a href="StudentController?actions=edit&id=${student.id}">Edit</a>
							<a href="StudentController?actions=delete&id=${student.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>


</body>
</html>