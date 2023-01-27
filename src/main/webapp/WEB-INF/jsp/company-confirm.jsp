<%-- 
    Document   : confirm-company
    Created on : Sep 1, 2022, 1:38:35 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div>
                <a href="<c:url value="/admin/view"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
            </div>
            <c:choose>
                <c:when test="${listTK.size() > 0}">
                    <div class="center">
                        <div class="row">
                            <div class="col-md-12"><h2>DUYỆT NHÀ TUYỂN DỤNG</h2></div>
                        </div>
                    </div>
                    <table class="table table-bordered center">
                        <thead>
                            <tr>
                                <th>Mã tài khoản</th>
                                <th>Tên đăng nhập</th>
                                <th>Loại tài khoản</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tk" items="${listTK}">
                                <tr>
                                    <td>${tk.maTK}</td>
                                    <td>${tk.taiKhoan}</td>
                                    <td>${tk.loaiTK}</td>
                                    <td>
                                        <a title="Duyệt" href="<c:url value="/admin/company-confirm/1"/>?id=${tk.maTK}"
                                           data-toggle="tooltip"><i style="font-size:24px" class="fa">&#xf00c;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="4">
                                    <a class="nav-link" title="Duyệt tất cả" href="<c:url value="/admin/company-confirm/all"/>"data-toggle="tooltip">Xác nhận tất cả</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <c:if test="${errMessage != null}">
                        <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                            ${errMessage}
                        </div>
                    </c:if>

                    <ul class="pagination d-flex justify-content-center mt-4">
                        <c:forEach begin="1" end="${Math.ceil(size/6)}" var="i">
                            <li class="page-item">
                                <a class="page-link" href="<c:url value="/admin/company-confirm"/>?page=${i}">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:otherwise>
                    <div class="center">
                        <h2>CÁC NHÀ TUYỂN DỤNG ĐÃ ĐƯỢC XÁC NHẬN</h2>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>