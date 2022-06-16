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

<form action="save" method="get">

    <h2>Sandwich Condiments</h2>
    <label>Lettuce</label>
    <input type="checkbox" name="condiment" value="Lettuce">
    <label>Tomato</label>
    <input type="checkbox" name="condiment" value="Tomato">
    <label>Mustard</label>
    <input type="checkbox" name="condiment" value="Mustard">
    <label>Sprouts</label>
    <input type="checkbox" name="condiment" value="Sprouts">

    <button>Save</button>
<div>
    <h3>Sandwich Condiments with: </h3>
    <c:forEach items="${condiment}" var="eat">
        <h5>${eat}</h5>
    </c:forEach>
</div>

</form>

</body>
</html>
