<%--
    Document   : personal-info
    Created on : Aug 28, 2022, 1:20:10 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">
    <div class="row mb-5">
        <div class="col-lg-5 mb-5 mb-lg-0 bg-light mt-5">
            <div class="ml-3 p-3" style="font-size: 20px">
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
                        <c:choose>
                            <c:when test="${uv.cv == '' || uv.cv == null}">
                                <div class="title-big">
                                    <p><span class="bold">CV: </span> Chưa upload cv </p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="title-big">
                                    <p><span class="bold">CV: </span><a target="_blank" href="${uv.cv}">Xem trước</a></p>
                                </div>
                            </c:otherwise>
                        </c:choose>
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
            </div>
        </div>
        <c:choose>
            <c:when test="${tk.loaiTK == 'ROLE_UV'}">
                <div class="col-lg-7 mt-5">
                    <img class="img-fluid" src="${uv.avatar}" />
                </div>
            </c:when>
            <c:when test="${tk.loaiTK == 'ROLE_NTD'}">
                <div class="col-lg-7 mt-5">
                    <img class="img-fluid" src="${ntd.avatar}" />
                </div>
            </c:when>
        </c:choose>
    </div>
</div>