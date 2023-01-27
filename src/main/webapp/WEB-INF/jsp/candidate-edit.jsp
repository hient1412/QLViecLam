<%-- 
    Document   : candidate-edit
    Created on : Sep 4, 2022, 6:16:40 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/candidate/edit" var="action"/>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div class="row container d-flex justify-content-center">
                <div class="card">
                    <div class="card-body">
                        <h1 class="center">Cập nhật thông tin ứng viên</h1>
                        <form:form action="${action}" method="post" modelAttribute="ungVien" enctype="multipart/form-data">
                            <form:input hidden="true" path="maUV" value="${ungVien.maUV}"/>
                            <div class="form-group">
                                <form:input autocomplete="off" type="text" class="form-control input-lg" path="hoUV" placeholder="Họ" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:input autocomplete="off" type="text" class="form-control input-lg" path="tenUV" placeholder="Tên" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:input  type="date"   autocomplete="off"  class="form-control input-lg" path="ngaySinh" placeholder="Ngày sinh" required="required"/>
                            </div>
                            <label for="role">Giới tính của bạn:</label>
                            <form:select path="gioiTinh" >
                                <form:option value="Nam" label="Nam"/>
                                <form:option value="Nữ" label="Nữ"/>
                            </form:select>
                            <div class="form-group">
                                <label >Upload CV
                                    <br>
                                    <c:if test="${ungVien.cv.startsWith('http')}">
                                        Đã từng upload CV trước đây. <span><a target="_blank" href="${ungVien.cv}">Xem lại</a></span>
                                    </c:if>
                                    <br>(Chỉ upload file hình ảnh) <span style="color: red">*</span>
                                    
                                </label>
                                <form:input type="file" path="file" accept="image/*" class="form-control"/>
                            </div>
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
                </div>
            </div>
        </div>
    </div>
</div>