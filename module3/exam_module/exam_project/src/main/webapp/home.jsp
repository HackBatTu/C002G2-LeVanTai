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
    <div class="col-12 row bg-white position-sticky">
        <div class="col-1 "><img src="https://i.pinimg.com/736x/29/88/5b/29885bbba1f52e88bfdeb441e46fb454.jpg" style="width:45px;" class="rounded-pill"></div>
        <div class="col-11 ">
            <div class="col-lg-12 row">
                <div class="col-lg-10 text-center"><h2>Exam Management</h2></div>
                <div class="col-lg-2">
                    <p>Welcome to ...<br><strong>...CodeGym ĐN City!!!</strong></p>
                </div>
            </div>
        </div>
    </div>

    <div class="col-12 row ">
        <nav class="navbar navbar-dark bg-primary">
            <div class="container-fluid d-flex justify-content-between">
                <form>
                <a class="navbar-brand" href="/home.jsp">Home</a>
                <a class="navbar-brand" href="/mat_bang">Mặt Bằng</a>
                </form>
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
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTE8JA8EYB9favOVcSpmbfo_p-EKAaLSuyQ3hheiro8Tu3GDg7QXNxydoYmmJ-1d4YrCYc&usqp=CAU" class="card-img-top" alt="..." height="150px">

                <div class="card-body">
                    <h5 class="card-title">CodeGym Đà Nẵng</h5>
                    <p class="card-text">ươm mầm những hạt thóc</p>
                    <a href="#" class="btn btn-primary"> Go somewhere</a>
                </div>
            </div>
            <div class="card w-100" style="height: 50%">
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAA5FBMVEUtMYD///8rL39HSow9QIgOFncYHnnc3OcoLH4fJHu3t84bIHr5+fslKn0qLn8ADnUACHQJEnYTGnjp6fBsbZ/xWi/AwNS5us8AAHAAAHNSVJFcXpasrcbNzd3ExdaXmLimpsLy8vbg3+mCg6xMTo56fKfW1uNzdKPq6vGJirBnaJxcXZaRkrUAAGmdnbw3OoQ/Qoj/wK/6XCcDLYXwUBxuWYqLQmZJNXrYVEGPmr6gPlX84tvzaUT2moXwRgDGT0tFWZr/2MxyPW+wSlbeUTdVN3f0h23hqKa5TFJgOXS2jp58OGZUNlj1AAALZklEQVR4nO2diXbjthWGCcgkBZEARUgjghIlkdRC7VLsabO0TZo2bZPm/d+nALhKomM77XQGPvjPeMa42O4HgCAWnjPGuPPOZTwQ+L5lPBjvXZpQfWlC9aUJ1ZcmVF+aUH1pQvWlCdWXJlRfmlB9aUL1pQnVlyZUX5pQfWlC9aUJ1ZcmVF+aUH1pQvWlCdWXJlRfmlB9aUL1pQnVlyZUX5pQfWlC9aUJ1ZcmVF+aUH1pQvWlCdWXJlRfmlB9aUL1pQnVlyZUX5pQfWlC9aUJ1ZcmVF+aUH21E0JEzUqwMlq10cJ1amQ2RZ1usyhiNYoySR2BG6WhyurwkNNI1HBAlIPLQmU2p4iBTu4TNFrUSojwaW2XSh/yjNhfzCqjPcq80lt0Su2G1tHYr4tyOr26KDu9lJmIt6pLS7clohOkdtqrEHHGi07P0gFrxqMWOC90JLMFSMYgoyeDI9SG2EZoZaCpsewTvEyurCA1Cm/9DbjRjJZVOYvrmHHRv/g8aJqjkkmWlZpVU8/rTJ74dWTxHvOqQmPRMnR3V8wLhOgaMK+AGLcYICmGjz+4ixr4eRQ530QUhBC7V+aacPA8ocgSWAbpB3VTWgYM4yoo+F9BCK02r6zRHQaYo+cIS5fR6ca+zwnpqDX5awiR0ahuZmFs18FXEqKtSJxEvUKBfAx82ejrwhaloPZEetVILyvzZJTTuy6rVzSiKdMEVZZhOW+9SMiKIZlEkpBN3EbwlYS5Vw51SskBh4VxygqTxcTz4nq1V3YZ5YSy3zqkLgtVZRUekKUwx2FVRTUxv0QYFYNiSo+yjeZlkLmvJ7SCug8qwe7VYDLo9Iaw3aucMLytojsW5jm6tb9MWDy+cwb7jUHOg96bCf1r439F2P/fEUq5e2oYNaEMvitCG4tBXRHaCBvvizAO5cRQEhbBz0vIcKV7wm4VB6uyqgzmPeGwqKgg3BXBz0s4GVbCN4Sk+4cqTqy5TPl2O+wKUyaXS0bdS65RdrwkdEkZ/LyEDeXmkhA+/fHjV1WcKB3F4E6JVzMEtKxGEs6qWr9MQuvrbx4bhGLB3bI4LJ/XctV2RVgFv0jCb797/PDhhvBuUczXUV6D4csnzJc6kvBPf+aAd4SGs7ebGdyTB798QoYq5QtvQfiX7znfh8cfDGHu14R8H2rsspUwBMPh0qteKV80YV1M/g/+64+PHwXfh789CROkDUKxt0IPwhCbuHEm8CUT3r7xn77+5qPswL8/5QQ3hLyTL5LwakOrDiF8EjMMfwJ/+sdTaXpXhE+//CRnmI9ffVs9Yp+FkF0bIZGEVQnmbxAebgkbuydCfpYd+P0/XXCoCf3/K2Hu1b5/dZoIkTCmrDD5fgKqxUaxAy6Ts5lIemnsgDtedQb564dHOcP8KPypsnid6xHyiQlRfpJ1c5ookUBSGvMzDVoTulX6/BileYpRl/Wv/BXxs+wzUB9CyuCqPoL9tITQvD4Hywfc3ZlS7VLbSVTcfhL1FZ9DH3/65cm6XQmI1vPr085PS2jgSQsh9NNbl6bFcqqFMC1PEx/uCB+/E69A6+6MFUwap+ifmNBA++SOkM93NyeAvXI5dX8i3KtuApztNeH333wtXxEETa+zJPvmfrh7+2AajRPhdsLr4AuEBvaG9QFgUBiheZlXxt7hXJ1r4yzoNRRtDVqPN3Q+NIr6969P5VWDuTw18mQ+bjoAiUi9u7KhU9A0OTEP1o8uug6+RMi9dhyrUN2QBFVGC13dsTTlXN8eNDNd5WpGOPjmxgEK642/SKS7ClrPB18kfEfShOpLE6ovTai+NGGb2m7Lv1z9FiGkLXcn0AztYeviQeZo/eCjTdh8rhD6jF2q+2y25/QbhBAN7j9ugMYmylrA80hsP7wSEU/c9naCRkra7Lm6O3f3RsQ2QigIEESrzlxUhsU9NBL3RgQZeGucHAgdIj5jMTAtulmkgGK3JI4moEWd0urw37ryohxRKjcp+WUKir0YiaLlUpXkKWUpeLzF4qMjHsur7OapeQGI8JzmqX+ihNcOc3terYFRkeh1hBBGyEAR2fH1vfBiEfSi4LDbYjI+IfOUTpf4EnQIjhDK7HRLpb+9YM5HKNpyQmjMBoGo8swz8q0J3gd8Yc0zrseilTryIxhyDs4EL/i24tI1yFKmRGLPYuFVhoJ9F0XOaoW7E9FkKHqA6LDvxKbYqKwuwYUIH3l13ENIDDyMLJ4IvvabKEiAx/dbZJ4eDlts4N0hGByy+czCww2LB50FMMegZ1EQ7sF+CTIsdmeLxXptGt4m8fmOOLqMppSTzrfgMDecnpthNN/wjNyr7iQRh1bo4B6QNRqtYkAgvPCU24MBVtt0GgYRBVPTA17Uc/DCFlfYoEOovZokLI0O892e7xwdcU5C19GqByxIp+6ScI/fSNidjzx5gYzpYtqnpxEnHByTCQrTbLxOTArYKKbOfOQIFwhioIM79nSHz4DhvjiOhNxGEfQ3i8AyBzvUXy9wSUjXizW1RnPKbG6EqA8YOicMGYD1YmszOPclIVqs5SV9Trhh6dBCaDdN/IJwZbF0i7xkfkJvI2QW44QB8+TzhLZTC51GobkbHIFjWKPT2I62ITimC4R84S8DDjHTBZ3Hh4gOB6b0yRDkfNCeEzPxPGBARwz6gtB3j67JCX02EIMAUtDnCZm/TwRhcoiY60VR6K1ywgfK1pJwF3pot+4t+oKwv84cp9ejE3tp07cQdoHrugAfgJufGkhCHnKBfeR9Y/XicXrmsMfN8Byf+Mba6YGNYdoHtp5cBqEYWH4iv34ShGgbHJNzyH9zIj4354R4Yh/XO3M0Pc1c8YbJCcFsmnQoJ3RD3gBeLKqcCsJEOJRxwjX3aTWxOynjhNynZEijWT8+HV3af1MfHv2jGKWhgxp9yMIJxzKhE3DC4+DsHgfDh2gkGpkBxIfRloEsA3SVmpxwXPahNYuyNY+6IkTxLBtF4Wgdz1FxN8MJ3eHK7oWCkE13og8ZK/rQ6B/zPhyaDtrZx0236sMoYOk82wzZ73kOiw82C0L5HIIzodPDeBBuI/e43iIzky6AM+wnk707myWrceIZYX75Lgj73LieMj5s+fAuR6mZTmfTAeOjNJ/ji1EaorHLRyl1Q/6s5TPNzXOYYYh3aXiI3Pw5xHR2CsFslvZ+D2HAfHpDyNbbPgPL8cA0k4TNbcZmOaHT7wAWxWH/MGIA+8v8SJgTdpcJow5g00OfuXsx02yOvmcBRhkwR+UXJ0Uf+nykSkKvv3FbCXehT3epaSV80uaEWdgHl2zNzGVyfAMhlIRwDpJkIGf27ZoTTi2cJd4YzJKZx/vBCkDfSgbpLJ/OBwOQhcmuSy6AzcEMLFBOiFE8coifTDpgtpn64m0hnq6TTQmfTmenJuED8KEFcBBZwEMnEPYCB2/T8m2RLsTbwk3caLIx6SifS5MBOIWj2OHvCgu8+n3IO5H/RSDpXvI1GCT8lcV/+C8Qd1cT0yB8UYH5j5lNTNlyfFoRC8au+AOdzuqh8JynMbCxJPy1ikVGUVpXeIKJMJK62Un+A7uiFiISyCrzFHndIqLbMeSv8u5UpOOvI15DRxT26jVNBYri4npIuCQbSPyLi898ZZgHYJWkUrd5d8tjBnJBXmWUMhNL/ne9LfUWJVZV1vXxvk4fiHSjKkq0yn7adhb8IiEfns8tsd+o1t2C2WZ8RVltjUKeB9Q74HcgTai+NKH60oTqSxOqL02ovjSh+tKE6ksTqi9NqL40ofrShOpLE6ovTai+NKH60oTqSxOqL02ovjSh+tKE6ksTqi9NqL40ofrShOpLE6ovTai+NKH60oTqSxOqL02ovjSh+tKE6ksTqi9NqL40ofrShOpLE6ovTai+NKH60oTqSxOqL02ovjSh8voPVP4VOf2MRkEAAAAASUVORK5CYII=" class="card-img-top" alt="..." height="150px">

                <div class="card-body">
                    <h5 class="card-title">CodeGym Đà Nẵng</h5>
                    <p class="card-text">Lùa gà vươn tầm</p>
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
