<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Customer Management Application</title>
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
            font-size: 12px;
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
                        <a class="nav-link text-white active" href="../index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/customer">Back</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="col-lg-12 text-center">
        <h1>Customer Use Service</h1>
    </div>
</div>
<div class="col-12 row">
    <nav class="navbar navbar-dark bg-warning">
        <div class="container-fluid">
            <form method="get" action="/customer" class="d-flex">
                <input type="hidden" name="action" value="search">
                <input class="form-control me-2" type="search" placeholder="Search By Name" name="name" aria-label="Search" width="100px" value="${nameSearch}">
                <input type="submit" name="name" value="search">
            </form>
        </div>
    </nav>
</div>

<div class="col-lg-12 row w-100">
    <caption><h5>List of customer using service : </h5></caption>
    <table id="myTable" class="table table-dark table-hover" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Attach Service Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${listCustomerService}">
            <tr>
                <td>${s.customerId}</td>
                <td>${s.customerName}</td>
                <td>
                    <c:if test="${s.customerGender==0}">FeMale</c:if>
                    <c:if test="${s.customerGender==1}">Male</c:if>
                    <c:if test="${s.customerGender==null}">Other</c:if>
                </td>
                <td>${s.customerPhone}</td>
                <td>${s.customerEmail}</td>
                <td>${s.attachServiceName}</td>
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
            "pageLength": 5
        });
    } );
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>