<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                                <h3 class="panel-title">QUẢN LÝ HOMESTAY</h3>
                            </div>
                            <div class="panel-body">
                                <a href="${pageContext.servletContext.contextPath}/homestay/add_homestay" class="btn btn-default">
                                    <span class="glyphicon glyphicon-plus"></span>
                                </a>
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Tên phòng</th>
                                        <%--<th>Giới thiệu</th>--%>
                                        <th>Đánh giá</th>
                                        <th>Số lượt đánh giá</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="homestay" varStatus="loop" items="${homestay}">
                                        <tr>
                                            <td>${loop.index}</td>
                                            <td width="30%">${homestay.homestay_name}</td>
                                                <%--<td width="30%">--%>
                                                <%--${homestay.homestay_description}--%>
                                                <%--</td>--%>
                                            <td>${homestay.homestay_reviews}</td>
                                            <td>${homestay.homestay_number_reviews}</td>
                                            <td>
                                                <a class="btn btn-default">
                                                    <span class="glyphicon glyphicon-edit"></span>
                                                </a>
                                                <a class="btn btn-default">
                                                    <span class="glyphicon glyphicon-list"></span>
                                                    Quản lý phòng
                                                </a>
                                                <a class="btn btn-default">
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <c:if test="${fn:length(homestay) == 0}">
                                    <div class="text-center">
                                        <a class="btn btn-default"
                                           href="${pageContext.servletContext.contextPath}/homestay/add_homestay"
                                        >
                                            <span style="font-size: 20px" class="glyphicon glyphicon-plus"></span>
                                        </a>
                                        <br>
                                        Thêm homestay
                                    </div>
                                </c:if>
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