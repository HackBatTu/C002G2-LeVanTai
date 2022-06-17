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
    .update{
      background-color: springgreen;
      border: none;
      border-radius: 5px;
    }
  </style>
<form:form action="/long" method="post" modelAttribute="music">
  <h1>Settings</h1>
  <fieldset>
    <legend> Box Music</legend>
    <table>
      <tr>
        <td>The Song</td>
        <td><form:input path="name"/></td>
      </tr>
      <tr>
        <td>Author</td>
        <td><form:input path="author"/></td>
      </tr>
      <tr>
        <td><b>Category</b></td>
        <td>
          <form:select path="category">
            <form:option value="Rap"> Rap</form:option>
            <form:option value="UK"> UK</form:option>
            <form:option value="US"> US</form:option>
            <form:option value="Rock"> Rock</form:option>
            <form:option value="TikTok"> TikTok</form:option>
            <form:option value="Bolero"> Bolero</form:option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td><b>Link  </b></td>
        <td>
          <form:select path="link">
            <form:option value="https://www.youtube.com/watch?v=cHpNIZjxzsY&t=230s"> Giàu vì bạn sang vì vợ</form:option>
            <form:option value="https://www.youtube.com/watch?v=RgKAFK5djSk">See You Again</form:option>
            <form:option value="https://www.youtube.com/watch?v=2Vv-BfVoq4g">Perfect</form:option>
            <form:option value="https://www.youtube.com/watch?v=XZgiNnGB8m4">Rock</form:option>
            <form:option value="https://www.youtube.com/watch?v=yc69qoW5nUA&t=4088s">TikTok top 2022</form:option>
            <form:option value="https://www.youtube.com/watch?v=kPnIqaEP2W0"> Bolero</form:option>
          </form:select>
        </td>
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
  <legend>Box Music</legend>
  <div>The song : ${musicResult.name}</div>
  <div> Author : ${musicResult.author}</div>
  <div>Category : ${musicResult.category}</div>
  <div>Link : <iframe width="200px" height="auto" title="the song" src="${musicResult.link}" allowfullscreen> </iframe> </div>
</fieldset>

</body>
</html>
