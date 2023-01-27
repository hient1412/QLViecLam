<%-- 
    Document   : job-detail
    Created on : Aug 20, 2022, 11:52:11 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="content">
    <div class="container">
        <div class="bg-body">
            <div class="row p-4"> 
                <div class="col-md-2">
                    <img class="rounded-circle img-fluid" src="${ntd.avatar}">
                </div>
                <div class="col-md-8 p-3">
                    <div><h1 class="text-primary">${ttd.tenTTD}</h1></div>
                    <div><h4><a class="a-ttd" href="<c:url value="/company-detail/${ttd.maNTD}"/>">${ntd.tenNTD}</a></h4></div>
                    <div><h5>Hạn hồ sơ: <fmt:formatDate value="${ttd.ngayKT}" type="date" pattern="dd-MM-yyyy"/></h5></div>
                    <div><h5>Loại việc làm: ${vl.tenLoaiVL}</h5></div>
                </div><div class="col-md-2">
                    
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ROLE_UV')">
                        <div class="row p-2">
                            <a href="<c:url value="/candidate/job-apply"/>?id=${ttd.maTTD}" class="btn btn-primary btn-lg">Ứng tuyển</a>
                        </div>
                        <div class="row p-2">
                            <a href="#" class="btn btn-danger btn-lg">Lưu tin</a>
                        </div>
                   </sec:authorize>
                    <sec:authorize access="!hasRole('ROLE_UV')">
                    <div>
                        <h4 class="center">BẠN KHÔNG CÓ QUYỀN SỬ DỤNG CHỨC NĂNG NÀY!!!</h4>
                    </div>
                    </sec:authorize>
                </sec:authorize>
                    
                <sec:authorize access="!isAuthenticated()">
                    <div>
                        <h4 class="center">VUI LÒNG <a href="<c:url value="/login"/>">ĐĂNG NHẬP</a> ĐỂ CÓ THỂ ỨNG TUYỂN!!! </h4>
                    </div>
                </sec:authorize>   
                    </div>
            </div>
            <div class="row p-5"> 
                <h1 class="p-2" >Thông tin chung</h1> 
                <div class="col-md-3 bg-light"> 
                    <strong>Kinh nghiệm</strong> <br>
                    <span class="span">${ttd.kinhNghiem}</span> <br>
                    <strong>Vị trí</strong> <br>
                    <span class="span">${ttd.viTri}</span><br>
                    <strong>Số lượng tuyển</strong> <br>
                    <span class="span">${ttd.soLuong}</span><br>
                </div>
                <div class="col-md-3 bg-light p-2 "> 
                    <strong>Nơi làm việc</strong> <br>
                    <span class="span">${ttd.noiLamViec}</span> <br>
                    <strong>Lương</strong> <br>
                    <span class="span"><fmt:formatNumber value="${ttd.luong}" maxFractionDigits="3" type="number"/> VND</span><br>
                    <strong>Loại việc làm</strong> <br>
                    <span class="span">${vl.tenLoaiVL}</span><br>
                </div>
            </div>
            <hr>
            <div class="row p-5">
                <h1>Mô tả</h1>
                <div class="col-md-12 bg-light"><span class="span">${ttd.moTaTTD}</span> <br></div>
            </div>
        </div>
    </div>
</div>
