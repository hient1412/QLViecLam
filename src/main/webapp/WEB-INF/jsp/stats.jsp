<%-- 
    Document   : stats
    Created on : Sep 4, 2022, 9:17:22 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <h1 class="center">THỐNG KÊ BÁO CÁO</h1>
            <div class="row center bg-light">
                <div class="col-md-6">
                    <a href="<c:url value="/admin/stats/job-type"/>" class="nav-link">TIN THEO LOẠI VIỆC LÀM</a>
                </div>
                <div class="col-md-6">
                    <a href="<c:url value="/admin/stats/account"/>" class="nav-link">LOẠI TÀI KHOẢN</a>
                </div>
            </div>
        </div>
    </div>
</div>