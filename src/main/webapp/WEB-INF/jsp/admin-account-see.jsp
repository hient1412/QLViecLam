<%-- 
    Document   : admin-account-see
    Created on : Sep 2, 2022, 5:37:08 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container">
    <div>
        <a href="<c:url value="/admin/account"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
    </div>
    <div class="row mb-5">
        <div class="col-lg-5 mb-5 mb-lg-0 bg-light mt-5">
            <div class="ml-3 p-3" style="font-size: 20px">
                <div>
                    <p><span class="bold">Mã tài khoản: </span> ${tk.maTK}</p>
                </div>
                <div>
                    <p><span class="bold">Tên đăng nhập: </span> ${tk.taiKhoan}</p>
                </div>
                <div>
                    <p><span class="bold">Loại tài khoản: </span> ${tk.loaiTK}</p>
                </div>
                <div>
                    <p><span class="bold">Trạng thái: </span>
                        <c:if test="${tk.trangThai == 1}">
                        <td>Đã được duyệt</td>
                    </c:if>
                    <c:if test="${tk.trangThai == 0}">
                        <td>Chưa được duyệt</td>
                    </c:if>
                    </p>
                </div>
                <c:choose>
                    <c:when test="${tk.loaiTK == 'ROLE_UV'}">
                        <div class="mt-4 text-primary">
                            <h4>${uv.hoUV} ${uv.tenUV}</h4>
                        </div>

                        <div>
                            <p><h5>Địa chỉ:</h5> ${uv.diaChi}</p>
                        </div>
                        <div class="title-big">
                            <p><h5>Email</h5> ${uv.email} </p>
                        </div>

                        <div class="title-big">
                            <p><h5>Quê quán</h5> ${uv.queQuan} </p>
                        </div>
                        <div class="title-big">
                            <p><h5>Ngày sinh</h5> <fmt:formatDate value="${uv.ngaySinh}" type="date" pattern="dd-MM-yyyy"/> </p>
                        </div>
                        <div class="title-big">
                            <p><h5>Nơi mong muốn làm việc</h5> ${uv.noiLamViec} </p>
                        </div>

                        <div class="title-big">
                            <p><h5>Mô tả chi tiết</h5> ${uv.moTaUV} </p>
                        </div>
                    </c:when>
                    <c:when test="${tk.loaiTK == 'ROLE_NTD'}">
                        <div class="mt-4 text-primary">
                            <h4>${ntd.tenNTD}</h4>
                        </div>

                        <div>
                            <p><h5>Địa chỉ:</h5> ${ntd.diaChi}</p>
                        </div>
                        <div class="title-big">
                            <p><h5>Số điện thoại</h5> ${ntd.soDT} </p>
                        </div>

                        <div class="title-big">
                            <p><h5>Email</h5> ${ntd.email} </p>
                        </div>

                        <div class="title-big">
                            <p><h5>Mô tả chi tiết</h5> ${ntd.moTaNTD} </p>
                        </div>
                    </c:when>
                    <c:when test="${tk.loaiTK == 'ROLE_ADMIN'}">
                        <div class="mt-4 text-primary">
                            <h4>${ad.hoAdmin} ${ad.tenAdmin}</h4>
                        </div>
                        <div class="title-big">
                            <p><h5>Số điện thoại</h5> ${ad.soDT} </p>
                        </div>

                        <div class="title-big">
                            <p><h5>Email</h5> ${ad.email} </p>
                        </div>
                    </c:when>
                </c:choose>
                <div>
                    <span class="bold">Website</span>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                </div>
            </div>
        </div>
        <c:choose>
            <c:when test="${tk.loaiTK == 'ROLE_UV'}">
                <div class="col-lg-7 mt-5">
                    <img class="img-fluid" src="${uv.avatar}" />
                    <div class="center">
                        <input type="button" value="Chat ngay" class="btn btn-primary btn-lg">
                    </div>
                </div>
            </c:when>
            <c:when test="${tk.loaiTK == 'ROLE_NTD'}">
                <div class="col-lg-7 mt-5">
                    <img class="img-fluid" src="${ntd.avatar}" />
                    <div class="center">
                        <input type="button" value="Chat ngay" class="btn btn-primary btn-lg">
                    </div>
                </div>
            </c:when>
        </c:choose>
        </div>
    </div>