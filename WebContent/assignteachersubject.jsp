<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Teacher's Subject</title>
  </head>
  <body link="#000" alink="017bf5" vlink="#000">
    <h1 align="center">
      <font face="Lato" color="#4caf50" size="7">
        LEARNER's ACADEMY
      </font>
    </h1>
     <hr/>
    <br />

    <h3>
      <font face="cinzel" size="4">
        <a href="<%=request.getContextPath()%>/home">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
    </h3>

    <form action="<%=request.getContextPath()%>/insertteachersubject" method="GET">
      <div>
        <label>TeacherId</label>
        <input type="text" name="teacherid" placeholder="TeacherId" required>
      </div>
      <div>
        <label>SubjectId</label>
        <input type="text" name="subjectid" placeholder="SubjectId" required>
      </div>
      <div>
        <label>ClassId</label>
        <input type="text" name="classid" placeholder="ClassId" required>
      </div>
      <button type="submit" class="btn btn-success">Save</button>
    </form>
  </body>
</html>
