<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2022
  Time: 3:31 PM
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
        <a href="/student?action=add">Add New Student</a>
    </h2>
</center>
<div align="center">
    <form method="get" action="/student">
        <input type="hidden" name="action" value="search">
        <input type="text" placeholder="Enter the Name" name="name">
        <input type="submit" name="name" value="search">
    </form>
    <table border="1" cellpadding="5">
        <caption><h2>List of Student</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Point</th>
            <th>Gender</th>
            <th>Ranks</th>
            <th>.....</th>
        </tr>
        <c:forEach var="s" items="${listStudent}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.point}</td>
                <td>
                    <c:if test="${s.gender==0}"> FeMale</c:if>
                    <c:if test="${s.gender==1}"> Male</c:if>
                    <c:if test="${s.gender==null}"> Other</c:if>
                </td
                <td>
                    <c:choose>
                        <c:when test="s.point > 8"> Giỏi </c:when>
                        <c:when test="s.point > 6.5">Khá</c:when>
                        <c:when test="s.point > 5">TB</c:when>
                        <c:when test="s.point < 5">Yếu</c:when>
                    </c:choose>
                </td>
                <td>
                    <a href="/student?action=edit&id=${s.id}">Edit</a>
                    <a href="/student?action=delete&id=${s.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/student?action=sortByName">Sort By Name</a>
</div>
</body>
</html>
