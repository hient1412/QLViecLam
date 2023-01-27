<%-- 
    Document   : register
    Created on : Aug 31, 2022, 3:07:31 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body style="background-image: url('https://wallpaperaccess.com/full/279553.jpg')">
    <c:url value="/registry" var="action"/>
    <c:url value="/login" var="login"/>
    <div class="login-form">
        <form:form action="${action}" modelAttribute="user" method="post">
            <h1 class="text-center">Đăng ký</h1>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="taiKhoan" placeholder="Tên đăng nhập" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="password" class="form-control input-lg" path="matKhau" placeholder="Mật khẩu" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="password" class="form-control input-lg" path="xacNhanMK" placeholder="Xác nhận mật khẩu" required="required"/>
            </div>
            <label for="role"> Bạn đăng kí với vai trò </label>
            <form:select path="loaiTK" >
                <form:option value="ROLE_NTD" label="Nhà tuyển dụng"/>
                <form:option value="ROLE_UV" label="Ứng viên" />
            </form:select>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Đăng ký</button>
            </div>
            <c:if test="${errMessage != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                    ${errMessage}
                </div>
            </c:if>
            <div class="text-center ">
                <p>Bạn đã có tài khoản? <a href="${login}">Đăng nhập ngay</a></p>
            </div>
        </form:form>
    </div>
</body>