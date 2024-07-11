<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" scope="session" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <jsp:include page="fragments/plugin.jsp"/>
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
                    <h4 class="page-title">Chi tiết dự án</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                    <ol class="breadcrumb">
                        <li><a href="#">Dashboard</a></li>
                        <li class="active">Blank Page</li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- BEGIN THỐNG KÊ -->
            <div class="row">
                <!--col -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="white-box">
                        <div class="col-in row">
                            <div class="col-md-6 col-sm-6 col-xs-6"><i data-icon="E"
                                                                       class="linea-icon linea-basic"></i>
                                <h5 class="text-muted vb">CHƯA BẮT ĐẦU</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-danger">
                                    ${(projectStat.notStarted / projectStat.total) * 100}%
                                </h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-danger" role="progressbar"
                                         aria-valuenow="${(projectStat.notStarted / projectStat.total) * 100}"
                                         aria-valuemin="0" aria-valuemax="100"
                                         style="width: ${(projectStat.notStarted / projectStat.total) * 100}%">
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
                            <div class="col-md-6 col-sm-6 col-xs-6"><i class="linea-icon linea-basic"
                                                                       data-icon="&#xe01b;"></i>
                                <h5 class="text-muted vb">ĐANG THỰC HIỆN</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-megna">
                                    ${(projectStat.inProgress / projectStat.total) * 100}%
                                </h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-megna" role="progressbar"
                                         aria-valuenow="${(projectStat.inProgress / projectStat.total) * 100}"
                                         aria-valuemin="0" aria-valuemax="100"
                                         style="width: ${(projectStat.inProgress / projectStat.total) * 100}%">
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
                            <div class="col-md-6 col-sm-6 col-xs-6"><i class="linea-icon linea-basic"
                                                                       data-icon="&#xe00b;"></i>
                                <h5 class="text-muted vb">HOÀN THÀNH</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-primary">
                                    ${(projectStat.completed / projectStat.total) * 100}%</h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-primary" role="progressbar"
                                         aria-valuenow="${(projectStat.completed / projectStat.total) * 100}"
                                         aria-valuemin="0" aria-valuemax="100"
                                         style="width: ${(projectStat.completed / projectStat.total) * 100}%">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- END THỐNG KÊ -->

            <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
            <c:forEach var="project" items="${project}" varStatus="projectStatus">
                <div class="row">
                    <div class="col-xs-12">
                        <a href="#" class="group-title">
                            <img width="30" src="https://joesch.moe/api/v1/${projectStatus.index}" class="img-circle"/>
                            <span>${project.user.firstName} ${project.user.lastName}</span>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                            <h3 class="box-title">Chưa thực hiện</h3>
                            <div class="message-center">
                                <c:forEach var="task" items="${project.tasks}">
                                    <c:choose>
                                        <c:when test="${task.status.id == 3}">
                                            <a href="#">
                                                <div class="mail-contnet">
                                                    <h5>${project.user.firstName} ${project.user.lastName}</h5> <span
                                                        class="mail-desc">${task.name}</span>
                                                    <span class="time">
                                                <fmt:formatDate pattern="yyyy-MM-dd"
                                                                value="${task.startDate}"/> - <fmt:formatDate
                                                            pattern="yyyy-MM-dd"
                                                            value="${task.endDate}"/>
                                            </span>
                                                </div>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            Không có dữ liệu
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                            <h3 class="box-title">Đang thực hiện</h3>
                            <div class="message-center">
                                <c:forEach var="task" items="${project.tasks}">
                                    <c:choose>
                                        <c:when test="${task.status.id == 2}">
                                            <a href="#">
                                                <div class="mail-contnet">
                                                    <h5>${project.user.firstName} ${project.user.lastName}</h5> <span
                                                        class="mail-desc">${task.name}</span>
                                                    <span class="time">
                                                <fmt:formatDate pattern="yyyy-MM-dd"
                                                                value="${task.startDate}"/> - <fmt:formatDate
                                                            pattern="yyyy-MM-dd"
                                                            value="${task.endDate}"/>
                                            </span>
                                                </div>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            Không có dữ liệu
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="white-box">
                            <h3 class="box-title">Đã hoàn thành</h3>
                            <div class="message-center">
                                <c:forEach var="task" items="${project.tasks}">
                                    <c:choose>
                                        <c:when test="${task.status.id == 1}">
                                            <a href="#">
                                                <div class="mail-contnet">
                                                    <h5>${project.user.firstName} ${project.user.lastName}</h5> <span
                                                        class="mail-desc">${task.name}</span>
                                                    <span class="time">
                                                <fmt:formatDate pattern="yyyy-MM-dd"
                                                                value="${task.startDate}"/> - <fmt:formatDate
                                                            pattern="yyyy-MM-dd"
                                                            value="${task.endDate}"/>
                                            </span>
                                                </div>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            Không có dữ liệu
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <!-- END DANH SÁCH CÔNG VIỆC -->
        </div>
        <!-- /.container-fluid -->
        <footer class="footer text-center"> 2018 &copy; myclass.com</footer>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="fragments/script.jsp"/>
</body>

</html>