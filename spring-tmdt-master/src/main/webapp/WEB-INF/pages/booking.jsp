<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/header.jsp" %>
    <c:if test="${sessionScope.user == null}">
        <c:redirect url="${pageContext.servletContext.contextPath}/"></c:redirect>
    </c:if>
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
                                <h3>Lựa chọn tuyệt vời! Bạn chỉ mất 1 phút để đặt chỗ.</h3>
                                Điền thông tin của bạn bên dưới để hoàn thành việc đặt phòng.
                                Sau đó, chủ nhà sẽ có 24 giờ để chấp nhận yêu cầu đặt phòng của bạn.
                            </div>
                        </div>
                        <form action="${pageContext.servletContext.contextPath}/booking/success" method="post">
                            <input type="hidden" value="${check_in}" name="check_in"/>
                            <input type="hidden" name="check_out" value="${check_out}">
                            <input type="hidden" name="room_id" value="${room.room_id}">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">THÔNG TIN THANH TOÁN</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form-horizontal">
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-2 control-label">Tên</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${sessionScope.user.user_fullname}"
                                                       type="text" name="customer_fullname" placeholder="Tên">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-2 control-label">Email address</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${sessionScope.user.user_email}"
                                                       type="text" name="customer_email" placeholder="Email address">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-2 control-label">Địa chỉ</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${sessionScope.user.user_address}"
                                                       type="text" name="customer_address" placeholder="Địa chỉ">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-2 control-label">Số điện thoại</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" name="customer_phone"
                                                       value="${sessionScope.user.user_phone}"
                                                       type="text" placeholder="Số điện thoại">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--<div class="panel panel-info">--%>
                            <%--<div class="panel-heading">--%>
                            <%--<h3 class="panel-title">THÔNG TIN KHÁCH</h3>--%>
                            <%--</div>--%>
                            <%--<div class="panel-body">--%>
                            <%--<div class="form-group form-group-sm">--%>
                            <%--<label class="col-sm-2 control-label">Họ tên</label>--%>
                            <%--<div class="col-sm-7">--%>
                            <%--<input class="form-control" type="text" placeholder="Họ tên">--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <div class="payment-congrate">
                                <div class="inner">
                                    <p class="lead">Xin chúc mừng!! Bạn đã đặt được phòng có giá tốt <span
                                            class="font700">
                                                <span class="currency_symbol">&#8363;</span>${room.room_price * days}
                                            </span></p>
                                    <p>Giá có thể tăng lên, vì vậy hãy đảm bảo đặt phòng của bạn ngay hôm
                                        nay.</p>
                                    <input type="hidden" name="booking_price" value="${room.room_price * days}">
                                    <input type="submit"
                                           style="color: #000"
                                           class="btn book_now_step_2" value="Đặt phòng "><br>
                                    <a class="btn book_now_step_2" href="/">Tìm phòng khác</a>
                                    <p class="payment-term"> By submitting a booking request, you accept
                                        the <a href='#'>Terms and conditions</a> as well as the <a href='#'>Cancellation
                                            policy</a> and <a href='#'>House Rules</a></p>
                                </div>
                            </div>
                        </form>
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