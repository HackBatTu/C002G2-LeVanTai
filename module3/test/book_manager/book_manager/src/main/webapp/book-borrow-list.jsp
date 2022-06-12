<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../style/bootstrap/normalize.css">
    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-warning p-2">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link text-black" href="/book">Kho sách</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-black" href="/book?action=return">Sách đã mượn</a>
                </li>
            </ul>
            <form class="d-flex" method="get" action="">
                <input type="text" value="search" name="action" hidden>
                <div class="col-form-label">
                    <label for="startDate" class="form-label">Ngày bắt đầu trả</label>
                    <input id="startDate" class="form-control me-2" type="date" placeholder="Book Name" name="startDate"
                           value="${startDate}">
                </div>
                <div class="col-form-label">
                    <label for="endDate" class="form-label">Ngày kết thúc trả</label>
                    <input id="endDate" class="form-control me-2" type="date" placeholder="Book Name" name="endDate"
                           value="${endDate}">
                </div>
                <div class="col-form-label">
                    <label for="bookName" class="form-label">Tên sách</label>
                    <input id="bookName" class="form-control me-2" type="text" placeholder="Book Name" name="searchBookName"
                           value="${searchBookName}">
                </div>
                <div class="col-form-label">
                    <label for="studentName" class="form-label">Tên học sinh</label>
                    <input id="studentName" class="form-control me-2" type="text" placeholder="Student Name" name="searchStudentName"
                           value="${searchStudentName}">
                </div>
                <div class="col-form-label">
                    <label for="button" class="form-label">Action</label>
                    <button id="button" class="btn btn-primary form-control" type="submit">Search</button>
                </div>

            </form>
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding: 50px">
    <h2 class="" style="float: left">Book Management</h2>
    <div class="table-scrollable col-12 border-dark">
        <table id="tableCustomer" class="table table-light table-hover table-warning">
            <thead>
            <tr class="table-danger">
                <th class="table-warning">Mã mượn sách</th>
                <th class="table-warning">Tên sách</th>
                <th class="table-warning">Tác giả</th>
                <th class="table-warning">Tên học sinh</th>
                <th class="table-warning">Lớp</th>
                <th class="table-warning">Ngày mượn</th>
                <th class="table-warning">Ngày trả</th>
                <th class="table-warning">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listBookCard}" var="i">
            <tr>
                <td class="table-warning">${i.bookCardId}</td>
                <c:forEach items="${listBook}" var="b">
                    <c:if test="${b.bookId == i.bookId}">
                        <td class="table-warning">${b.bookName}</td>
                    </c:if>
                </c:forEach>
                <c:forEach items="${listBook}" var="b">
                    <c:if test="${b.bookId == i.bookId}">
                        <c:forEach items="${listAuthor}" var="o">
                            <c:if test="${o.authorId == b.authorId}">
                                <td class="table-warning">${o.authorName}</td>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
                <c:forEach items="${listStudent}" var="o">
                    <c:if test="${i.studentId == o.studentId}">
                        <td class="table-warning">${o.studentName}</td>
                    </c:if>
                </c:forEach>
                <c:forEach items="${listStudent}" var="o">
                    <c:if test="${i.studentId == o.studentId}">
                        <c:forEach items="${listClass}" var="c">
                            <c:if test="${c.classId == o.classId}">
                                <td class="table-warning">${c.className}</td>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
                <td class="table-warning">${i.dayBorrow}</td>
                <td class="table-warning">${i.dayReturn}</td>
                <td class="table-warning">
                    <a href="" class="btn btn-warning hover-zoom"
                       data-bs-toggle="modal" data-bs-target="#staticBackdrop${i.bookCardId}">
                        Trả Sách
                    </a>
                </td>

                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop${i.bookCardId}" data-bs-backdrop="static"
                     data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title text-danger" id="staticBackdropLabel">Thông báo!</h5>
                            </div>
                            <div class="modal-body">
                                <c:forEach items="${listStudent}" var="o">
                                    <c:forEach items="${listBook}" var="b">
                                        <c:if test="${i.studentId == o.studentId}">
                                            <c:if test="${b.bookId == i.bookId}">
                                                <h5 class="text-center">Học sinh <strong class="text-warning">${o.studentName}</strong> thực hiện trả sách <strong class="text-warning">${b.bookName}</strong></h5>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </div>
                            <div class="modal-footer">
                                <a href="book?action=acceptReturn&bookId=${i.bookId}&bookCardId=${i.bookCardId}" class="btn btn-success" style="background-color: deeppink !important;">Trả sách</a>
                                <button type="button" class="btn btn-secondary text-white " data-bs-dismiss="modal"
                                        style="background-color: grey !important;">Hủy
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="web-service/footer.jsp"/>
</body>
<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
