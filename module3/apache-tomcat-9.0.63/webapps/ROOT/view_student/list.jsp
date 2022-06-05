<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
           rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.css">
</head>
<body>

<div class="col-lg-12">
    <h1>Student Management</h1>
</div>

<div class="col-lg-12">
    <h3>
        <a href="/student?action=add">Add New Student</a>
    </h3>
</div>

<div class="col-lg-12">
    <form method="get" action="/student">
        <input type="hidden" name="action" value="search">
        <input type="text" placeholder="Enter the Name" name="name">
        <input type="submit" name="name" value="search">
    </form>
</div>

<div class="col-lg-12">
    <caption><h2>List of Student</h2></caption>
    <table id="myTable" class="table table-dark table-hover" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Point</th>
            <th>Gender</th>
            <th>Ranks</th>
            <th>.....</th>
            <th>.....</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${listStudent}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.point}</td>
                <td>
                    <c:if test="${s.gender==0}">FeMale</c:if>
                    <c:if test="${s.gender==1}">Male</c:if>
                    <c:if test="${s.gender==null}">Other</c:if>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${s.point>8}">Xuất sắc</c:when>
                        <c:when test="${s.point>6.5}">Tiên Tiến</c:when>
                        <c:when test="${s.point>5}">TB</c:when>
                        <c:when test="${s.point>0}">Yếu</c:when>
                    </c:choose>
                </td>
                <td>
                    <button type="submit">
                        <a href="/student?action=edit&id=${s.id}">Edit</a>
                    </button>
                </td>
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
                                <h5 class="modal-title" id="staticBackdropLabelAddNew">Delete Student</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="alert alert-warning">
                                    Do you want delete student <strong>${s.name}</strong>
                                </div>
                                <a href="/student?action=delete&id=${s.id}" class="btn btn-success">Submit</a>
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
    <a href="/student?action=sortByName">Sort By Name</a>
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
