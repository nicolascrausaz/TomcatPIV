<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>X.509 Authentication Demo</title>

</head>
<body>

	<h1>Login Page</h1>
	<form action="/piv-main/redirect" method="get">
		<input type="submit" value="PIV AUTH" />
	</form>
	<br>
	<form method="GET" action="/piv-main/userlogin">
		Username: <input type="text" name="username" /> Password: <input
			type="password" name="password" /> <br> <input type="submit"
			value="login" />
	</form>
</body>
</html>
