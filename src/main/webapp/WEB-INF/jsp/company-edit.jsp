<%-- 
    Document   : company-edit
    Created on : Sep 4, 2022, 1:38:00 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/company/edit" var="action"/>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div class="row container d-flex justify-content-center">
                <div class="card">
                    <div class="card-body">
                        <h1 class="center">Cập nhật thông tin nhà tuyển dụng</h1>
                        <form:form action="${action}" method="post" modelAttribute="nhaTD" enctype="multipart/form-data">
                            <form:input hidden="true" path="maNTD" value="${nhaTD.maNTD}"/>
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
                                <form:textarea type="text" autocomplete="off" class="form-control input-lg" path="moTaNTD" placeholder="Mô tả"/>
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