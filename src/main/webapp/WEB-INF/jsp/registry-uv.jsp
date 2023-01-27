<%-- 
    Document   : registry-uv
    Created on : Aug 31, 2022, 5:36:47 PM
    Author     : DELL
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body style="background-image: url('https://wallpaperaccess.com/full/279553.jpg')">
    <c:url value="/registry/uv" var="action"/>
    <div class="login-form">
        <form:form action="${action}" method="post" modelAttribute="ungVien" enctype="multipart/form-data">
            <h2 class="text-center">Đăng ký ứng viên</h2>
            <form:input hidden="true" path="maTK" value ="${tk.maTK}"/>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="hoUV" placeholder="Họ" required="required"/>
            </div>
            <div class="form-group">
                <form:input autocomplete="off" type="text" class="form-control input-lg" path="tenUV" placeholder="Tên" required="required"/>
            </div>
            <div class="form-group">
                <form:input  type="date"   autocomplete="off"  class="form-control input-lg" path="ngaySinh" placeholder="Ngày sinh" required="required"/>
            </div>
            <div class="form-group">
                <label for="avatar">Avatar</label>
                <form:input type="file" path="file2" id="avatar" class="form-control input-lg"/>
            </div>
            <label for="role">Giới tính của bạn:</label>
            <form:select path="gioiTinh" >
                <form:option value="Nam" label="Nam"/>
                <form:option value="Nữ" label="Nữ"/>
            </form:select>

            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="diaChi" placeholder="Địa chỉ" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="queQuan" placeholder="Quê quán"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="noiLamViec" placeholder="Nơi làm việc hiện tại"/>
            </div>

            <div class="form-group">
                <form:input type="email" autocomplete="off" class="form-control input-lg" path="email" placeholder="Email" required="required"/>
            </div>
            <div class="form-group">
                <form:input type="text" autocomplete="off" class="form-control input-lg" path="moTaUV" placeholder="Mô tả"/>
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