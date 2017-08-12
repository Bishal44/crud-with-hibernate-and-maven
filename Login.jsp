<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<link rel="stylesheet" type="text/css"
	href="resources/customcss/demo.css">
<script type="text/javascript">
	function validateForm() {
		if (document.login_form.uname.value == "") {
			alert("Username should not be left blank");
			document.login_form.uname.focus();
			return false;
		} else if (document.login_form.pass.value
				.search(/^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/)) {
			alert("Password does not match");
			return false;
		}

	}
</script>
</head>
<body>
<!-- <div>
<form action="logincontroller" method="post">
<div>
<lable>username</lable>
<div> <input type ="text" name="uname"></div>
</div>

<div>
<lable>password</lable>
<div> <input type ="password" name="pass"></div>
</div>
<div>

<input type="submit" value="login">
<input type="reset" value="reset">
</div>
</form> -->

<div class="login">
		<form name="login_form" action="logincontroller" method="post"
			onsubmit="return validateForm()">
			<input type="text" placeholder="Username" name="uname"> <input
				type="password" placeholder="password" name="pass"> <input
				type="submit" value="Log In">
		</form>
	</div>

</body>
</html>
