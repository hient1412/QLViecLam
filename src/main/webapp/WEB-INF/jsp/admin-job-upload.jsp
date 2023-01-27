<%-- 
    Document   : admin-job-upload
    Created on : Sep 4, 2022, 11:07:30 PM
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
                    <div class="col-md-12"><h2>QUẢN LÝ TÀI KHOẢN</h2></div>
                </div>
            </div>
            <table class="table table-bordered center">
                <thead>
                    <tr>
                        <th>Mã tin</th>
                        <th>Tên tin</th>
                        <th>Loại việc làm</th>
                        <th>Nhà tuyển dụng</th>
                        <th>Vị trí</th>
                        <th>Ngày hết hạn</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listTK}" var="tk">
                        <tr>
                            <td>${tk.maTK}</td>
                            <td>${tk.taiKhoan}</td>
                            <td>${tk.loaiTK}</td>
                            <c:if test="${tk.trangThai == 1}">
                                <td>Đã được duyệt</td>
                            </c:if>
                            <c:if test="${tk.trangThai == 0}">
                                <td>Chưa được duyệt</td>
                            </c:if>
                            <td><a title="Xem" href="<c:url value="/admin/job-upload/see"/>?id=${tk.maTK}" data-toggle="tooltip"><i style="font-size:24px" class="fa">&#xf06e;</i></a>
                                <a title="Sửa" href="<c:url value="/admin/job-upload/edit"/>?id=${tk.maTK}" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a title="Xóa" href="<c:url value="/admin/job-upload/delete"/>?id=${tk.maTK}" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                <td colspan="5">
                    <a class="nav-link" title="Thêm tin tuyển dụng" href="<c:url value="/admin/job-upload/add"/>" data-toggle="tooltip">Thêm tài khoản</a>
                </td>
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
                        <a class="page-link" href="<c:url value="/admin/job-upload"/>?page=${i}">${i}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
