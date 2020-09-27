<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>

	<h1 align="center">
		<font face="Lato" color="#009879" size="7"> LEARNER's ACADEMY </font>
	</h1>
	<hr />
	<br />
	<br />
	<br />
	<br />
	<h2 align="center">
		<font face="Lato" color="#009879" size="5">Log in to LEARNER's
			ACADEMY </font>
	</h2>
	<br />
	<br />
	<h3 align="center">
		<form action="<%=request.getContextPath()%>/login" method="GET">
			<div>
				<label>UserName:</label> <input type="text" name="uname"
					placeholder="UserName" required>
			</div>
			<div>
				<label>Password:</label> <input type="password" name="pass"
					placeholder="Password" required>
			</div>
			<br /> <input type="submit" value="Log in">
		</form>
	</h3>
</body>
</head>