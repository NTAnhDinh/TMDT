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
            <%@include file="components/ad_info.jsp"%>
            <div class="col-md-9">
                <div class="row">
                    <div class="wrap-division">

                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">LỊCH Sử ĐẶT PHÒNG</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Tên phòng</th>
                                        <th>Giá phòng</th>
                                        <th>Trạng thái</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="booking" varStatus="loop" items="${booking}">
                                    <tr>
                                        <td>${loop.index}</td>
                                        <td width="30%">${booking.room.room_name}</td>
                                        <td>
                                            <fmt:formatNumber type="number" pattern="###,###" value="${booking.booking_price}"></fmt:formatNumber> VNĐ
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${booking.booking_status == 1}">
                                                    Đã thanh toán
                                                </c:when>
                                                <c:when test="${booking.booking_status == 2}">
                                                    Đang chờ
                                                </c:when>
                                                <c:otherwise>
                                                    Đã hủy
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <a href="" class="btn btn-default">
                                                <span class="glyphicon glyphicon-edit"></span>
                                            </a>
                                            <a href="" class="btn btn-default">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
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