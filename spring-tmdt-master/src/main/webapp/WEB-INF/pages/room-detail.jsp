<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>

<head>
    <%@include file="components/header.jsp" %>
    <style>
        body {
            font-family: Arial;
            margin: 0;
        }

        * {
            box-sizing: border-box;
        }

        img {
            vertical-align: middle;
        }

        /* Position the image container (needed to position the left and right arrows) */
        .container {
            position: relative;
        }

        /* Hide the images by default */
        .mySlides {
            display: none;
            margin-left: -15px;
            margin-right: -15px;
        }

        /* Add a pointer when hovering over the thumbnail images */
        .cursor {
            cursor: pointer;
        }

        /* Next & previous buttons */
        .prev,
        .next {
            cursor: pointer;
            position: absolute;
            top: 40%;
            width: auto;
            padding: 16px;
            margin-top: -50px;
            color: white;
            font-weight: bold;
            font-size: 20px;
            border-radius: 0 3px 3px 0;
            user-select: none;
            -webkit-user-select: none;
        }

        /* Position the "next button" to the right */
        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }

        /* On hover, add a black background color with a little bit see-through */
        .prev:hover,
        .next:hover {
            background-color: rgba(0, 0, 0, 0.8);
        }

        /* Number text (1/3 etc) */
        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }

        /* Container for image text */
        .caption-container {
            text-align: center;
            background-color: #222;
            padding: 2px 16px;
            color: white;
            margin-left: -15px;
            margin-right: -15px;
        }

        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Six columns side by side */
        .column {
            float: left;
            width: 16.66%;
        }

        /* Add a transparency effect for thumnbail images */
        .demo {
            opacity: 0.6;
        }

        .active,
        .demo:hover {
            opacity: 1;
        }
    </style>
</head>

<body>
<%@include file="components/navbar.jsp" %>
<div class="colorlib-wrap" style="padding-top: 0">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
            <li class="breadcrumb-item"><a href="#">Tìm kiếm</a></li>
            <li class="breadcrumb-item"><a href="#">Homestay</a></li>
            <li class="breadcrumb-item active" aria-current="page">Thông Tin Chi Tiết</li>
        </ol>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-12">
                        <div class="wrap-division">
                            <h2>
                                ${room.room_name}
                            </h2>
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h1 class="panel-title">THÔNG TIN CHI TIẾT</h1>
                                </div>
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-justified">
                                        <li class="active"><a data-toggle="pill" href="#home">Ảnh căn hộ</a></li>
                                        <li><a data-toggle="pill" href="#menu1">Thông tin phòng</a></li>
                                        <li><a data-toggle="pill" href="#menu2">Đánh giá</a></li>
                                        <li><a data-toggle="pill" href="#menu3">Bản đồ</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div id="home" class="tab-pane fade in active">
                                            <h2 style="text-align:center">Ảnh căn hộ</h2>

                                            <div class="container" style="width: 100%">
                                                <div class="mySlides">
                                                    <div class="numbertext">1 / 6</div>
                                                    <img src="${pageContext.servletContext.contextPath}/resources/${room.room_image}"
                                                         style="width:100%">
                                                </div>

                                                <%--<div class="mySlides">--%>
                                                <%--<div class="numbertext">2 / 6</div>--%>
                                                <%--<img src="https://www.w3schools.com/howto/img_5terre_wide.jpg"--%>
                                                <%--style="width:100%">--%>
                                                <%--</div>--%>

                                                <a class="prev" onclick="plusSlides(-1)">❮</a>
                                                <a class="next" onclick="plusSlides(1)">❯</a>

                                                <div class="caption-container">
                                                    <p id="caption"></p>
                                                </div>

                                                <div class="row">
                                                    <div class="column">
                                                        <img class="demo cursor"
                                                             src="${pageContext.servletContext.contextPath}/resources/${room.room_image}"
                                                             style="width:100%" onclick="currentSlide(1)"
                                                             alt="Phòng khách">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="menu1" class="tab-pane fade">
                                            <div class="alert alert-success">
                                                ${room.room_information}
                                            </div>
                                        </div>
                                        <div id="menu2" class="tab-pane fade">
                                            <div class="alert alert-success">
                                                <div class="fb-comments"
                                                     data-href="http://ngohongthai.herokuapp.com/${room.room_id}"
                                                     data-numposts="5"></div>
                                            </div>
                                        </div>
                                        <div id="menu3" class="tab-pane fade">
                                            <div class="alert alert-success">
                                                <strong>Success!</strong> You should <a href="#" class="alert-link">read
                                                this message</a>.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- SIDEBAR-->
            <div class="col-md-3">
                <div class="sidebar-wrap">
                    <div class="side search-wrap animate-box">
                        <h3 class="sidebar-heading">Tìm căn hộ cho bạn</h3>
                        <form method="get" action="${pageContext.servletContext.contextPath}/booking" class="colorlib-form">
                            <div class="row">
                                <input type="hidden" name="room_id" value="${room.room_id}">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Ngày nhận:</label>
                                        <div class="form-field">
                                            <i class="icon icon-calendar2"></i>
                                            <input type="text" name="c_in" value="${sessionScope.check_in}" id="date"
                                                   class="form-control date"
                                                   autocomplete="off"
                                                   placeholder="Ngày nhận">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Ngày trả: </label>
                                        <div class="form-field">
                                            <i class="icon icon-calendar2"></i>
                                            <input type="text"
                                                   autocomplete="off"
                                                   name="c_out" value="${sessionScope.check_out}" id="date" class="form-control date"
                                                   placeholder="Ngày trả">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="guests">Số người</label>
                                        <div class="form-field">
                                            <i class="icon icon-arrow-down3"></i>
                                            <select name="guest" id="people" class="form-control">
                                                <c:forEach var="i" begin="1" end="5">
                                                    <option
                                                            <c:if test="${sessionScope.guest == i}">
                                                                selected
                                                            </c:if>
                                                            value="${i}">${i}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <input type="submit" name="submit" id="submit" value="Đặt phòng này"
                                           class="btn btn-primary btn-block">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="components/footer.jsp" %>
<div id="fb-root"></div>
<script>(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s);
    js.id = id;
    js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.2&appId=655939127950285&autoLogAppEvents=1';
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script>
    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("demo");
        var captionText = document.getElementById("caption");
        if (n > slides.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = slides.length
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
        captionText.innerHTML = dots[slideIndex - 1].alt;
    }
</script>

</body>

</html>