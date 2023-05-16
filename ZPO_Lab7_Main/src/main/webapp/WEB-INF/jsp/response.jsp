<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cezary
  Date: 15.05.2023
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="student" type=""--%>
<form:form method="get" modelAttribute="student" action="/">
    <label >id:</label>
    <c:out value="${student.id}"/>
    <br/>
    <label >firstName:</label>
    <c:out value="${student.firstName}"/>
    <br/>
    <label >lastName:</label>
    <c:out value="${student.lastName}"/>
    <br/>
    <label >age:</label>
    <c:out value="${student.age}"/>
    <br/>
    <form:button type="submit">Return</form:button>
</form:form>
</body>
</html>
