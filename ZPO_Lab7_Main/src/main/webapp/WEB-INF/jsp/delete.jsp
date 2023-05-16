<%--
  Created by IntelliJ IDEA.
  User: Cezary
  Date: 15.05.2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/delete">
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required>
    <button type="submit">delete</button>
</form>

</body>
</html>
