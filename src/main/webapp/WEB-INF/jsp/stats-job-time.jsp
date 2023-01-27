<%-- 
    Document   : stats-job-time
    Created on : Sep 5, 2022, 4:42:26 AM
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
                <div class="col-md-12"><h2>THỐNG KÊ TIN TUYỂN DỤNG THEO ThỜI GIAN</h2></div>
            </div>
            
            <form action="">
                <div class="form-group">
                    <label>Từ thời điểm</label>
                    <input type="date" name="tuNgay" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Đến</label>
                    <input type="date" name="denNgay" class="form-control"/>
                </div>
                <div class="form-group">
                <input type="submit" value="Thống kê" class="btn btn-primary btn-lg btn-block login-btn"/>
                </div>
            </form>
            
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
    };
</script>
