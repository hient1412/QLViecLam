<%-- 
    Document   : login
    Created on : Aug 25, 2022, 1:24:50 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body style="background-image: url('https://wallpaperaccess.com/full/279553.jpg')">
    <c:url value="/login" var="action"/>
    <c:url value="/registry" var="registry"/>
    <div class="login-form">
        <form action="${action}" method="post">
            <h1 class="text-center">Đăng nhập</h1>
            <div class="form-group">
                <input autocomplete="off" type="text" class="form-control input-lg" name="taiKhoan" placeholder="Tên đăng nhập" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control input-lg" name="matKhau" placeholder="Mật khẩu" required="required">
            </div>        
            <div class="form-group">
                <input type="submit" class="btn btn-primary btn-lg btn-block login-btn" value="Đăng nhập"/>
            </div>
            <c:if test="${param.error != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                    Có lỗi xảy ra!!
                </div>
            </c:if>
            <c:if test="${param.accessDenied != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                     Bạn không có quyền truy cập!!!
                </div>
            </c:if>
            
            <div class="text-center">
                <p>Bạn chưa có tài khoản? <a href="${registry}">Đăng ký ngay</a></p>
                <a href="#">Quên mật khẩu</a>
            </div>
        </form>
    </div>
</body>