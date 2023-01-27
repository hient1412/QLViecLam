<%-- 
    Document   : job-apply
    Created on : Sep 4, 2022, 6:56:39 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/candidate/job-apply" var="action"/>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div class="contact-form">
                <h1 class="center">Ứng tuyển <span style="color: darkblue">"${t.tenTTD}"</span></h1>
                <form:form action="${action}" method="post" modelAttribute="ungTuyen" enctype="multipart/form-data">
                    <form:input  path="maTTD" value="${t.maTTD}"/>
                    <form:input  path="maUV" value="${uv.maUV}"/>
                    <div class="form-group">
                        <label>CV
                            <br>
                            <c:choose>
                                <c:when test="${uv.cv.startsWith('http')}">
                                    <span><a target="_blank" href="${uv.cv}">Xem</a></span>
                                </c:when>
                                <c:otherwise>
                                    <span > Bạn chưa có CV. Vui lòng <a href="<c:url value="/candidate/edit"/>">cập nhật CV</a></span>
                                </c:otherwise>
                            </c:choose>
                        </label>
                    </div>
                    <div class="form-group">
                        <label>Thư giới thiệu</label>
                        <form:textarea path="thuGT" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Ứng tuyển</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>