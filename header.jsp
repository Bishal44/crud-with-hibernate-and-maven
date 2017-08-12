<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap-reboot.min.css" rel="stylesheet"> 
<link href="resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap-grid.min.css" rel="stylesheet">
<script type="text/javascript" src="resources/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.min.js"></script>
<script  type="text/javascript" src="resources/jquery-3.2.1.min.js"></script>
<body>
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#"></a>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-md-0">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="StudentController?actions=student_list">student</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="UserController?actions=user_list">User</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="logincontroller">logout</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="" > <%=session.getAttribute("username") %></a>
      </li>
    
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

</body>
</html>