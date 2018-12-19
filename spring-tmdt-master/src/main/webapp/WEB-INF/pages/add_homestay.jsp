<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/header.jsp" %>
    <style>
        .form-control {
            margin-bottom: 5px;
        }
    </style>
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
                                    <a href="${pageContext.servletContext.contextPath}/homestay/my_homestay">
                                        QUẢN LÝ HOMESTAY</a> > THÊM HOMESTAY</h3>
                            </div>
                            <div class="panel-body">
                                <form action="${pageContext.servletContext.contextPath}/homestay/add_homestay"
                                      enctype="multipart/form-data"
                                      method="post">
                                    <div class="form-group form-group-sm">
                                        <label class="col-sm-2 control-label">Tên homestay</label>
                                        <div class="col-sm-9">
                                            <input class="form-control"
                                                   type="text" name="homestay_name" placeholder="Tên Homestay">
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group form-group-sm">
                                        <label class="col-sm-2 control-label">Giới thiệu</label>
                                        <div class="col-sm-9">
                                        <textarea class="form-control"
                                                  rows="4"
                                                  name="homestay_description"
                                                  placeholder="Giới thiệu"
                                        ></textarea>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group form-group-sm">
                                        <label class="col-sm-2 control-label">Địa chỉ</label>
                                        <div class="col-sm-9">
                                            <select class="form-control" name="homestay_location">
                                                <c:forEach var="location" items="${location}">
                                                    <option value="${location.location_id}">
                                                        ${location.location_name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group form-group-sm">
                                        <label class="col-sm-2 control-label">Ảnh homestay</label>
                                        <div class="col-sm-9">
                                            <input class="form-control" name="data_image"
                                                   type="file">
                                        </div>
                                    </div>
                                    <div class="form-group form-group-sm">
                                        <label class="col-sm-2 control-label"></label>
                                        <div class="col-sm-9">
                                            <button style="border-radius: 0" class="btn btn-default" type="submit">
                                                <span class="glyphicon glyphicon-plus"></span>
                                                Thêm
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
<%@include file="components/footer.jsp" %>
</body>
</html>