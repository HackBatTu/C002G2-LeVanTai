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
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding: 50px">
    <h2 class="" style="float: left">Book Management</h2>
    <div class="table-scrollable col-12 border-dark">
        <table id="tableCustomer" class="table table-light table-hover table-warning">
            <thead>
            <tr class="table-danger">
                <th class="table-warning">Mã sách</th>
                <th class="table-warning">Tên sách</th>
                <th class="table-warning">Tác giả</th>
                <th class="table-warning">Số lượng</th>
                <th class="table-warning">Mô tả</th>
                <th class="table-warning">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listBook}" var="i">
            <tr>
                <td class="table-warning">${i.bookId}</td>
                <td class="table-warning">${i.bookName}</td>
                <c:forEach items="${listAuthor}" var="o">
                <c:if test="${o.authorId == i.authorId}">
                <td class="table-warning">${o.authorName}</td>
                </c:if>
                </c:forEach>
                <td class="table-warning">${i.amount}</td>
                <td class="table-warning">${i.description}</td>
                <c:if test="${i.amount == 0}">
                <td class="table-warning">
                    <a href="" class="btn btn-warning hover-zoom"
                       data-bs-toggle="modal" data-bs-target="#staticBackdrop${i.bookId}">
                        Mượn sách
                    </a>
                </td>

                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop${i.bookId}" data-bs-backdrop="static"
                     data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title text-danger" id="staticBackdropLabel">Cảnh báo!</h5>
                            </div>
                            <div class="modal-body">
                                <h5 class="text-center">Sách <strong class="text-warning">${i.bookName}</strong> đã tạm thời cho mượn hết, vui
                                    lòng chọn sách khác.</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary text-white " data-bs-dismiss="modal"
                                        style="background-color: grey !important;">Ok
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                </c:if>
                <c:if test="${i.amount > 0}">
                <td class="table-warning"><a href="book?action=borrow&bookId=${i.bookId}" class="btn btn-warning">Mượn Sách</a></td>
                </c:if>
                </c:forEach>
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
            "pageLength": 8
        });
    });
</script>
</html>
