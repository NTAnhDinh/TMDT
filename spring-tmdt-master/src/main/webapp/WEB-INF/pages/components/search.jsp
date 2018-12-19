<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="colorlib-reservation">
    <!-- <div class="container"> -->
    <div class="row">
        <div class="search-wrap">
            <div class="container">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#flight"><i class="flaticon-plane"></i> Lựa
                        chọn</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div id="flight" class="tab-pane fade in active">
                    <form action="${pageContext.servletContext.contextPath}/room/search" class="colorlib-form">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label>Điểm đến</label>
                                    <div class="form-field">
                                        <i class="icon icon-arrow-down3"></i>
                                        <select name="location" id="people" class="form-control">
                                            <c:forEach var="location" items="${location}">
                                                <option value="${location.location_id}">
                                                        ${location.location_name}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="date">Ngày nhận:</label>
                                    <div class="form-field">
                                        <i class="icon icon-calendar2"></i>
                                        <input name="check-in"
                                               autocomplete="off"
                                               type="text" id="date" class="form-control date"
                                               placeholder="Ngày nhận">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="date">Ngày trả:</label>
                                    <div class="form-field">
                                        <i class="icon icon-calendar2"></i>
                                        <input name="check-out"
                                               autocomplete="off"
                                               type="text" id="date" class="form-control date"
                                               placeholder="Ngày trả">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label>Số người</label>
                                    <div class="form-field">
                                        <i class="icon icon-arrow-down3"></i>
                                        <select name="guest"
                                                id="people" class="form-control">
                                            <c:forEach begin="1" end="5" var="i">
                                                <option style="background-color: #eee; color: #0b0b0b"
                                                        value="${i}">
                                                        ${i}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <input type="submit" name="submit" id="submit" value="Search"
                                       class="btn btn-primary btn-block">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>