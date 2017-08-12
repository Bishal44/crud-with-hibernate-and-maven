<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user list</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<br>
	<br>
	<br>
	<a href="UserController?actions=add_new">
				<button class="btn btn-info navbar-btn" style="margin-left: 90%;">Add
					User</button>
					</a>
	<c:if test="${!empty users}">
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>UserId</th>
					<th>User name</th>
					<th>First name</th>
					<th>last name</th>
					<th>Email</th>
					<th>Dob</th>
					<th>Gender</th>
					<th>password</th>
					<th>photo</th>
					<th>Acttions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${users }" var="user">
					<tr>
						<td><c:out value="${user.id }"></c:out></td>
						<td><c:out value="${user.userName }"></c:out></td>
						<td><c:out value="${user.firstName }"></c:out></td>
						<td><c:out value="${user.lastName }"></c:out></td>
						<td><c:out value="${user.email }"></c:out></td>
						<td><c:out value="${user.dob }"></c:out></td>
						<td><c:out value="${user.gender }"></c:out></td>
						<td><c:out value="${user.password }"></c:out></td>
						<td> <img alt="profile pic" src="ImageDisplayServlet?user_id=${user.id }" height="50" width="50"></td>
						<td><a href="UserController?actions=edit&id=${user.id }">Edit</a>
							<a href="UserController?actions=delete&id=${user.id }">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</c:if>

</body>
</html>