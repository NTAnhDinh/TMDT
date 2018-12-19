<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="colorlib-nav" role="navigation">
    <div class="top-menu">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-2">
                    <div id="colorlib-logo"><a href="${pageContext.servletContext.contextPath}/">HOME</a></div>
                </div>
                <div class="col-xs-10 text-right menu-1">
                    <ul>
                        <li class="active"><a href="${pageContext.servletContext.contextPath}/">Home</a></li>
                        <li><a href="hotels.html">Homestay</a></li>
                        <li><a href="blog.html">Blog</a></li>
                        <li><a href="about.html">About</a></li>
                        <c:choose>
                            <c:when test="${sessionScope.user != null}">
                                <li><a href="${pageContext.servletContext.contextPath}/booking/history">Chào ${sessionScope.user.user_fullname}</a> </li>
                                <li><a href="${pageContext.servletContext.contextPath}/logout">Đăng xuất</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${pageContext.servletContext.contextPath}/login">Đăng nhập</a></li>
                                <li><a href="${pageContext.servletContext.contextPath}/register">Đăng ký</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>
<aside id="colorlib-hero">
    <div class="flexslider">
        <ul class="slides">
            <li style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/img_bg_2.jpg);">
                <div class="overlay"></div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12 slider-text">
                            <div class="slider-text-inner text-center">
                                <h2>6000 ngàn căn hộ cho bạn lựa chọn</h2>
                                <h1>6000 NGÀN CĂN HỘ CHO BẠN LỰA CHỌN</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            <li style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/img_bg_5.jpg);">
                <div class="overlay"></div>
                <div class="container-fluids">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12 slider-text">
                            <div class="slider-text-inner text-center">
                                <h2>Hãy chọn những căn nhà phù hợp</h2>
                                <h1>NHÀ CỦA BẠN</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            <li style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/img_bg_4.jpg);">
                <div class="overlay"></div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12 slider-text">
                            <div class="slider-text-inner text-center">
                                <h2>Bạn đang tìm những căn hộ view bản cho gia đình</h2>
                                <h1>NHỮNG CĂN HỘ VIEW BIỂN</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</aside>