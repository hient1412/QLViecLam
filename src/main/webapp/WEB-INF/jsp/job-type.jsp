<%-- 
    Document   : jobtype
    Created on : Sep 1, 2022, 7:48:27 PM
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
            <div class="center">
                <div class="row">
                    <div class="col-md-12"><h2>QUẢN LÝ LOẠI VIỆC LÀM</h2></div>
                </div>
            </div>
            <table class="table table-bordered center">
                <thead>
                    <tr>
                        <th>Mã loại</th>
                        <th>Tên loại công việc</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="v" items="${vls}">
                        <tr>
                            <td>${v.maLoaiVL}</td>
                            <td>${v.tenLoaiVL}</td>
                            <td>
                                <a title="Sửa" href="<c:url value="/admin/job-type/edit"/>?id=${v.maLoaiVL}"
                                   data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a title="Xóa" href="<c:url value="/admin/job-type/delete"/>?id=${v.maLoaiVL}"
                                   data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4">
                            <a class="nav-link" title="Thêm loại việc làm" href="<c:url value="/admin/job-type/add"/>" data-toggle="tooltip">Thêm loại việc làm</a>
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
                        <a class="page-link" href="<c:url value="/admin/job-type"/>?page=${i}">${i}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>