<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/header.jsp" %>
    <%--
    <c:if test="${sessionScope.user == null}">--%>
    <%--
    <c:redirect url="${pageContext.servletContext.contextPath}/"></c:redirect>
    --%>
    <%--
</c:if>
--%>
</head>
<body>
<%@include file="components/navbar.jsp" %>
<div class="colorlib-wrap" style="padding-top: 0">
    <%--<div class="row well text-center">--%>
    <%--<ul id="progressbar" class="progressbar">--%>
    <%--<li class="current">Chi tiết đặt phòng</li>--%>
    <%--<li class="active">Yêu cầu đặt phòng</li>--%>
    <%--<li class="danger">Phê duyệt đặt phòng</li>--%>
    <%--<li class="">Xác nhận thanh toán</li>--%>
    <%--</ul>--%>
    <%--</div>--%>
    <div class="container" style="margin-top: 50px">
        <div class="row">
            <!-- SIDEBAR-->
            <%@include file="components/ad_info.jsp" %>
            <div class="col-md-9">
                <div class="row">
                    <div class="wrap-division">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <a href="${pageContext.servletContext.contextPath}/booking/ad">
                                        ĐẶT PHÒNG CỦA KHÁCH
                                    </a>
                                    > CẬP NHẬT THÔNG TIN
                                </h3>
                            </div>
                            <div class="panel-body">
                                <form method="post"
                                      action="${pageContext.servletContext.contextPath}/booking/ad/edit/${booking.booking_id}">
                                    <div class="form-horizontal">
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Tài khoản đặt phòng</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${booking.users.user_fullname}"
                                                       disabled
                                                       type="text" placeholder="Tên">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Ngày đặt phòng</label>
                                            <div class="col-sm-7">
                                                <input disabled class="form-control" value="${booking.created}"
                                                       type="text" placeholder="Email address">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Ngày nhận</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${booking.check_in}"
                                                       type="date" name="fdate" placeholder="Địa chỉ">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Ngày trả</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${booking.check_out}"
                                                       type="date" name="sdate" placeholder="Địa chỉ">
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Tên khách hàng</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${booking.customer_fullname}"
                                                       type="text" name="fullname" placeholder="Địa chỉ">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Số điện thoại</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${booking.customer_phone}"
                                                       type="text" name="phone" placeholder="Địa chỉ">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Giá</label>
                                            <div class="col-sm-7">
                                                <input class="form-control" value="${booking.booking_price}"
                                                       type="number" name="price" placeholder="Địa chỉ">
                                            </div>
                                        </div>
                                        <div class="form-group form-group-sm">
                                            <label class="col-sm-3 control-label">Trạng thái</label>
                                            <div class="col-sm-7">
                                                <select class="form-control" name="status">
                                                    <c:forEach var="i" begin="1" end="3">
                                                        <option value="${i}"

                                                                <c:if test="${i == booking.booking_status}">
                                                                    selected
                                                                </c:if>

                                                        >
                                                            <c:choose>
                                                                <c:when test="${i == 1}">
                                                                    Đã thanh toán
                                                                </c:when>
                                                                <c:when test="${i == 2}">
                                                                    Đang chờ
                                                                </c:when>
                                                                <c:otherwise>
                                                                    Hủy
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row col-sm-offset-3">
                                            <a href="${pageContext.servletContext.contextPath}/booking/ad"
                                               class="btn btn-default">
                                                <span class="glyphicon glyphicon-backward"></span>
                                                Quay lại
                                            </a>
                                            <button type="submit" class="btn btn-default">
                                                <span class="glyphicon glyphicon-check"></span>
                                                Xác nhận
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="components/footer.jsp" %>
</body>
</html>