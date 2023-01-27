<%--
    Document   : company-detail
    Created on : Aug 21, 2022, 1:12:52 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="row">
        <div class="col-lg-8 mb-5 mb-lg-0 bg-light mt-5">
            <div class="ml-3">
                <div class="mt-4 text-primary">
                    <h4>${ntd.tenNTD}</h4>
                </div>
                <div>
                    <p><h5>Địa chỉ:</h5> ${ntd.diaChi}</p>
                </div>
                <div class="title-big">
                    <p><h5>Email</h5> ${ntd.email} </p>
                </div>
                <div class="title-big">
                    <p><h5>Mô tả chi tiết</h5> ${ntd.moTaNTD} </p>
                </div>
                <div>
                    <span class="bold">Website</span>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-4 mt-5">
            <img class="img-fluid" src="${ntd.avatar}" />
        </div>
    </div>

    <div style="background-color: lightblue">
        <p><h3 class="center">Các tin đã đăng tuyển</h3></p>
    </div>
    <div class="job__info--container">
        <div class="job__info--container--item">
            <c:forEach var="c" items="${job}">
                <div class="col-md-6 p-2">
                    <div>
                        <h5>
                            <a class="a-ttd"  href="<c:url value="/job-detail/${c[0]}"/>"> ${c[1]} </a>
                        </h5>
                        <h6 style="color: red">Muc Luong:<fmt:formatNumber value="${c[5]}" maxFractionDigits="3" type="number"/> VND</h6>
                    </div>
                    <div class="row">
                        <div class="col-md-2 avatar__job"  >
                            <img class="img-fluid" src="${c[11]}"/>
                        </div>
                        <div class="col-md-9 info_company">
                            <div class="info_company__item name__company">Tên công ty: ${c[12]}</div>
                            <div class="info_company__item name__company">Địa điểm: ${c[6]}</div>
                            <div class="info_company__item name__company">Hạn hồ sơ: <fmt:formatDate value="${c[2]}" type="date" pattern="dd-MM-yyyy"/></h5></div>
                            <div class="info_company__item name__company">Loại việc làm: ${c[10]}</div>
                        </div>
                    </div>
                </div>
                        <hr>
            </c:forEach>
        </div>
    </div>
    <c:url value="/api/company/${ntd.maNTD}/comment" var="endpoint"/>
    <sec:authorize access="isAuthenticated()">
        <div>
            <div class="d-flex flex-row add-comment-section mt-4 mb-4">
                <textarea type="text" id="binhLuan" class="form-control mr-3" placeholder="Nhập bình luận"></textarea>
                <input onclick="addBinhLuan('${endpoint}',${ntd.maNTD})" class="btn btn-primary" type="submit" value="Gửi bình luận"/>
            </div>
        </div>
    </sec:authorize>     
    <sec:authorize access="!isAuthenticated()">
        <div>
            <h4 class="center">VUI LÒNG <a href="<c:url value="/login"/>">ĐĂNG NHẬP</a> ĐỂ CÓ THỂ BÌNH LUẬN!!! </h4>
        </div>
    </sec:authorize>     

    <div id="bl">

    </div>

</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script  src="<c:url value="/js/ntd.js"/>"></script>
<script>
                    window.onload = function () {
                        loadBinhLuan('${endpoint}');
                    }
</script>




