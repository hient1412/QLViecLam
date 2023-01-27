<%-- 
    Document   : candidate-detail
    Created on : Aug 29, 2022, 4:10:03 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <div class="row mb-5">
        <div class="col-lg-6  bg-light mt-5">
            <div class="ml-3">
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
                <div>
                    <span class="bold">Website</span>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-6 mt-5">
            <img class="img-fluid" src="${uv.avatar}" />
            <div class="center">
            <input type="button" value="Chat ngay" class="btn btn-primary btn-lg">
            </div>
        </div>
    </div>
</div>