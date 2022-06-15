<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/6/2022
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Contract Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.css">
    <style>
        body{
            box-sizing: border-box;
            padding: 0px;
            border: 0px;
        }
        table{
            font-size: 10px;
        }
        html{
            font-size: 12px !important;
        }
    </style>
</head>
<body>

<div>
    <nav class="navbar navbar-expand-sm navbar-dark bg-warning p-2">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://i.pinimg.com/736x/29/88/5b/29885bbba1f52e88bfdeb441e46fb454.jpg" alt="Logo" style="width:40px;" class="rounded-pill">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link text-white active" href="../home.jsp"><h4>Home</h4></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="col-lg-12 text-center">
        <h1>Mặt Bằng Management</h1>
    </div>
</div>

<div class="col-12 row">
    <nav class="navbar navbar-dark bg-warning">
        <div class="container-fluid justify-content-between">
            <form>
                <button class="btn btn-sm btn-outline-secondary bg-primary" type="button"><a href="/mat_bang?action=create" class="text-white"><h5>Add New Mặt Bằng</h5></a></button>
                <button class="btn btn-sm btn-outline-secondary bg-primary" type="button"><a href="/mat_bang" class="text-white"><h5>Show List Mặt Bằng</h5></a></button>
            </form>
            <form method="get" action="/contract" class="d-flex">
                <input type="hidden" name="action" value="search">
                <input class="form-control me-2" type="search" placeholder="Search by id" name="id" aria-label="Search" width="100px" value="${nameSearch}">
                <input type="submit" name="id" value="search">
            </form>
        </div>
    </nav>
</div>

<div class="col-lg-12 container">
    <caption><h4>List of Contract : </h4></caption>
    <table id="myTable" class="table table-dark table-hover" style="width: 100%">
        <thead>
        <tr>
            <th>Mã MB</th>
            <th>Diện Tích(m2)</th>
            <th>Trạng Thái</th>
            <th>Tầng</th>
            <th>Loại Văn Phòng</th>
            <th>Gía Cho Thuê</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${matBangList}">
            <tr>
                <td>${s.id}</td>
                <td>${s.area}</td>
                <td>${s.status.name}</td>
                <td>${s.numberOfFloor}</td>
                <td>${s.loaiVanPhong.name}</td>
                <td><fmt:formatNumber currencyCode="currency" value="${s.prince}"/></td>
                <td>${s.dateCheckIn}</td>
                <td>${s.dateCheckOut}</td>
                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#staticBackdropDelete${s.id}">Delete
                    </button>
                </td>
                <!-- Modal Delete -->
                <div class="modal fade" id="staticBackdropDelete${s.id}" data-bs-backdrop="static"
                     data-bs-keyboard="false" tabindex="-1"
                     aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabelAddNew">Delete</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="alert alert-warning">
                                    Do you want delete Mặt Bằng <strong>${s.id}</strong>
                                </div>
                                <a href="/mat_bang?action=delete&id=${s.id}" class="btn btn-success">Submit</a>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                </button>
                            </div>
                            <div class="modal-footer"></div>
                        </div>
                    </div>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#myTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 7
        });
    } );
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</html>
