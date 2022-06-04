<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2022
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management Application</title>

</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/student">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Student
                </h2>
            </caption>
                <input type="hidden" name="id" value="${id}"/>
            <tr>
                <th>User Name:</th>
                <td><input type="text" name="name" size="45" value="${name}" /></td>
            </tr>
            <tr>
                <th>User Point:</th>
                <td><input type="text" name="point" size="45" value="${point}"></td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td><input type="text" name="gender" size="15" value="${gender}"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
