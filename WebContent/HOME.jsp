<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body link="#000" alink="017bf5" vlink="#000">

	<%
    	if(session.getAttribute("username")==null)
    	{
    		response.sendRedirect("login.jsp");
    	}
    %>


	<h1 align="center">
		<font face="Lato" color="#009879" size="7"> LEARNER's ACADEMY </font>
	</h1>
	<hr />
	<br />

	<h3>
		<font face="cinzel" size="4"> <!--  <a href="<%=request.getContextPath()%>/home">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  -->
			<a href="<%=request.getContextPath()%>/teacher">TEACHER</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/student">STUDENT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/subject">SUBJECT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/grade">CLASS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<a href="<%=request.getContextPath()%>/login">Logout</a>
		</font>
	</h3>
	<br />
	<hr />
	<br />
	<hr />
	<br />
	<br />

	<p>
		<i>Learner's Academy is co-educational school run with a tradition
			of providing quality education. It stands behind Jawahar Lal Research
			Center , Sector - xyz. Learner's Academy , is one of the satellite
			schools in the chain of schools run by The SimpliLearn, a non-profit
			making organization, dedicated to the cause of quality education in
			India and abroad. Learner's Academy have been a constant source of
			guidance and encouragement to the school, from time to time. </i>
	</p>

	<!--  <form action="logout">
		<input type="submit" value="logout">
	</form> -->

</body>
</html>
