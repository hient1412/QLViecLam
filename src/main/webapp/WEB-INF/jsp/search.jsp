<%--
    Document   : search
    Created on : Aug 17, 2022, 7:19:35 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="<c:url value="/css/style-search.css"/>" rel="stylesheet"/>

<div class="content">
    <div class="container p-5">
        <c:if test="${!kw.isEmpty()}">
            <div class="title-center">
                <h1>Kết quả tìm kiếm</h1>
                <span style="color: blue">"${kw}"</span>
            </div>
            <c:if test="${counterS != 0}">
                <div style="text-align: center">
                    <span>Tìm thấy <span style="color: red">${counterS}</span> kết quả phù hợp</span>
                </div>
            </c:if>
        </c:if>

        <c:choose>
            <c:when test="${ttdJoin.size() == 0}">
                <div class="job__info center">
                    <i>Không tìm thấy việc làm phù hợp với yêu cầu tìm kiếm của bạn</i>
                </div>
            </c:when>
            <c:otherwise>
                <div class="job__info">
                    <div class="row">
                        <div class="col-md-9">
                            <c:forEach var="c" items="${ttdJoin}">
                                <div class="bg-light m-3 p-2">
                                    <div class="col-md-9">
                                        <div>
                                            <h4>
                                                <a class="a-ttd"  href="<c:url value="/job-detail/${c[0]}"/>"> ${c[1]} </a>
                                            </h4>
                                            <h5 style="color: red">Muc Luong:</h5>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-2"  >
                                                <a href="<c:url value="/company-detail"/>"><img class="img-fluid" src="${c[6]}"/></a>
                                            </div>
                                            <div class="col-md-9 info_company">
                                                <div><h5>Tên công ty: ${c[3]}</h5></div>
                                                <div><h5>Địa điểm: ${c[4]}</h5></div>
                                                <div><h5>Hạn hồ sơ: <fmt:formatDate value="${c[5]}" type="date" pattern="dd-MM-yyyy"/></h5></div>
                                                <div><h5>Loại việc làm: ${c[8]}</h5></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div style="background-color: #FF6F61; width:  300px;" class="col-md-3 right-box center">
                            <h1>Quảng Cáo</h1>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>