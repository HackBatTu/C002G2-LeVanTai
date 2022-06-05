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
        <a href="/employee">List All employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <%--            public Customer(CustomerType customerType, String name, String birthDay, int gender, String idCard, String phone, String email, String address) {--%>
            <caption><h2>Add New Customer</h2></caption>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" id="name" size="45"/></td>
            </tr>
            <tr>
                <th>Birth Day</th>
                <td><input type="text" name="birthDay" id="birthDay" size="15"/></td>
            </tr>
            <tr>
                <th>id Card</th>
                <td><input type="text" name="idCard" id="idCard" size="15"/></td>
            </tr>
            <tr>
                <th>Salary</th>
                <td><input type="text" name="salary" id="salary" size="15"/></td>
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
                <th>Position</th>
                <td>
                    <select name="employeePosition" id="employeePosition">
                        <option value="Lễ tân">Lễ tân</option>
                        <option value="Phục vụ">Phục vụ</option>
                        <option value="Chuyên viên">Chuyên viên</option>
                        <option value="Giám sát">Giám sát</option>
                        <option value="Quản lý">Quản lý</option>
                        <option value="Giám Đốc">Giám Đốc</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>EducationDegree</th>
                <td>
                    <select name="educationDegree" id="educationDegree">
                        <option value="Trung cấp">Trung cấp</option>
                        <option value="Cao đẳng">Cao đẳng</option>
                        <option value="Đại học">Đại học</option>
                        <option value="Sau Đại học">Sau Đại học</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division</th>
                <td>
                    <select name="division" id="division">
                        <option value="Sale">Sale</option>
                        <option value="Marketing">Marketing</option>
                        <option value="Phục vụ">Phục Vụ</option>
                        <option value="Quản lí">Quản lí</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>User</th>
                <td><input type="text" name="userName" id="userName" size="15"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="create"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

