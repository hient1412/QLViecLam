<%-- 
    Document   : job-upload
    Created on : Sep 2, 2022, 9:24:29 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/company/job-upload" var="action"/>
<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div>
                <a href="<c:url value="/company/view"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
            </div>
            <div class="row container d-flex justify-content-center">
                <div class="card">
                    <div class="card-body">
                        <h1 class="center">ĐĂNG TIN TUYỂN DỤNG</h1>
                        <form:form action="${action}" method="post" modelAttribute="ttd">
                            <div class="form-group row">
                                <div class="col">
                                    <label>Tiêu đề</label>
                                    <form:input type="text" path="tenTTD" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Ngày hết hạn</label>
                                    <form:input type="date" path="ngayKT" class="form-control" autocomplete="off"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col">
                                    <label>Nơi làm việc</label>
                                    <form:input type="text" path="noiLamViec" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label> Loại công việc</label>
                                    <form:select class="form-control" path="maLoaiVL">
                                        <c:forEach items="${loaiVL}" var="c">
                                            <option value="${c.maLoaiVL}"> ${c.tenLoaiVL}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col">
                                    <label>Vị trí</label>
                                    <form:input type="text" path="viTri" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Số lượng</label>
                                    <form:input type="number" path="soLuong" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Kinh nghiệm</label>
                                    <form:input type="text" path="kinhNghiem" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Lương</label>
                                    <form:input type="number" path="luong" class="form-control" autocomplete="off"/>
                                </div>
                            </div>
                            <div>
                                <label>Mô tả chi tiết</label>
                                <form:textarea type="text" path="moTaTTD" class="form-control"/>
                            </div>
                            <br>
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Đăng tin</button>
                            </div>
                        </form:form>
                        <c:if test="${errMessage != null}">
                            <div class="text-danger" style="text-align: center; font-size: 20px; padding: 10px;">
                                ${errMessage}
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
