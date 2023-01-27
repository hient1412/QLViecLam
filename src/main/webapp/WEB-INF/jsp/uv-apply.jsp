<%-- 
    Document   : uv-apply
    Created on : Sep 3, 2022, 8:28:23 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div>
        <a href="<c:url value="/company/view"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
    </div>
    <c:if test="${apply.size() != 0}">
        <div class="center">
            <div class="row">
                <div class="col-md-12"><h2>DANH SÁCH CÁC ỨNG VIÊN ỨNG TUYỂN</h2></div>
            </div>
        </div>
        <table class="table table-bordered center">
            <thead>
                <tr>
                    <th>Tên Tin</th>
                    <th>Họ ứng viên</th>
                    <th>Tên ứng viên</th>
                    <th>CV</th>
                    <th>Thư</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${apply}" var="a">
                    <tr>
                        <td>${a[0]}</td>
                        <td>${a[1]}</td>
                        <td>${a[2]}</td>
                        <td><a href="${a[3]}" target="_blank">Xem CV</a></td>
                        <td>${a[4]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${apply.size() == 0}">
        <div class="center"><strong><i>Chưa có ứng viên ứng tuyển</i></strong></div>
                </c:if>
</div>
