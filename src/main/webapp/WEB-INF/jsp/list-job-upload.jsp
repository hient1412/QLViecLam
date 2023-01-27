<%-- 
    Document   : list-job-upload
    Created on : Sep 3, 2022, 3:37:45 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div>
        <a href="<c:url value="/company/view"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
    </div>
    <c:if test="${errMessage != null}">
        <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
            ${errMessage}
        </div>
    </c:if>
    <c:forEach var="c" items="${job}">
        <div class="row bg-light m-3 p-2">
            <div class="col-md-8">
                <div>
                    <h4>
                        <a class="a-ttd"  href="<c:url value="/job-detail/${c[0]}"/>">${c[1]}</a>
                    </h4>
                    <h6 style="color: red">Muc Luong: <fmt:formatNumber value="${c[5]}" maxFractionDigits="3" type="number"/> VND</h6>
                </div>
                <div class="row">
                    <div class="col-md-2"  >
                        <a href="<c:url value="/company-detail"/>"><img class="img-fluid" src="${c[11]}"/></a>
                    </div>
                    <div class="col-md-10 info_company">
                        <div><h5>Địa điểm: ${c[6]}</h5></div>
                        <div><h5>Hạn hồ sơ: <fmt:formatDate value="${c[2]}" type="date" pattern="dd-MM-yyyy"/></h5></div>
                        <div><h5>Loại việc làm: ${c[10]}</h5></div>
                        <c:if test="${c[13] == 1}">
                        <div><h5>Trạng thái: Đã kích hoạt </h5></div>
                        </c:if>
                        <c:if test="${c[13] == 0}">
                        <div><h5>Trạng thái: Chưa kích hoạt </h5></div>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div style="text-align: center;padding: 20px;font-size: 30px;">
                    <br>
                    <a title="Sửa" href="<c:url value="/company/list-job-upload/edit"/>?id=${c[0]}" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                    <br>
                    <a title="Xóa" href="<c:url value="/company/list-job-upload/delete"/>?id=${c[0]}" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>