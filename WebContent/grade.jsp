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
    <br />
    <hr/>
    <br />

    <h2 align="center">
      <font face="Lato" color="#454545" size="6"><b>GRADES</b></font>
    </h2>
    <br />

    <h3 align="center">
    <a href="<%=request.getContextPath()%>/choosegrade">
      <font face="Lato" color="#000">CHOOSE GRADE</font>
    </a>&nbsp;&nbsp;&nbsp;
    <br /><br />
    
    <a href="<%=request.getContextPath()%>/newGradeForm">
      <font face="Lato" color="#000">ADD GRADES</font>
    </a>&nbsp;&nbsp;&nbsp;
    <br /><br />
    <a href="<%=request.getContextPath()%>/listGrade">
      <font face="Lato" color="#000">GRADE's LIST</font>
    </a>
    </h3>
  </body>
</html>
