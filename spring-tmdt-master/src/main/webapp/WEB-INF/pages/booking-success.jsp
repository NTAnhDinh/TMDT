<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/header.jsp" %>
    <%--<c:if test="${sessionScope.user == null}">--%>
        <%--<c:redirect url="${pageContext.servletContext.contextPath}/"></c:redirect>--%>
    <%--</c:if>--%>
</head>
<body>
<%@include file="components/navbar.jsp" %>
<div class="colorlib-wrap" style="padding-top: 0">
    <div class="row well text-center">
        <ul id="progressbar" class="progressbar">
            <li class="current">Chi tiết đặt phòng</li>
            <li class="active">Yêu cầu đặt phòng</li>
            <li class="danger">Phê duyệt đặt phòng</li>
            <li class="">Xác nhận thanh toán</li>
        </ul>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="row">
                    <div class="wrap-division">
                        <div class="success-box">
                            <div class="icon">
                                        <span>
                                            <i class="ri ri-check-square"></i>
                                        </span>
                            </div>
                            <div class="content">
                                <h3>Bạn đã đặt phòng thành công</h3>
                            </div>
                        </div>

                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">THÔNG TIN THANH TOÁN</h3>
                            </div>
                            <div class="panel-body">
                                <h2>Vui lòng đợi cho đến khi chủ nhà gọi xác nhận thông tin đặt phòng của bạn!!!</h2>
                                <a class="btn btn-danger" href="/">Về trang chủ</a>
                                <a class="btn btn-default" href="${pageContext.servletContext.contextPath}/booking/history">Lịch sử đặt phòng</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- SIDEBAR-->
            <div class="col-md-3">
                <div class="sidebar-wrap">
                    <div class="side search-wrap animate-box">
                        <h3 class="sidebar-heading">${room.room_name}</h3>
                        <hr>
                        <form method="post" action="hotels.html" class="colorlib-form">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Ngày nhận:
                                            <span class="check-date">${check_in}</span>
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Ngày trả:
                                            <span class="check-date">${check_out}</span>
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="date">Địa chỉ:
                                            <span class="check-date">
                                                        ${room.room_address}, ${room.homestay.location.location_name}
                                                    </span>
                                        </label>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <hr>
                                    <h3 style="color: #fff">Tổng tiền</h3>
                                    <div class="form-group">
                                        <label for="date">giá phòng ${room.room_price}đ x ${days} ngày
                                        </label>
                                        <h2 style="color: #fff"> = ${room.room_price * days}đ</h2>
                                    </div>
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
</body>
</html>