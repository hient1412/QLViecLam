<%-- 
    Document   : job-type-edit
    Created on : Sep 1, 2022, 9:15:53 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/job-type/edit"  var="action"/>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div>
                <a href="<c:url value="/admin/job-type"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
            </div>
            <form:form action="${action}" modelAttribute="loaiVL" method="post">
                <form:hidden path="maLoaiVL"/>
                <div class="center">
                    <div class="row">
                        <div class="col-md-12"><h2>CHỈNH SỬA TÊN LOẠI VIỆC LÀM</h2></div>
                    </div>
                </div>
                <div>
                    <div class="d-flex flex-row add-comment-section mt-4 mb-4">
                        <form:input autocomplete="off" type="text" class="form-control mr-3" path="tenLoaiVL" placeholder="Nhập tên loại việc làm"/>
                        <form:button type="submit" class="btn btn-primary">Sửa</form:button>
                        </div>
                    </div>
            </form:form>
        </div>
    </div>
</div>


