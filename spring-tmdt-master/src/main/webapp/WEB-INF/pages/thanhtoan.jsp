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
            <form method="post" action="${pageContext.servletContext.contextPath}/pay">
                <input type="text" value="5" name="price" />
                <button type="submit"> Payment with Paypal </button>
            </form>
        </div>
    </div>
</div>
<%@include file="components/footer.jsp" %>
</body>
</html>