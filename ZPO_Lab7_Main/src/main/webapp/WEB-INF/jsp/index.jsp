<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cezary
  Date: 13.05.2023
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="Student" type=""--%>
<%--<form:form method="post" modelAttribute="Student">--%>
<%--    <label for="id">id:</label>--%>
<%--    <form:input path="id" type="text" id="id"/>--%>
<%--    <br/>--%>
<%--    <label for="firstName">firstName:</label>--%>
<%--    <form:input path="firstName" type="text" id="firstName"/>--%>
<%--    <br/>--%>
<%--    <label for="lastName">lastName:</label>--%>
<%--    <form:input path="lastName" type="text" id="lastName"/>--%>
<%--    <br/>--%>
<%--    <label for="age">age:</label>--%>
<%--    <form:input path="age" type="text" id="age"/>--%>
<%--    <br/>--%>

<%--    <form:button type="submit" formaction="/getById">getById</form:button>--%>
<%--    <form:button type="submit" value="/add">add</form:button>--%>
<%--    <form:button type="submit" value="/update">update</form:button>--%>
<%--    <form:button type="submit" value="/delete">delete</form:button>--%>
<%--</form:form>--%>

<%--<form:form method="post" >--%>
<%--    <form:button type="submit" formaction="/getById">getById</form:button>--%>
<%--    <form:button type="submit" formaction="/add">add</form:button>--%>
<%--    <form:button type="submit" formaction="/update">update</form:button>--%>
<%--    <form:button type="submit" formaction="/delete">delete</form:button>--%>
<%--</form:form>--%>

<form method="get" action="/">
    <button type="submit" formaction="/getById">getById</button>
    <button type="submit" formaction="/add">add</button>
    <button type="submit" formaction="/update">update</button>
    <button type="submit" formaction="/delete">delete</button>
</form>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
</style>

<table>
    <tr>
        <th>Id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Wiek</th>
        <!-- Dodaj inne kolumny, jeśli są dostępne -->
    </tr>
    <c:forEach items="${Students}" var="row">
        <tr>
            <td>${row.id}</td>
            <td>${row.firstName}</td>
            <td>${row.lastName}</td>
            <td>${row.age}</td>
            <!-- Dodaj inne kolumny, jeśli są dostępne -->
        </tr>
    </c:forEach>
</table>

</body>
</html>
