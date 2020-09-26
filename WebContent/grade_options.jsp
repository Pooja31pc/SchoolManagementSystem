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
        <a href="<%=request.getContextPath()%>/teacher">TEACHER</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/student">STUDENT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/subject">SUBJECT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/grade">CLASS</a><br /> <br/> 
			
      </font>
	 <!--   <a href="<%=request.getContextPath()%>/newGradeForm">
      		<font face="cinzel" size="4" color="#000">ADD GRADES</font>
    	</a> -->
	</h3>
	 <hr/>
	 <br/>
	 <h3 align="center">
    	<font face="Lato" color="#4caf50" size="5">
       	Choose Required Standard from the List
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
							<td><a href="<%=request.getContextPath()%>/gradewisedetails?gid=<c:out value='${grade.getGid()}' />"><c:out value="${grade.getStandard()}" /></a></td>
<%-- 							<td><a href="edit?srno=<c:out value='${grade.getGid()}' />">Edit</a> --%>
<!-- 								&nbsp;&nbsp;&nbsp;&nbsp; <a -->
<%-- 								href="delete?srno=<c:out value='${grade.getGid()}' />">Delete</a></td> --%>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>			
			</table>
  </body>
</html>
