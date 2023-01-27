<%-- 
    Document   : home
    Created on : Aug 5, 2022, 5:44:50 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
    <div class="container">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="img-CV" src="https://t4.ftcdn.net/jpg/02/19/97/33/360_F_219973381_ADkrzGHo1b8vDWn96nJWUVdmjHEBe1if.jpg" alt="CV">
                <div class="text-CV">
                    <h2 style="color: darkblue">Sử dụng CV có sẳn để tìm việc</h2>
                    <input class="button-CV" type="button" value="Upload CV ngay">
                </div>
            </div>
        </div>
        <div style="background-color: white" class="container ds-ttd">
            <div class="row-ttd" class="row"><!<!-- tin tuyen dung loc ket qua theo nhieu tieu chi -->
                <h2 class="center">Việc làm mới nhất</h2>
                <c:forEach var="c" items="${ttdJoin}">
                    <div class="div-ttd col-md-5">
                        <div>
                            <h5>
                                <a class="a-ttd"  href="<c:url value="/job-detail/${c[0]}"/>"> ${c[1]} </a>
                            </h5>
                            <h6 style="color: red">Muc Luong: <fmt:formatNumber value="${c[2]}" maxFractionDigits="3" type="number"/> VND</h6>
                        </div>
                        <div class="row">
                            <div class="col-md-3" >
                                <a href="<c:url value="/company-detail/${c[7]}"/>"><img class="img-fluid" src="${c[6]}"/></a>
                            </div>

                            <div class="col-md-9">
                                <span class="bold">Tên công ty:</span> <span class="font20">${c[3]}</span><br>
                                <span class="bold">Địa điểm:</span> <span class="font20">${c[4]}</span><br>
                                <span class="bold">Hạn hồ sơ:</span> <span class="font20"><fmt:formatDate value="${c[5]}" type="date" pattern="dd-MM-yyyy"/></span><br>
                                <span class="bold">Loại việc làm:</span> <span class="font20">${c[8]}</span><br>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-md-12">
                <div class="pagination justify-content-center center">
                    <!--<li class="page-item previous-page"><a class="page-link" href="#">&laquo;</a></li>-->
                    <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="i">
                        <li class="page-item current-page"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
                        </c:forEach>
                    <!--<li class="page-item next-page"><a class="page-link" href="#">&raquo;</a></li>-->
                </div>
            </div>
        </div>
    </div>
</div>
