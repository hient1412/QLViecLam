<%-- 
    Document   : admin-account-edit
    Created on : Sep 2, 2022, 7:41:42 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background-color: white">
    <c:url value="/admin/account/edit" var="action"/>
    <div>
        <a href="<c:url value="/admin/account"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
    </div>
    <div class="login-form">
        <form:form action="${action}" modelAttribute="tk" method="post">
            <form:hidden path="maTK"/>
            <h1 class="text-center">Sửa thông tin tài khoản</h1>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="taiKhoan" placeholder="Tên đăng nhập" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="password" class="form-control input-lg" path="matKhau" placeholder="Mật khẩu" required="required"/>
            </div>
            <div class="form-group">
                <label for="role"> Vai trò </label>
                <form:select path="loaiTK" >
                    <form:option value="ROLE_NTD" label="Nhà tuyển dụng"/>
                    <form:option value="ROLE_UV" label="Ứng viên" />
                </form:select>
            </div>
            <div class="form-group">
                <label for="role">Trạng thái</label>
                <form:select path="trangThai" >
                    <form:option value="0" label="Chưa duyệt" />
                    <form:option value="1" label="Đã được duyệt"/>
                </form:select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Sửa thông tin</button>
            </div>
            <c:if test="${errMessage != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                    ${errMessage}
                </div>
            </c:if>
        </form:form>
    </div>
</div>