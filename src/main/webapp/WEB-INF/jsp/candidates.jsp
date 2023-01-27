<%-- 
    Document   : candidates
    Created on : Aug 20, 2022, 8:37:41 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
    <div class="container">
        <div class="row">
            <c:forEach var="n" items="${uv}">
                <div class="card div-ttd col-md-3 col-xs-12">
                    <div>
                        <img class="card-img-top" src="${n.avatar}">
                    </div>
                    <div>
                        <h4 class="card-title">${n.hoUV}</h4>
                        <p> ${n.tenUV} </p>
                        <a href="<c:url value="/candidate-detail/${n.maUV}" />" class="btn btn-primary">Xem hồ sơ</a>
                        <a href="#" class="btn btn-danger">Chat</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>