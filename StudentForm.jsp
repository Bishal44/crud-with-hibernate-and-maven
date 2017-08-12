<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/customValidation.js"></script>
<%@ include file="header.jsp"%>
</head>
<body>
<%-- <div>
		<form action="StudentController" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${ student.id}">
			<div>
				<label>Student Name:</label>
				<div>
					<input type="text" name="sname" value="${student.studentName }">
				</div>
			</div>
			<div>
				<label>College Name:</label>
				<div>
					<input type="text" name="cname" value="${student.collegeName }">
				</div>
			</div>
			<div>
				<label>Email:</label>
				<div>
					<input type="email" name="email"value="${student.email }">
				</div>
			</div>
			<div>
				<label>Roll:</label>
				<div>
					<input type="number" name="roll"value="${student.roll }">
				</div>
			</div>
			<div>
				<label>DOB:</label>
				<div>
					<input type="date" name="dob"value="${student.dob }">
				</div>
			</div>
			<div>
				<label>Gender:</label>
				<div>
				
					<input type="radio" name="gender" value="male"${student.gender=='male'?'checked':''or student.gender==null?'checked':'' }>Male <input type="radio"
						name="gender" value="female"${student.gender=='female'?'checked':''}>Female
				</div>
			</div>
			<div>
				<label>Departments:</label>
				<div>
					<select name="departcombo">
					<option value="please select" ${student.department==null?'selected':'' }>Please select</option>
						<option value="IT"${student.department=='IT'?'selected':'' }>IT</option>
						<option value="Electronics"${student.department=='Electronics'?'selected':'' }>Electronics</option>
						<option value="computer"${student.department=='computer'?'selected':'' }>Computer</option>
						<option value="Electrical"${student.department=='Electrical'?'selected':'' }>Electrical</option>
					</select>
				</div>
			</div>
			<div>
				<label>Subject:</label>
				<div>
				<c:set var="subjects"  value="${ student.subject}"/>
					<input type="Checkbox" name="subject" value="Java" <c:if test="${fn:contains(subjects,'Java') }">checked</c:if>>Java <input
						type="Checkbox" name="subject" value="Android" <c:if test="${fn:contains(subjects,'Android') }">checked</c:if>>Android <input
						type="Checkbox" name="subject" value=".Net" <c:if test="${fn:contains(subjects,'.Net') }">checked</c:if>>.Net <input
						type="Checkbox" name="subject" value="php" <c:if test="${fn:contains(subjects,'php') }">checked</c:if>>Php
				</div>
			</div>
			<div>
				<label>chose File:</label>
				<div>
					<input type="file" name="photo">
				</div>
			</div>
			
<div>
			<input type="submit" value="Submit"> <input type="reset"
				value="Reset">
				</div>
		</form>
	</div> --%>
	<div class="container">
		<div class="row">
			<div
				class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 ">
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="StudentController" method="post"
							enctype="multipart/form-data" class="form-horizontal">
							<input type="hidden" name="id" value="${student.id}">
							<div class="form-group">
								<label class="control-label col-sm-3">Student Name:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="sname"
										value="${student.studentName}"
										onkeypress="return  alphabetsOnly(event)">
								</div>
								<div id="name_error" style="color: red"></div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">College Name:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="cname"
										value="${student.collegeName}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Email:</label>
								<div class="col-sm-9">
									<input type="email" class="form-control" name="email"
										value="${student.email}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Roll:</label>
								<div class="col-sm-9">
									<input type="number" class="form-control" name="roll"
										value="${student.roll}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">DOB:</label>
								<div class="col-sm-9">
									<input type="date" class="form-control" name="dob"
										value="${student.dob}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Gender:</label>
								<div class="col-sm-9">
									<input type="radio" name="gender" value="male"
										${student.gender=='male'?'checked':'' or student.gender==null?'checked':''}>Male
									<input type="radio" name="gender" value="female"
										${student.gender=='female'?'checked':''}>Female
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Departments:</label>
								<div class="col-sm-9">
									<select name="departcombo">
					<option value="please select" ${student.department==null?'selected':'' }>Please select</option>
						<option value="IT"${student.department=='IT'?'selected':'' }>IT</option>
						<option value="Electronics"${student.department=='Electronics'?'selected':'' }>Electronics</option>
						<option value="computer"${student.department=='computer'?'selected':'' }>Computer</option>
						<option value="Electrical"${student.department=='Electrical'?'selected':'' }>Electrical</option>
					</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Subject:</label>
								<div class="col-sm-9">
									<input type="checkbox" name="subject" value="Java"
										<c:if test="${fn:contains(student.subject,'Java')}">checked</c:if>>Java
									<input type="checkbox" name="subject" value="Android"
										<c:if test="${fn:contains(student.subject,'Android')}">checked</c:if>>Android
									<input type="checkbox" name="subject" value="Php"
										<c:if test="${fn:contains(student.subject,'Php')}">checked</c:if>>Php
									<input type="checkbox" name="subject" value=".Net"
										<c:if test="${fn:contains(student.subject,'.Net')}">checked</c:if>>.Net
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Choose Photo:</label>
								<div class="col-sm-9">
									<input class="form-control" type="file" name="photo"
										onchange="readUrl(this)">
									<c:if test="${empty student.id }">
										<img alt="" src="" id="pic" height="50px" width="50px">
									</c:if>
									<c:if test="${! empty student.id }">
										<img alt="profilepic"
											src="ImageDisplayServlet?student_id=${student.id}" width="50"
											height="50">
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9" align="center">
									<button type="submit" value="submit" class="btn btn-primary"
										style="font-weight: bold;">Submit</button>
									<button type="reset" class="btn btn-danger"
										style="font-weight: bold;">Reset</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>