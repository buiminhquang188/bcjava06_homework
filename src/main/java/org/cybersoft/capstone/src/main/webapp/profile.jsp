<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
    <c:when test="${profileStat.notStarted == 0 && profileStat.total == 0}">
        <c:set var="notStarted" value="0" scope="session"/>
    </c:when>
    <c:when test="${profileStat.notStarted != 0 && profileStat.total != 0}">
        <c:set var="notStarted" value="${(profileStat.notStarted / profileStat.total) * 100}" scope="session"/>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${profileStat.inProgress == 0 && profileStat.total == 0}">
        <c:set var="inProgress" value="0" scope="session"/>
    </c:when>
    <c:when test="${profileStat.inProgress != 0 && profileStat.total != 0}">
        <c:set var="inProgress" value="${(profileStat.inProgress / profileStat.total) * 100}" scope="session"/>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${profileStat.completed == 0 && profileStat.total == 0}">
        <c:set var="completed" value="0" scope="session"/>
    </c:when>
    <c:when test="${profileStat.completed != 0 && profileStat.total != 0}">
        <c:set var="completed" value="${(profileStat.completed / profileStat.total) * 100}" scope="session"/>
    </c:when>
</c:choose>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <jsp:include page="fragments/plugin.jsp"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<div id="wrapper">
    <!-- Navigation -->
    <jsp:include page="fragments/navbar.jsp"/>
    <!-- Left navbar-header -->
    <jsp:include page="fragments/sidebar.jsp"/>
    <!-- Left navbar-header end -->
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Chi tiết thành viên</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <div class="white-box">
                        <div class="user-bg">
                            <img width="100%" alt="user" src="plugins/images/large/img1.jpg">
                            <div class="overlay-box">
                                <div class="user-content">
                                    <a href="javascript:void(0)"><img
                                            src="https://joesch.moe/api/v1/${sessionScope.userId}"
                                            class="thumb-lg img-circle" alt="img"></a>
                                    <h4 class="text-white">${profile.user.firstName} ${profile.user.lastName}</h4>
                                    <h5 class="text-white">${profile.user.username}</h5>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-8 col-xs-12">
                    <!-- BEGIN THỐNG KÊ -->
                    <div class="row">
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-xs-12">
                                        <h3 class="counter text-right m-t-15 text-danger">
                                            <fmt:formatNumber type="number"
                                                              maxFractionDigits="2"
                                                              value="${notStarted}"/>%
                                        </h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i data-icon="E" class="linea-icon linea-basic"></i>
                                        <h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-danger" role="progressbar"
                                                 aria-valuenow="${notStarted}"
                                                 aria-valuemin="0"
                                                 aria-valuemax="100"
                                                 style="width: ${notStarted}%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-xs-12">
                                        <h3 class="counter text-right m-t-15 text-megna">
                                            <fmt:formatNumber type="number"
                                                              maxFractionDigits="2"
                                                              value="${inProgress}"/>%
                                        </h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
                                        <h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-megna" role="progressbar"
                                                 aria-valuenow="${inProgress}"
                                                 aria-valuemin="0" aria-valuemax="100"
                                                 style="width: ${inProgress}%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-xs-12">
                                        <h3 class="counter text-right m-t-15 text-primary">
                                            <fmt:formatNumber type="number"
                                                              maxFractionDigits="2"
                                                              value="${completed}"/>%
                                        </h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
                                        <h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-primary" role="progressbar"
                                                 aria-valuenow="${completed}"
                                                 aria-valuemin="0" aria-valuemax="100"
                                                 style="width: ${completed}%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- END THỐNG KÊ -->

                </div>
            </div>
            <br/>
            <!-- /.row -->
            <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
            <h4>DANH SÁCH CÔNG VIỆC</h4>
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <table class="table" id="example">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên Công Việc</th>
                                    <th>Dự Án</th>
                                    <th>Ngày Bắt Đầu</th>
                                    <th>Ngày Kết Thúc</th>
                                    <th>Trạng Thái</th>
                                    <th>Hành Động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="task" items="${profile.tasks}">
                                    <tr>
                                        <td>${task.id}</td>
                                        <td>${task.name}</td>
                                        <td>${task.project.name}</td>
                                        <td>
                                            <fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.startDate}"/>
                                        </td>
                                        <td>
                                            <fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.endDate}"/>
                                        </td>
                                        <td>${task.status.name}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/task/${task.id}"
                                               class="btn btn-sm btn-primary">Cập nhật</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END DANH SÁCH CÔNG VIỆC -->
        </div>
        <!-- /.container-fluid -->
        <footer class="footer text-center"> 2018 &copy; myclass.com</footer>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="fragments/script.jsp"/>
<script src="js/jquery.dataTables.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
</body>
</html>