<%-- 
    Document   : registry-ntd
    Created on : Sep 1, 2022, 12:42:21 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body style="background-image: url('https://wallpaperaccess.com/full/279553.jpg')">
    <c:url value="/registry/ntd" var="action"/>
    <div class="login-form">
        <form:form action="${action}" method="post" modelAttribute="nhaTuyenDung" enctype="multipart/form-data">
            <h2 class="text-center">Đăng ký nhà tuyển dụng</h2>
            <form:input hidden="true" path="maTK" value ="${tk.maTK}"/>
            
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="tenNTD" placeholder="Tên công ty" required="required"/>
            </div>
            <div class="form-group">
                <label for="avatar">Avatar</label>
                <form:input type="file" path="file" id="avatar" class="form-control input-lg"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="diaChi" placeholder="Địa chỉ" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="number" autocomplete="off" class="form-control input-lg" path="soDT" placeholder="Số điện thoại"/>
            </div>
            <div class="form-group">
                <form:input type="email" autocomplete="off" class="form-control input-lg" path="email" placeholder="Email" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="moTaNTD" placeholder="Mô tả"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Xong</button>
            </div>
            <c:if test="${errMessage != null}">
                <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                    ${errMessage}
                </div>
            </c:if>
        </form:form>
    </div>
</body>

