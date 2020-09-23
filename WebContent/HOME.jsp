<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Pooja's Website</title>
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
        <a href="<%=request.getContextPath()%>/teacher">TEACHER</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/student">STUDENT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/subject">SUBJECT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/grade">CLASS</a>
      </font>
    </h3>
    <br /><br />
    <hr/>
    <p><i>Learner’s Academy is a school that has an online management system.
      The system keeps track of its classes, subjects, students, and teachers.
      It has a back-office application with a single administrator login.
    </i></p>

  </body>
</html>
