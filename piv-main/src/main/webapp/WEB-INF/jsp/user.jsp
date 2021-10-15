<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>X.509 Authentication Demo</title>
</head>
<body>
	<h1>Login Successful!</h1>

	<form action="/piv-main/user">
		Username:
		<c:out value="${username}" />
		<br> <input type="submit" value="Back" />
	</form>
</body>
</html>
