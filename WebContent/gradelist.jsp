<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>LEARNER's ACADEMY</title>
    <style>
   
    table{
    	width:800px;
    	margin:auto;
    	table-layout:fixed;
    	text-align:center;
    	margin-top:50px;
    	font-size:0.9cm;
    	font-family:'Quicksand',sans-serif;
    	color:#000000;
    	font-weight:bold;
    }
    table, th, td{
    	border:1px dotted black;
    	border-collapse:collapse;
    	padding:10px;
    	font-size:10px;
    }
    th{
    	background:#009879;
    	color:white;
    	padding:20px;
    	text-transform:uppercase;
    }
    
    </style>
  </head>
  <body>

<%
    	if(session.getAttribute("username")==null)
    	{
    		response.sendRedirect("login.jsp");
    	}
    %>

	<h3><br/>
      <font face="cinzel" size="4">
        <a href="<%=request.getContextPath()%>/home">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
      <a href="<%=request.getContextPath()%>/grade">CLASS</a><br /> <br/> 
      <hr/>
	    <a href="<%=request.getContextPath()%>/newGradeForm">
      		<font face="cinzel" size="4" color="#009879">ADD CLASS</font>
    	</a>
	</h3>
	 <hr/>
	 <br/>
	<h3 align="center">
    	<font face="Lato" color="#009879" size="5">
       	Class Details
      </font>
      <br/>
    </h3>
	 
    <table class="table table-bordered" border=1 cellspacing=0 cellpadding=10>
				<thead>
					<tr>
						<th>GID</th>
						<th>Class</th>
						
					</tr>
				</thead>
				
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="grade" items="${listGrade}">

						<tr>
							<td><c:out value="${grade.getGid()}" /></td>
							<td><c:out value="${grade.getStandard()}" /></td>
							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>			
			</table>
  </body>
</html>
