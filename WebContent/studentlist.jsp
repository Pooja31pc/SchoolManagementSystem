<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Pooja's Website</title>
  </head>
  <body>

    <table class="table table-bordered" border=1 cellspacing=0 cellpadding=10>
				<thead>
					<tr>
						<th>SRNO</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Cls_id</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.getSrno()}" /></td>
							<td><c:out value="${student.getFirstName()}" /></td>
							<td><c:out value="${student.getLastName()}" /></td>
							<td><c:out value="${student.getClsId()}" /></td>
							<td><a href="edit?srno=<c:out value='${student.getSrno()}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?srno=<c:out value='${student.getSrno()}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>			
			</table>


  </body>
</html>
