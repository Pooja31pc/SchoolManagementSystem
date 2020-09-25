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
    	font-size:0.9cm;
    	font-family:Arial;
    	color:#ffffff;
    }
    table, th, td{
    	border:1px dotted white;
    	border-collapse:collapse;
    	padding:10px;
    	font-size:10px;
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
	 <!--   <a href="<%=request.getContextPath()%>/newGradeForm">
      		<font face="cinzel" size="4" color="#000">ADD GRADES</font>
    	</a> -->
	</h3>
	 <hr/>
    <table class="table table-bordered" border=1 cellspacing=0 cellpadding=10>
				<thead>
					<tr>
						<th>GID</th>
						<th>Standard</th>
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
