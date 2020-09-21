<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Teacher's Form</title>
  </head>
  <body link="#000" alink="017bf5" vlink="#000">
    <h1 align="center">
      <font face="Lato" color="#017bf5" size="7">
        SCHOOL MANAGEMENT PROJECT
      </font>
    </h1>
    <br />

    <h3>
      <font face="cinzel" size="4">
        <a href="HOME.html">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
    </h3>

    <form action="<%=request.getContextPath()%>/insertStudent" method="GET">
      <div>
        <label>FirstName</label>
        <input type="text" name="FirstName" required>
      </div>
      <div>
        <label>LastName</label>
        <input type="text" name="LastName" required>
      </div>
      <div>
        <label>Cls_id</label>
        <input type="number" name="Cls_id" required min="1">
      </div>
      <button type="submit" class="btn btn-success">Save</button>
    </form>
  </body>
</html>
