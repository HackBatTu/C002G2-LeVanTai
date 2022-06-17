<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/6/2022
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Tờ Khai Chi Tiết</legend>
    <div> Tên : ${result.name}</div>
    <div> Ngày Sinh: ${result.birth}</div>
    <div> Gioi Tính : ${result.gender}</div>
    <div> Quốc Gia : ${result.country}</div>
    <div> Căn Cước : ${result.idCard}</div>
    <div> Thông Tin Đi lại : ${result.vehicleName}</div>
    <div> Số Hiệu : ${result.vehicleId}</div>
    <div> Số Ghế : ${result.vehicleInformation}</div>
    <div> Ngày Bắt Đầu : ${result.dateStart}</div>
    <div> Ngày Kết Thúc : ${result.dateEnd}</div>
    <div> Thông tin đi lại trong 14 ngày : ${result.citiesLast14days}</div>
</fieldset>
</body>
</html>
