<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.css">
    <style>
        .bg-pink {
            background-color: black !important;
        }
        body{
            box-sizing: border-box;
            padding: 0px;
            border: 0px;
        }
        html{
            font-size: 12px !important;
        }
    </style>
</head>
<body>
<div class="col-auto row col-12" style="margin: 0 auto;">
    <div class="bg-pink text-white col-5" style="margin: 0 auto !important; padding: 20px;">
        <div class="col-lg-10">*Create Product : </div>


        <form method="post">
            <div class="form-outline mb-2 w-75">
                <label class="form-label" for="form1Example1">Product Name</label>
                <input type="text" id="form1Example1" class="form-control" name="name" value="${name}"/>
                <small>${errors.name}</small>
            </div>

            <div class="form-outline mb-2 w-75">
                <label class="form-label" for="form1Example2">Product price</label>
                <input type="text" id="form1Example2" class="form-control" name="price" value="${price}"/>
                <small>${errors.price}</small>
            </div>

            <div class="form-outline mb-2 w-75">
                <label class="form-label" for="form1Example3">Product Quality</label>
                <input type="text" id="form1Example3" class="form-control" name="quality" value="${quality}"/>
                <small>${errors.quality}</small>

            </div>

            <div class="form-outline mb-2 w-75">
                <label class="form-label" for="form1Example4">Product Color</label>
                <input type="text" id="form1Example4" class="form-control" name="color" value="${color}"/>
                <small>${errors.color}</small>

            </div>
            <div class="form-outline mb-2 w-75">
                <label class="form-label" for="form1Example6">Category</label>
                <select class="form-select" aria-label="Default select example" id="form1Example6" name="category">
                    <option class="selected disabled">Choice Category</option>
                    <c:forEach items="${categoryList}" var="i">
                        <option value="${i.id}">${i.name}</option>
                    </c:forEach>
                </select>
                <small>${errors.category}</small>
            </div>


            <button type="submit" class="btn btn-warning btn-block w-25">Submit</button>
            <button type="submit" class="btn btn-warning btn-block w-25"><a class="text-white" href="/product">Back Product</a>
            </button>

        </form>

</body>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>

