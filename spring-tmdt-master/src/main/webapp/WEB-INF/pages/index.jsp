<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/header.jsp" %>
</head>
<body>
<div class="colorlib-loader"></div>

<div id="page">
    <%@include file="components/navbar.jsp"%>
    <%@include file="components/search.jsp"%>
    <div id="colorlib-hotel">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                    <h2>Các homestay được đề xuất</h2>
                    <p>We love to tell our successful far far away, behind the word mountains, far from the countries
                        Vokalia and Consonantia, there live the blind texts.</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 animate-box">
                    <div class="owl-carousel">
                        <c:forEach items="${homestay}" var="homestay">
                            <div class="item">
                                <div class="hotel-entry">
                                    <a href="${pageContext.servletContext.contextPath}/room/search" class="hotel-img"
                                       style="background-image: url(${pageContext.servletContext.contextPath}/resources/${homestay.homestay_image});">
                                        <p class="price"><span>${homestay.location.location_name}</span>
                                        </p>
                                    </a>
                                    <div class="desc">
                                        <p class="star"><span>
                                <c:forEach var="i" begin="1" end="${homestay.homestay_reviews}">
                                    <i class="icon-star-full"></i>
                                </c:forEach>
                                </span> ${homestay.homestay_reviews} Reviews</p>
                                        <h3><a href="#">${homestay.homestay_name}</a></h3>
                                        <span class="place">${homestay.homestay_number_reviews} Lượt đánh giá</span>
                                        <p>${homestay.homestay_description}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                    <h2>Các homestay được lụa chọn nhiều</h2>
                    <p>We love to tell our successful far far away, behind the word mountains, far from the countries
                        Vokalia and Consonantia, there live the blind texts.</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 animate-box">
                    <div class="owl-carousel">
                        <div class="item">
                            <div class="hotel-entry">
                                <a href="hotels.html" class="hotel-img"
                                   style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/hotel-1.jpg);">
                                    <p class="price"><span>$120</span>
                                        <small> /night</small>
                                    </p>
                                </a>
                                <div class="desc">
                                    <p class="star"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i></span> 545 Reviews</p>
                                    <h3><a href="#">Hotel Edison</a></h3>
                                    <span class="place">New York, USA</span>
                                    <p>A small river named Duden flows by their place and supplies it with the necessary
                                        regelialia.</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="hotel-entry">
                                <a href="hotels.html" class="hotel-img"
                                   style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/hotel-2.jpg);">
                                    <p class="price"><span>$120</span>
                                        <small> /night</small>
                                    </p>
                                </a>
                                <div class="desc">
                                    <p class="star"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i></span> 545 Reviews</p>
                                    <h3><a href="#">Hotel Edison</a></h3>
                                    <span class="place">New York, USA</span>
                                    <p>A small river named Duden flows by their place and supplies it with the necessary
                                        regelialia.</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="hotel-entry">
                                <a href="hotels.html" class="hotel-img"
                                   style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/hotel-2.jpg);">
                                    <p class="price"><span>$120</span>
                                        <small> /night</small>
                                    </p>
                                </a>
                                <div class="desc">
                                    <p class="star"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i></span> 545 Reviews</p>
                                    <h3><a href="#">Hotel Edison</a></h3>
                                    <span class="place">New York, USA</span>
                                    <p>A small river named Duden flows by their place and supplies it with the necessary
                                        regelialia.</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="hotel-entry">
                                <a href="hotels.html" class="hotel-img"
                                   style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/hotel-3.jpg);">
                                    <p class="price"><span>$120</span>
                                        <small> /night</small>
                                    </p>
                                </a>
                                <div class="desc">
                                    <p class="star"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i></span> 545 Reviews</p>
                                    <h3><a href="#">Hotel Edison</a></h3>
                                    <span class="place">New York, USA</span>
                                    <p>A small river named Duden flows by their place and supplies it with the necessary
                                        regelialia.</p>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="hotel-entry">
                                <a href="hotels.html" class="hotel-img"
                                   style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/hotel-4.jpg);">
                                    <p class="price"><span>$120</span>
                                        <small> /night</small>
                                    </p>
                                </a>
                                <div class="desc">
                                    <p class="star"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i><i class="icon-star-full"></i><i
                                            class="icon-star-full"></i></span> 545 Reviews</p>
                                    <h3><a href="#">Hotel Edison</a></h3>
                                    <span class="place">New York, USA</span>
                                    <p>A small river named Duden flows by their place and supplies it with the necessary
                                        regelialia.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="colorlib-subscribe"
         style="background-image: url(${pageContext.servletContext.contextPath}/resources/images/img_bg_2.jpg);"
         data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                    <h2>Sign Up for a Newsletter</h2>
                    <p>Sign up for our mailing list to get latest updates and offers.</p>
                    <form class="form-inline qbstp-header-subscribe">
                        <div class="row">
                            <div class="col-md-12 col-md-offset-0">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="email" placeholder="Enter your email">
                                    <button type="submit" class="btn btn-primary">Subscribe</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@include file="components/footer.jsp" %>
</body>
</html>