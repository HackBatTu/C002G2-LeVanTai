<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2022
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>View User Country</title>
</head>
<body>
<h1>Users details</h1>
<p>
    <a href="/users">Back to User list</a>
</p>
<table border="1" cellpadding="5">
    <caption><h2>List of Users</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th colspan="2">Actions</th>
    </tr>
    <c:forEach var="user" items="${listUser}">
    <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>