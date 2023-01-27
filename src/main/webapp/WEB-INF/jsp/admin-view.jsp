<%-- 
    Document   : admin-view
    Created on : Aug 31, 2022, 8:01:56 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <h1 class="center">QUẢN LÝ</h1>
            <div class="row center bg-light">
                <div class="col-md-3">
                    <a href="<c:url value="/admin/account"/>" class="nav-link">TÀI KHOẢN</a>
                </div>
                <div class="col-md-3">
                    <a href="<c:url value="/admin/job-type"/>" class="nav-link">LOẠI VIỆC LÀM</a>
                </div>
                <div class="col-md-3">
                    <a href="<c:url value="/admin/company-confirm"/>" class="nav-link">DUYỆT NHÀ TUYỂN DỤNG</a>
                </div>
                <div class="col-md-3">
                    <a href="<c:url value="/admin/stats"/>" class="nav-link">THỐNG KÊ - BÁO CÁO</a>
                </div>
            </div>
        </div>
    </div>
</div>