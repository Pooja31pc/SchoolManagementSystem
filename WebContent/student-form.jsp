 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand"> Student Application </a>

			</div>
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="srno" value="<c:out value='${student.getSrno()}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Student FirstName</label> <input type="text"
						value="<c:out value='${student.getFirstName()}' />" class="form-control"
						name="FirstName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Student LastName</label> <input type="text"
						value="<c:out value='${student.getLastName()}' />" class="form-control"
						name="LastName">
				</fieldset>

				<fieldset class="form-group">
					<label>Student Cls_id</label> <input type="text"
						value="<c:out value='${student.getClsId()}' />" class="form-control"
						name="Cls_id">
				</fieldset>
				
				
				<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Grade Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Grades</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${grade != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${grade == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${grade != null}">
            			Edit Grade
            		</c:if>
						<c:if test="${grade == null}">
            			Add New Grade
            		</c:if>
					</h2>
				</caption>

				<c:if test="${grade != null}">
					<input type="hidden" name="Cid" value="<c:out value='${grade.getCid()}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Grade standard</label> <input type="text"
						value="<c:out value='${grade.getStandard()}' />" class="form-control"
						name="standard" required="required">
				</fieldset>
				
				
				
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>