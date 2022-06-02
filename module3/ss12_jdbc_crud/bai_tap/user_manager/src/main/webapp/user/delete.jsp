<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2022
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Deleting customer</title>
</head>
<body>
<h1>Delete User</h1>
<p>
  <a href="/users">Back to User list</a>
</p>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>User information</legend>
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
      </tr>
      <c:forEach var="user" items="${listUser}">
        <tr>
          <td>${user.id}</td>
          <td>${user.name}</td>
          <td>${user.email}></td>
          <td>${user.country}</td>
        </tr>
      </c:forEach>
  <tr>
        <td><input type="submit" value="Delete user"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
