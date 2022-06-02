<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2022
  Time: 10:15 PM
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
    <a href="student?action=students">List All Student</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">

      <caption><h2>Add New Student</h2></caption>
      <tr>
        <th>Student Name:</th>
        <td><input type="text" name="name" id="name" size="45"/></td>
      </tr>
      <tr>
        <th>Point Student:</th>
        <td><input type="text" name="point" id="point" size="45"/></td>
      </tr>
      <tr>
        <th>Gender Student</th>
        <td><input type="text" name="gender" id="gender" size="15"/></td>
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
