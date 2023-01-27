<%-- 
    Document   : stats-job-type
    Created on : Sep 4, 2022, 11:29:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
    <div class="container">
        <div style="background-color: white" class="p-5">
            <div>
                <a href="<c:url value="/admin/stats"/>" class="btn btn-primary m-3"><i style="font-size:24px" class="fa">&#xf177;</i>  Quay lại</a>
            </div>
            <div class="center">
                <div class="col-md-12"><h2>THỐNG KÊ TIN TUYỂN DỤNG THEO LOẠI VIỆC LÀM</h2></div>
            </div>
            <div class="row">
                <div class="col-5"> 
                    <br>
                    <table class="table table-bordered center">
                        <thead>
                            <tr>
                                <th>Mã loại</th>
                                <th>Loại việc làm</th>
                                <th>Số lượng tin</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${statsLVL}" var="vl">
                                <tr>
                                    <td>${vl[0]}</td>
                                    <td>${vl[1]}</td>
                                    <td>${vl[2]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>
                <div class="col-7">
                    <canvas id="myChart"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script src="<c:url value="/js/stats.js"/>"></script>
<script>
    window.onload = function () {
        let data = [];
        let label = [];

    <c:forEach items="${statsLVL}" var="vl">
        data.push(${vl[2]});
        label.push('${vl[1]}');
    </c:forEach>
        
        statsVL(label,data);
    }
</script>