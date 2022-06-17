<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/6/2022
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        .update {
            background-color: springgreen;
            border: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<form:form action="/mailbox" method="post" modelAttribute="mailBox">
    <h1>Settings</h1>
    <fieldset>
        <legend>mail box</legend>
        <table>
            <tr>
                <td><b>Languages</b></td>
                <td>
                    <form:select path="languages">
                        <form:option value="English"> English</form:option>
                        <form:option value="Vietnamese"> Vietnamese</form:option>
                        <form:option value="Japanese"> Japanese</form:option>
                        <form:option value="Chinese"> Chinese</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><b>Page Size </b></td>
                <td>Show
                    <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="100"> 100</form:option>
                    </form:select> emails per page
                </td>

            </tr>
            <tr>
                <td><b>Spams filter</b></td>
                <td>
                    <form:checkbox path="spamsFilter"/>
                    Enable spams filter
                </td>
            </tr>
            <tr>
                <td><b>Signature</b></td>
                <td><form:textarea style="height: 80px" path="signature"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update" class="update"/>
                    <input type="reset" value="cancel" class="update"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>

<fieldset>
    <legend>mail box</legend>
    <div>Languages: ${mailBoxResult.languages}</div>
    <div>Page Size : ${mailBoxResult.pageSize}</div>
    <div>Spams filter : ${mailBoxResult.spamsFilter}</div>
    <div>Signature : ${mailBoxResult.signature}</div>
</fieldset>

</body>
</html>
