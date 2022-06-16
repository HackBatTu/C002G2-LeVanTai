<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/6/2022
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="/link" method="post">
    <h2>Calculator</h2>
    <div>
        <input type="text" name="number1">
        <input type="text" name="number2">
    </div>
    <div>
        <input type="submit" name="operator" value="addition(+)">
        <input type="submit" name="operator" value="subtraction(-)">
        <input type="submit" name="operator" value="multiplication(x)">
        <input type="submit" name="operator" value="division(/)">
    </div>
    <div>
        Result : ${result}
    </div>
    <h3 style="color: red">${reviews}</h3>
</form>

</body>
</html>
