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
        <form method="post">

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example1">Mã mượn sách</label>
                <input type="text" id="form1Example1" class="form-control" name="bookCardId" value="${bookCard.bookCardId}"/>
                <div class="text-black text-center bg-warning">${errMap.errBookCardId}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example3">Tên sách</label>
                <input type="text" id="form1Example3" class="form-control" name="bookName"
                       value="${book.bookName}" readonly/>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example10">Tên học sinh</label>
                <select class="form-select" aria-label="Default select example" id="form1Example10" name="studentId">
                    <option selected disabled>Chon học sinh</option>
                    <c:forEach items="${listStudent}" var="i">
                        <c:choose>
                            <c:when test="${bookCard.studentId == i.studentId}">
                                <option value="${i.studentId}" selected>${i.studentName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.studentId}">${i.studentName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errStudentId}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example5">Ngày mượn</label>
                <input type="text" id="form1Example5" class="form-control" name="dayBorrow"
                       value="${dayBorrow}" readonly/>
                <div class="text-black text-center bg-warning">${errMap.errDayBorrow}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example6">Ngày trả</label>
                <input type="date" id="form1Example6" class="form-control" name="dayReturn"
                       value="${bookCard.dayReturn}"/>
                <div class="text-black text-center bg-warning">${errMap.errDayReturn}</div>
            </div>
            <button type="button" class="btn btn-warning hover-zoom text-white"
                    data-bs-toggle="modal" data-bs-target="#staticBackdropMuon" style="background-color: deeppink !important;">
                Mượn Sách
            </button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdropMuon" data-bs-backdrop="static"
                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabelMuon"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-danger" id="staticBackdropLabelMuon">Warning!</h5>
                        </div>
                        <div class="modal-body">
                            <h5 class="text-center"> Xác nhận mượn sách <strong class="text-warning">${book.bookName}</strong> ?</h5>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success text-white" style="background-color: deeppink !important;">Yes</button>
                            <button type="button" class="btn btn-secondary text-white " data-bs-dismiss="modal"
                                    style="background-color: grey !important;">No
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <button type="button" class="btn btn-warning hover-zoom text-white"
               data-bs-toggle="modal" data-bs-target="#staticBackdropHuy" style="background-color: grey !important;">
                Hủy
            </button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdropHuy" data-bs-backdrop="static"
                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-danger" id="staticBackdropLabel">Warning!</h5>
                        </div>
                        <div class="modal-body">
                            <h5 class="text-center"> Bạn có muốn trở lại trang chủ không?.</h5>
                        </div>
                        <div class="modal-footer">
                            <a href="book" class="btn btn-success text-white" style="background-color: deeppink !important;">Yes</a>
                            <button type="button" class="btn btn-secondary text-white " data-bs-dismiss="modal"
                                    style="background-color: grey !important;">No
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
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
