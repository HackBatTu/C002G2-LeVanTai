<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/5/2022
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style type="text/css">
        .login {
            height: 200px;
            width: 210px;
            margin: 0;
            padding: 10px;
            border: 1px solid red;
        }

        .login input {
            padding: 4px;
            margin: 4px
        }
    </style>
</head>
<body>
<form action="/display-discount" method="post">
    <div class="login">
        <label>Product Description: </label><br/>
        <textarea name="productDescription" placeholder="Enter your Product Description: "></textarea>
        <br>
        <label>List Price: </label><br/>
        <input type="text" name="listPrice" placeholder="Enter your List Price: "/>
        <br>
        <label>Discount Percent: </label><br/>
        <input type="text" name="discountPercent" placeholder="Enter your Discount Percent: "/>
        <br>
        <input type="submit" name="Calculate Discount" value="calculate">
    </div>
</form>
</body>
</html>
