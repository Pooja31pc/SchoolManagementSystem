<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Pooja's Website</title>
    <style>
    body{
    	background:gray;
    }
    table{
    	width:800px;
    	margin:auto;
    	table-layout:fixed;
    	text-align:center;
    	margin-top:50px;
    	font-family:Arial;
    	color:#fff;
    }
    table, th, td{
    	border:1px dotted white;
    	border-collapse:collapse;
    	padding:10px;
    	font-size:20px;
    }
    th{
    	background:purple;
    	padding:20px;
    	text-transform:uppercase;
    }
    
    </style>
  </head>
  <body>

	<h3>
      <font face="cinzel" size="4">
        <a href="<%=request.getContextPath()%>/home">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
	    <a href="<%=request.getContextPath()%>/newSubjectForm">
      		<font face="cinzel" size="4" color="#000">ADD SUBJECTS</font>
    	</a>
	</h3>
	 <hr/>

    <table class="table table-bordered" border=1 cellspacing=0 cellpadding=10>
				<thead>
					<tr>
						<th>SID</th>
						<th>SubjectName</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="subject" items="${listSubject}">

						<tr>
							<td><c:out value="${subject.getSid()}" /></td>
							<td><c:out value="${subject.getSubjectName()}" /></td>
							<td><a href="edit?srno=<c:out value='${subject.getSid()}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?srno=<c:out value='${subject.getSid()}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>			
			</table>
  </body>
</html>
