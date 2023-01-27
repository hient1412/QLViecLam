<%-- 
    Document   : company
    Created on : Aug 14, 2022, 12:36:22 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="container">
        <div class="row center">
            <div class="row">
                <c:forEach var="n" items="${ntd}">
                    <div class="card div-ttd col-md-3 col-xs-12">
                        <div>
                            <img class="card-img-top" src="${n.avatar}">
                        </div>
                        <div>
                            <h4 class="card-title center">${n.tenNTD}</h4>
                            <a href="<c:url value="/company-detail/${n.maNTD}"/>" class="btn btn-primary">Xem hồ sơ</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>