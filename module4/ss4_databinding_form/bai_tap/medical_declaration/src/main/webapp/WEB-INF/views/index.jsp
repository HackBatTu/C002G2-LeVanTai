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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<form:form action="/create" modelAttribute="healthReport" method="post">
    <div class="container">
        <div class="text-center">
            <div><h3> Tờ Khai Y tế </h3></div>
            <div><b>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT DỂ
                PHÒNG CHỐNG BỆNH TRUYỀN NHIỄM</b></div>
            <div><h5 style="color: red">Khuyến cáo : khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử
                lí hình sự</h5></div>
        </div>

        <div>
            <b>Họ và tên (ghi chữ IN HOA)<span style="color: red">(*)</span>:</b>
            <form:input path="name" class="form-control" required="required"/>
        </div>
        <div>
            <table style="width: 100%; padding: 20px">
                <tr>
                    <th>Năm sinh<span style="color: red">(*)</span></th>
                    <th>Giới tính<span style="color: red">(*)</span></th>
                    <th>Quốc tịch<span style="color: red">(*)</span></th>
                </tr>
                <tr>
                    <td>
                        <form:input type="date" path="birth" class="form-control" required="required"/>
                    </td>
                    <td>
                        <form:select path="gender" class="form-control" required="required">
                            <form:option value="Nam">Nam</form:option>
                            <form:option value="Nữ">Nữ</form:option>
                            <form:option value="Khác">Khác</form:option>
                        </form:select>
                    </td>
                    <td>
                        <form:select path="country" class="form-control" required="required">
                            <form:option value="Việt Nam">Việt Nam</form:option>
                            <form:option value="Lào">Lào</form:option>
                            <form:option value="Đông Lào">Đông Lào</form:option>
                        </form:select>
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <b>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span style="color: red">(*)</span></b>
            <div>
                <form:input path="idCard" class="form-control" required="required"/>
            </div>
        </div>

        <div>
            <b>Thông tin đi lại<span style="color: red">(*)</span></b>
            <div>
                <form:radiobutton path="vehicleName" value="Tàu bay" required="required"/>Tàu bay
                <form:radiobutton path="vehicleName" value="Tàu thuyền" required="required"/>Tàu thuyền
                <form:radiobutton path="vehicleName" value="Ô tô" required="required"/>Ô tô
                <form:radiobutton path="vehicleName" value="khác" required="required"/>Khác(ghi rõ)
            </div>
        </div>

        <div class="col-12 row">
            <div class="col-6">
                <b>Số hiệu phương tiện:</b>
                <div>
                    <form:input path="vehicleId" class="form-control"/>
                </div>
            </div>
            <div class="col-6">
                <b>Số ghế:</b>
                <div>
                    <form:input path="vehicleInformation" class="form-control"/>
                </div>
            </div>
        </div>
        <div>
            <table style="width: 100%">
                <tr>
                    <th>Ngày khởi hành<span style="color: red">(*)</span></th>
                    <th>Ngày kết thúc<span style="color: red">(*)</span></th>
                </tr>
                <tr>
                    <td><form:input type="date" path="dateStart" class="form-control" required="required"/></td>
                    <td><form:input type="date" path="dateEnd" class="form-control" required="required"/></td>
                </tr>
            </table>
        </div>
        <div>
            <b>Trong 14 ngày qua anh/chị có đi đến tỉnh/thành phố nào?<span style="color: red">(*)</span></b>
            <div>
                <form:input path="citiesLast14days" class="form-control" required="required"/>
            </div>
        </div>
        <div class="text-center">
            <button class="btn btn-primary">Gửi tờ khai</button>
        </div>

    </div>
</form:form>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
