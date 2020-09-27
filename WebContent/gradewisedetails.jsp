<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>LEARNER's ACADEMY</title>
<style>
table {
	width: 800px;
	margin: auto;
	table-layout: fixed;
	text-align: center;
	margin-top: 50px;
	font-family: 'Quicksand', sans-serif;
	color: #000000;
	font-weight: bold;
}

table, th, td {
	border: 1px dotted black;
	border-collapse: collapse;
	padding: 10px;
	font-size: 10px;
}

th {
	background: #009879;
	color: white;
	padding: 20px;
	text-transform: uppercase;
}
</style>
</head>
<body>

	<%
		if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<h3>
		<br /> <font face="cinzel" size="4"> <a
			href="<%=request.getContextPath()%>/home">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/teacher">TEACHER</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/student">STUDENT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/subject">SUBJECT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/grade">CLASS</a><br /> <br />
			<hr />
		</font>
	</h3>
	<h2 align="center">
		<font face="Lato" color="#009879" size="5"> Class Details </font>

	</h2>
	<hr />

	<h2>
		<font face="Lato" color="#009879" size="4"><u>Students
				List: </u></font>
	</h2>

	<table class="table table-bordered" border=1 cellspacing=0
		cellpadding=10>
		<thead>
			<tr>
				<th>SRNO</th>
				<th>FirstName</th>
				<th>LastName</th>

			</tr>
		</thead>

		<tbody>
			<!--   for (Todo todo: todos) {  -->
			<c:forEach var="student" items="${listGradeWiseStudent}">

				<tr>
					<td><c:out value="${student.getSrno()}" /></td>
					<td><c:out value="${student.getFirstName()}" /></td>
					<td><c:out value="${student.getLastName()}" /></td>

				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>
	</table>
	<br />
	<hr />
	<h2>
		<font face="Lato" color="#009879" size="4"><u>Teacher-Subject
				Details: </u></font>
	</h2>
	<table class="table table-bordered" border=1 cellspacing=0
		cellpadding=10>
		<thead>
			<tr>
				<th>SubjectName</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Standard</th>

			</tr>
		</thead>

		<tbody>
			<!--   for (Todo todo: todos) {  -->
			<c:forEach var="teacherSubjectGrade"
				items="${listSubjectTeacherGrade}">

				<tr>
					<td><c:out value="${teacherSubjectGrade.getSubjectName()}" /></td>
					<td><c:out value="${teacherSubjectGrade.getFirstName()}" /></td>
					<td><c:out value="${teacherSubjectGrade.getLastName()}" /></td>
					<td><c:out value="${teacherSubjectGrade.getStandard()}" /></td>
					<!--  	<td><a href="edit?srno=<c:out value='${TeacherSubjectGrade.getSid()}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?srno=<c:out value='${TeacherSubjectGrade.getSid()}' />">Delete</a></td> -->
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>
	</table>

</body>
</html>
