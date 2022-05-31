<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/5/2022
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td><input type="text" name="name" id="name" value="${requestScope["products"].getName()}"></td>
    </tr>
    <tr>
        <td>Prince: </td>
        <td><input type="text" name="prince" id="prince" value="${requestScope["products"].getPrince()}"></td>
    </tr>
    <tr>
        <td>Describe: </td>
        <td><input type="text" name="describe" id="describe" value="${requestScope["products"].getDescribe()}"></td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td><input type="text" name="manufacturer" id="manufacturer" value="${requestScope["products"].getManufacturer()}"></td>
    </tr>
</table>
</body>
</html>
