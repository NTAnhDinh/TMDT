<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="components/header.jsp" %>
</head>
<body>
<%@include file="components/navbar.jsp" %>
<div id="colorlib-contact">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 animate-box">
                <h3>Đăng Nhập</h3>
                <h4 style="color: red">${message}</h4>
                <form action="${pageContext.servletContext.contextPath}/login" method="post">
                    <div class="row form-group">
                        <div class="col-md-6 padding-bottom">
                            <label>Username</label>
                            <input type="text" name="username" class="form-control" placeholder="Username">
                        </div>
                        <div class="col-md-6">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" value="Đăng Nhập" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="components/footer.jsp" %>
</body>
</html>