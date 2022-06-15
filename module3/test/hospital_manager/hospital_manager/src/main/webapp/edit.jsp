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
                    <a class="nav-link text-black" href="" data-bs-toggle="modal" data-bs-target="#staticBackdropH">Trang chủ</a>
                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdropH" data-bs-backdrop="static"
                         data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title text-danger" id="staticBackdropHome">Warning!</h5>
                                </div>
                                <div class="modal-body">
                                    <h5 class="text-center"> Bạn có muốn trở lại trang chủ không?.</h5>
                                </div>
                                <div class="modal-footer">
                                    <a href="home" class="btn btn-success text-white" style="background-color: deeppink !important;">Yes</a>
                                    <button type="button" class="btn btn-secondary text-white " data-bs-dismiss="modal"
                                            style="background-color: grey !important;">No
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding: 50px">
    <h2 class="" style="float: left">Hospital Management</h2>
    <div class="table-scrollable col-12 border-dark">
        <form method="post">

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example1">Mã bệnh án</label>
                <input type="text" id="form1Example1" class="form-control" name="medicalRecordId" value="${medicalRecord.medicalRecordId}" readonly/>
                <div class="text-black text-center bg-warning">${errMap.errMedicalRecordId}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example3">Mã bệnh nhân</label>
                <input type="text" id="form1Example3" class="form-control" name="patientId"
                       value="${medicalRecord.patientId}" readonly/>
                <div class="text-black text-center bg-warning">${errMap.errPatientId}</div>
            </div>

            <c:forEach items="${listPatients}" var="i">
                <c:if test="${i.patientId == medicalRecord.patientId}">
                    <div class="form-outline mb-4">
                        <label class="form-label" for="form1Example66">Tên bệnh nhân</label>
                        <input type="text" id="form1Example66" class="form-control" name="patientName"
                               value="${i.patientName}"/>
                        <div class="text-black text-center bg-warning">${errMap.errPatientName}</div>
                    </div>
                </c:if>
            </c:forEach>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example5">Ngày nhập viện</label>
                <input type="date" id="form1Example5" class="form-control" name="hospitalizedDay"
                       value="${medicalRecord.hospitalizedDay}"/>
                <div class="text-black text-center bg-warning">${errMap.errHospitalizedDay}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example6">Ngày xuất viện</label>
                <input type="date" id="form1Example6" class="form-control" name="dischargeDay"
                       value="${medicalRecord.dischargeDay}"/>
                <div class="text-black text-center bg-warning">${errMap.errDischargeDay}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example55">Lý do nhập viện</label>
                <input type="text" id="form1Example55" class="form-control" name="hospitalizedReason"
                       value="${medicalRecord.hospitalizedReason}"/>
                <div class="text-black text-center bg-warning">${errMap.errHospitalizedReason}</div>
            </div>
            <button type="button" class="btn btn-warning hover-zoom text-white"
                    data-bs-toggle="modal" data-bs-target="#staticBackdropEdit" style="background-color: deeppink !important;">
                Sửa
            </button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdropEdit" data-bs-backdrop="static"
                 data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabelMuon"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-danger" id="staticBackdropLabelMuon">Warning!</h5>
                        </div>
                        <div class="modal-body">
                            <h5 class="text-center"> Xác nhận sửa thông tin bệnh án <strong class="text-warning">${medicalRecord.medicalRecordId}</strong> ?</h5>
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
                    data-bs-toggle="modal" data-bs-target="#staticBackdropCancel" style="background-color: grey !important;">
                Hủy
            </button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdropCancel" data-bs-backdrop="static"
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
                            <a href="home" class="btn btn-success text-white" style="background-color: deeppink !important;">Yes</a>
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
