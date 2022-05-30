<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/5/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" >
    <thead>Danh sách khách hàn</thead>
    <tr>
        <th>Name Customer</th>
        <th>Date</th>
        <th>Address</th>
        <th>Picture</th>
    </tr>
    <c:forEach var="temp" items="${listCustomer}">
        <tr>
            <td>${temp.name}</td>
            <td>${temp.date}</td>
            <td>${temp.address}</td>
            <td>
                <img src="${temp.picture}" width="30" alt="">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
