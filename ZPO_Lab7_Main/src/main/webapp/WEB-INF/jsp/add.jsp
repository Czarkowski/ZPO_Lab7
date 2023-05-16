<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Cezary
  Date: 15.05.2023
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="Student" type=""--%>
<form:form method="post" modelAttribute="Student">
    <label for="firstName">firstName:</label>
    <form:input path="firstName" type="text" id="firstName"/>
    <br/>
    <label for="lastName">lastName:</label>
    <form:input path="lastName" type="text" id="lastName"/>
    <br/>
    <label for="age">age:</label>
    <form:input path="age" type="text" id="age"/>
    <br/>

    <form:button type="submit" >add</form:button>
</form:form>
</body>
</html>
