<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2022
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Furama Management</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <style>
    body{
      box-sizing: border-box;
      margin: 0px;
      padding: 0px;
    }
    html{
      font-size: 12px !important;
    }
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="col-12 row">
    <div class="col-1 bg-warning"><img src="https://i.pinimg.com/736x/29/88/5b/29885bbba1f52e88bfdeb441e46fb454.jpg" style="width:45px;" class="rounded-pill"></div>
    <div class="col-11 bg-warning">
      <div class="col-lg-12 row">
        <div class="col-lg-10 text-center"><h2>Furama Management</h2></div>
        <div class="col-lg-2">
          <p>Welcome to<strong>Furama Resort!!!</strong></p>
        </div>
      </div>
    </div>
  </div>

  <div class="col-12 row ">
    <nav class="navbar navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/index.jsp">Home</a>
        <a class="navbar-brand" href="/employee">Employee</a>
        <a class="navbar-brand" href="/customer">Customer</a>
        <a class="navbar-brand" href="/service">Service</a>
        <a class="navbar-brand" href="/contract">Contract</a>
        <a class="navbar-brand" href="/details_contract">Contract_Details</a>
        <form class="d-flex navbar-brand">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" width="100px">
          <button class="btn btn-outline-success bg-dark" type="submit">Search</button>
        </form>
      </div>
    </nav>
  </div>

  <div class="col-12 row" style="height: 505px">
    <div class="col-3">
      <div class="card w-100" style="height: 50%">
        <img src="https://cf.bstatic.com/xdata/images/hotel/square200/352170974.webp?k=653aede4611125b3739b165a5b57757f056ab7bddd8e086c320ab6e10f74c8aa&o=&s=1" class="card-img-top" alt="..." height="150px">
        <div class="card-body">
          <h5 class="card-title">Furama</h5>
          <p class="card-text">Khu Nghỉ Dưỡng Furama</p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>
      <div class="card w-100" style="height: 50%">
        <img src="https://cf.bstatic.com/xdata/images/hotel/square200/210973040.webp?k=8fd9ab1cad9a8ad4a4991b0edb6155f57747d7e8925f4a33baac1aec0db87003&o=&s=1" class="card-img-top" alt="..." height="150px">
        <div class="card-body">
          <h5 class="card-title">Furama</h5>
          <p class="card-text">Tiện nghi vươn tầm</p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>
    </div>

    <div class="col-9">
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://mgvs.vn/wp-content/uploads/2019/12/anh-bia-vinpearl-land-1024x536.jpg" class="d-block" width="100%" height="505px" alt="">
            <div class="carousel-caption d-none d-md-block text-dark">
              <h3>Mấy Con Gà Này</h3>
              <p>Some representative placeholder content for the first slide.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://reviewvilla.vn/wp-content/uploads/2021/09/vinpearl-nha-trang-11-1-1024x576.jpg" class="d-block" width="100%" height="505px" alt="">
            <div class="carousel-caption d-none d-md-block text-dark">
              <h3>Mấy Con Gà Này</h3>
              <p>Some representative placeholder content for the second slide.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="https://cuongtruyen.com/wp-content/uploads/2019/09/luffy-funny-face-1024x576.jpg" class="d-block" width="100%" height="505px" alt="">
            <div class="carousel-caption d-none d-md-block text-dark">
              <h3>Mấy Con Gà Này</h3>
              <p>Some representative placeholder content for the third slide.</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  </div>

  <footer class="container-fluid text-center bg-dark p-2 text-light" style="height: 24px">
    <p class="text-light">Furama Resort - &copy; Copyright by Háck Bất Tử 2022</p>
  </footer>

</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
