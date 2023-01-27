<%-- 
    Document   : job-upload-edit
    Created on : Sep 4, 2022, 7:54:13 AM
    Author     : DELL
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/company/list-job-upload/edit" var="action"/>
<div class="content">
    <div class="container">

        <div style="background-color: white" class="p-5">
            <div>
                <a href="<c:url value="/company/list-job-upload?id=${ttd.getMaNTD()}"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
            </div>
            <div class="row container d-flex justify-content-center">
                <div class="card">
                    <div class="card-body">
                        <h1 class="center">CHỈNH SỬA TIN TUYỂN DỤNG</h1>
                        <form:form action="${action}" method="post" modelAttribute="ttd">
                            <form:input hidden="true" path="maTTD" value="${ttd.maTTD}"/>
                            <div class="form-group row">
                                <div class="col">
                                    <label>Tiêu đề</label>
                                    <form:input type="text" path="tenTTD" class="form-control input-lg" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Ngày hết hạn</label>
                                    <form:input type="date" path="ngayKT" class="form-control input-lg"  autocomplete="off"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col">
                                    <label>Nơi làm việc</label>
                                    <form:input type="int" path="noiLamViec" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Trạng thái</label>
                                    <form:select class="form-control" path="trangThai">
                                            <option value="1">Kích hoạt</option>
                                            <option value="0">Chưa kích hoạt</option>
                                    </form:select>
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
                                    <form:input type="int" path="soLuong" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Kinh nghiệm</label>
                                    <form:input type="text" path="kinhNghiem" class="form-control" autocomplete="off"/>
                                </div>
                                <div class="col">
                                    <label>Lương</label>
                                    <form:input type="int" path="luong" class="form-control" autocomplete="off"/>
                                </div>
                            </div>
                            <div>
                                <label>Mô tả chi tiết</label>
                                <form:textarea type="text" path="moTaTTD" class="form-control input-lg" autocomplete="off"/>
                            </div>
                            <br>
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Sửa tin</button>
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
