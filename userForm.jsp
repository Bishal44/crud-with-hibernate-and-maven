<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user form</title>
<%@ include file="header.jsp"%>
</head>

<body>
	<%-- <div>
		<form action="UserController" method="post" enctype="multipart/form-data" class="form-horizontal">
		<div class="form-group">
			<input type="hidden" name="id" value="${user.id }">
			<div>
				<label>First Name</label><input type="text" name="fname"
					value="${user.firstName }">
			</div>
			<div>
				<label>last Name</label><input type="text" name="lname"
					value="${user.lastName }">
			</div>
			<div>
				<label>user Name</label><input type="text" name="uname"
					value="${user.userName }">
			</div>
			<div>
				<label>password</label><input type="text" name="pass"
					value="${user.password }">
			</div>
			<div>
				<label >Email</label><input type="email" name="email" 
					value="${user.email }">
			</div>
			<div>
				<label>Dob</label><input type="date"  name="dob" value="${user.dob }">
			</div>
			<div>
				<label>Gender</label><input type="radio" name="gender" value="Male"
					${user.gender=='Male'?'checked':''or user.gender==null?'checked':'' }>Male<input
					type="radio" name="gender" value="Female"
					${user.gender=='Female'?'checked':''}>Female
			</div>
			<div>
				<label>chose File:</label>
				<div>
					<input type="file" name="photo">
				</div>
			</div>
			<div>
				<input  type="submit" value="submit">
			
				<input  type="reset" value="reset">
				</div>
			</div>
		</form>
	</div>  --%>
	 <div class="container">
		<div class="row">
			<div
				class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 ">
				<div class="panel panel-default">
					<div class="panel-body">
						<form action="UserController" method="post"
							enctype="multipart/form-data" class="form-horizontal">
							<input type="hidden" name="id" value="${user.id}">
							<div class="form-group">
								<label class="control-label col-sm-3">First Name</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="fname"
										value="${user.firstName}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Last Name</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="lname"
										value="${user.lastName}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">User Name</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="uname"
										value="${user.userName}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Password</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="pass"
										value="${user.password}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Email</label>
								<div class="col-sm-9">
									<input type="email" class="form-control" name="email"
										value="${user.email}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">DOB</label>
								<div class="col-sm-9">
									<input type="date" class="form-control" name="dob"
										value="${user.dob}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Gender</label>
								<div class="col-sm-9">
									<input type="radio" name="gender" value="Male"
										${user.gender=='Male'?'checked':'' or user.gender==null?'checked':''}>Male
									<input type="radio" name="gender" value="Female"
										${user.gender=='Female'?'checked':''}>Female
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Choose Photo:</label>
								<div class="col-sm-9">
									<input type="file" name="photo">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9" align="center">
										<button type="submit" class="btn btn-primary"
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