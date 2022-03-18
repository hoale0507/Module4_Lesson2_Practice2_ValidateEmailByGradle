<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/3/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Validate Email</h1>
<h3 style="color:red">${message}</h3>
<form action="/validate">
    <input type="text" name="email">
    <button>Validate</button>
</form>
</body>
</html>
