<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
                    <c:choose>
                        <c:when test="${fn:contains(roleDetail.actionCode, 'EDIT_PROGRESS_TASK')}">
                            <h4 class="page-title">Cập nhật tiến độ công việc - ${task.id}</h4>
                        </c:when>
                        <c:when test="${fn:contains(roleDetail.actionCode, 'EDIT_TASK')}">
                            <h4 class="page-title">Chỉnh sửa công việc - ${task.id}</h4>
                        </c:when>
                    </c:choose>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <c:choose>
                            <c:when test="${fn:contains(roleDetail.actionCode, 'EDIT_PROGRESS_TASK')}">
                                <jsp:include page="fragments/update-progress-task-form.jsp"/>
                            </c:when>
                            <c:when test="${fn:contains(roleDetail.actionCode, 'EDIT_TASK')}">
                                <jsp:include page="fragments/edit-task-form.jsp"/>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
                <div class="col-md-2 col-12"></div>
            </div>
            <!-- /.row -->
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