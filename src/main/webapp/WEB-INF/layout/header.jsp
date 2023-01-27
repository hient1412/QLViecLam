<%-- 
    Document   : header
    Created on : Aug 5, 2022, 5:42:44 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar sticky-top ">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/" />">&copy; VLTuyenDung &copy;</a>
        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ">
                <li class="nav-item active"><a href="<c:url value="/companies" />" class="nav-link" >Công ty</a></li>
                <li class="nav-item active"><a href="<c:url value="/candidates" />" class="nav-link" >Ứng viên</a></li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item active"><a class="nav-link a-login" href="<c:url value="/login"/>">Đăng nhập</a></li>
                        <li class="nav-item active"><a class="nav-link a-login" href="<c:url value="/registry"/>">Đăng ký</a></li>

                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="dropdown nav-item active">
                            <c:if test="${pageContext.session.getAttribute('current').loaiTK == ('ROLE_NTD')}">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action nav-link"><img src="${pageContext.session.getAttribute('currentNTD').getAvatar()}">${pageContext.request.userPrincipal.name}</a>
                                <ul class="dropdown-menu">
                                    <li><a href="<c:url value="/personal-info"/>"><i class="fa fa-user-o"></i>Thông tin cá nhân</a></li>                            
                                    <li><a href="<c:url value="/company/edit"/>"><i class="fa fa-pencil-square-o"></i>Cập nhật thông tin</a></li>
                                        <c:if test="${pageContext.session.getAttribute('current').trangThai == 1}">
                                        <li><a href="<c:url value="/company/view"/>"><i class="fa fa-briefcase"></i>Quản lý công việc</a></li>
                                        </c:if>
                                        <c:if test="${pageContext.session.getAttribute('current').trangThai == 0}">
                                        <li style="margin-left: 15px; color: red"><i class="fa fa-briefcase"></i>(Chưa kích hoạt)</li>
                                        </c:if>
                                    <li><a href="<c:url value="/logout"/>"><i class="material-icons">&#xE8AC;</i>Đăng xuất</a></li>
                                </ul>
                            </c:if>
                            <c:if test="${pageContext.session.getAttribute('current').loaiTK == ('ROLE_UV')}">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action nav-link"><img src="${pageContext.session.getAttribute('currentUV').getAvatar()}">${pageContext.request.userPrincipal.name}</a>
                                <ul class="dropdown-menu">
                                    <li><a href="<c:url value="/personal-info"/>"><i class="fa fa-user-o"></i>Thông tin cá nhân</a></li>
                                    <li><a href="<c:url value="/candidate/edit"/>"><i class="fa fa-pencil-square-o"></i>Cập nhật thông tin</a></li>
                                    <li><a href="<c:url value="/candidate/list-apply"/>?id=${pageContext.session.getAttribute('current').ungVien.maUV}"><i class="fa fa-briefcase"></i>Ds đã ứng tuyển</a></li>
                                    <li><a href="<c:url value="/logout"/>"><i class="material-icons">&#xE8AC;</i>Đăng xuất</a></li>
                                </ul>

                            </c:if>
                            <c:if test="${pageContext.session.getAttribute('current').loaiTK == ('ROLE_ADMIN')}">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action nav-link"><span>${pageContext.request.userPrincipal.name}</span>(${pageContext.session.getAttribute('current').loaiTK})</a>
                                <ul class="dropdown-menu">
                                    <li><a href="<c:url value="/personal-info"/>"><i class="fa fa-user-o"></i>Thông tin cá nhân</a></li>
                                    <li><a href="<c:url value="/admin/edit"/>"><i class="fa fa-pencil-square-o"></i>Cập nhật thông tin</a></li>
                                    <li><a href="<c:url value="/admin/view"/>"><i class="fa fa-briefcase"></i>Quản lý</a></li>
                                    <li><a href="<c:url value="/logout"/>"><i class="material-icons">&#xE8AC;</i>Đăng xuất</a></li>
                                </ul>

                            </c:if>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<div class="carousel-inner">
    <div class="carousel-item active">
        <img class="img-CV" src="https://png.pngtree.com/thumb_back/fw800/back_our/20190621/ourmid/pngtree-blue-minimalist-technology-computer-banner-image_188887.jpg" alt="banner">
        <div class="carousel-caption">
            <h3>Tìm việc phù hợp với bạn</h3>
            <form action="<c:url value="/search" />">
                <input autocomplete="off" type="text" name="kw" class="btn btn-outline-light btn-lg" size="50px" placeholder="Nhập từ khóa cần tìm .....">

                <input type="submit" value="Tìm kiếm" class="btn btn-primary btn-lg">
            </form>
        </div>
    </div>
</div>