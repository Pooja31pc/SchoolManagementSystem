<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>LEARNER's ACADEMY</title>
</head>
<body link="#000" alink="017bf5" vlink="#000">
	<h1 align="center">
		<font face="Lato" color="#4caf50" size="7"> LEARNER's ACADEMY </font>
	</h1>
	<hr />
	<br />

	<h3>
		<font face="cinzel" size="4"> <a
			href="<%=request.getContextPath()%>/home">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/teacher">TEACHER</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/student">STUDENT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/subject">SUBJECT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/grade">CLASS</a><br /> <br />
			<hr />
		</font>
	</h3>
	<br />
	<form action="<%=request.getContextPath()%>/insertteachersubject"
		method="GET">
		<h3 align="center">
			<font face="Lato" color="#4caf50" size="4"> <u>Enter IDs</u>
			</font> <br />
			<br />
			<div>
				<label>TeacherId</label> <input type="text" name="teacherid"
					placeholder="TeacherId" required>
			</div>
			<div>
				<label>SubjectId</label> <input type="text" name="subjectid"
					placeholder="SubjectId" required>
			</div>
			<div>
				<label>ClassId</label> <input type="text" name="classid"
					placeholder="ClassId" required>
			</div>
			<br />
			<button type="submit" class="btn btn-success">Save</button>
		</h3>
	</form>
</body>
</html>
