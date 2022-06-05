<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/customer">List All employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <%--            public Customer(CustomerType customerType, String name, String birthDay, int gender, String idCard, String phone, String email, String address) {--%>
            <caption><h2>Add New Customer</h2></caption>
            <tr>
                <th>Customer Type:</th>
                <td><input type="text" name="customerType" id="customerType" size="45"/></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" id="name" size="45"/></td>
            </tr>
            <tr>
                <th>Birth Day</th>
                <td><input type="text" name="birthDay" id="birthDay" size="15"/></td>
            </tr>
            <tr>
                <th>Gender</th>
                <td><input type="text" name="gender" id="gender" size="15"/></td>
            </tr>
            <tr>
                <th>id Card</th>
                <td><input type="text" name="idCard" id="idCard" size="15"/></td>
            </tr>
            <tr>
                <th>phone</th>
                <td><input type="text" name="phone" id="phone" size="15"/></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="text" name="email" id="email" size="15"/></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><input type="text" name="address" id="address" size="15"/></td>
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

