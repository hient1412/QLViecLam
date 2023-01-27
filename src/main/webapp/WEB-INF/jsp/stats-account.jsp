<%-- 
    Document   : stats-account
    Created on : Sep 5, 2022, 12:24:50 AM
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
                <div class="col-md-12"><h2>THỐNG KÊ LOẠI TÀI KHOẢN</h2></div>
            </div>
            <div class="row">
                <div class="col-5"> 
                    <br>
                    <table class="table table-bordered center">
                        <thead>
                            <tr>
                                <th>Loại tài khoản</th>
                                <th>Số lượng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${statsTK}" var="tk">
                                <tr>
                                    <td>${tk[0]}</td>
                                    <td>${tk[1]}</td>
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

    <c:forEach items="${statsTK}" var="tk">
        data.push('${tk[0]}');
        label.push(${tk[1]});
    </c:forEach>
        
        statsTK(data,label);
    }
</script>