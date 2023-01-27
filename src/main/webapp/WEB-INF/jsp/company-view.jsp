<%-- 
    Document   : company-view
    Created on : Sep 3, 2022, 3:24:05 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <h1 class="center"> QUẢN LÝ TIN TUYỂN DỤNG</h1>
            <div class="row center bg-light">
                <div class="col-md-4">
                    <a href="<c:url value="/company/list-job-upload"/>?id=${ntd}" class="nav-link">DANH SÁCH CÔNG VIỆC ĐÃ ĐĂNG</a>
                </div>
                <div class="col-md-4">
                    <a href="<c:url value="/company/job-upload"/>" class="nav-link">ĐĂNG TIN</a>
                </div>
                <div class="col-md-4">
                    <a href="<c:url value="/company/uv-apply"/>?id=${ntd}" class="nav-link">CÁC ỨNG VIÊN ỨNG TUYỂN</a>
                </div>
            </div>
        </div>
    </div>
</div>