<%-- 
    Document   : admin-edit
    Created on : Sep 5, 2022, 2:28:17 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/edit" var="action"/>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div class="row container d-flex justify-content-center">
                <div class="card">
                    <div class="card-body">
                        <h1 class="center">Cập nhật thông tin admin</h1>
                        <form:form action="${action}" method="post" modelAttribute="admin" enctype="multipart/form-data">
                            <form:input hidden="true" path="maAdmin" value="${admin.maAdmin}"/>
                            <div class="form-group">
                                <form:input autocomplete="off" type="text" class="form-control input-lg" path="hoAdmin" placeholder="Họ admin" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:input autocomplete="off" type="text" class="form-control input-lg" path="tenAdmin" placeholder="Tên admin" required="required"/>
                            </div>
                            <div class="form-group">
                                <form:input type="number" autocomplete="off" class="form-control input-lg" path="soDT" placeholder="Số điện thoại"/>
                            </div>
                            <div class="form-group">
                                <form:input type="email" autocomplete="off" class="form-control input-lg" path="email" placeholder="Email" required="required"/>
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