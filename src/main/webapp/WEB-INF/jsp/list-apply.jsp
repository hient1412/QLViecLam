<%-- 
    Document   : list-apply
    Created on : Sep 3, 2022, 12:49:12 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <c:if test="${apply.size() != 0}">
        <div class="center">
            <div class="row">
                <div class="col-md-12"><h2>DS CÔNG VIỆC ĐÃ ỨNG TUYỂN</h2></div>
            </div>
        </div>
        <table class="table table-bordered center">
            <thead>
                <tr>
                    <th>Tên Tin</th>
                    <th>Tên công ty</th>
                    <th>Ngày ứng tuyển</th>
                    <th>Lương</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${apply}" var="a">
                    <tr>
                        <td>${a[0]}</td>
                        <td>${a[1]}</td>
                        <td>${a[2]}</td>
                        <td><fmt:formatNumber value="${a[3]}" maxFractionDigits="3" type="number"/> VND</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${apply.size() == 0}">
        <div class="center"><strong><i>Chưa từng ứng tuyển</i></strong></div>
                </c:if>
</div>

