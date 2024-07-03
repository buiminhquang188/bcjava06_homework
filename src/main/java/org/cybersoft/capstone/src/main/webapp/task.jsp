<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <h4 class="page-title">Danh sách công việc</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="task-add" class="btn btn-sm btn-success">Thêm mới</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
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
                                    <th>Người Thực Hiện</th>
                                    <th>Ngày Bắt Đầu</th>
                                    <th>Ngày Kết Thúc</th>
                                    <th>Trạng Thái</th>
                                    <th>Hành Động</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tasks}" var="task">
                                    <tr>
                                        <td>${task.id}</td>
                                        <td>${task.name}</td>
                                        <td>${task.project.name}</td>
                                        <td>${task.user.firstName} ${task.user.lastName}</td>
                                        <td>
                                            <fmt:formatDate
                                                    pattern="yyyy-MM-dd"
                                                    value="${task.startDate}"
                                            />
                                        </td>
                                        <td>
                                            <fmt:formatDate
                                                    pattern="yyyy-MM-dd"
                                                    value="${task.endDate}"
                                            />
                                        </td>
                                        <td>${task.status.name}</td>
                                        <td>
                                            <a href="task/${task.id}" class="btn btn-sm btn-primary">Sửa</a>
                                            <a href="#" data-id="${task.id}"
                                               class="btn btn-xoa btn-sm btn-danger">Xóa</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
        <jsp:include page="fragments/footer.jsp"/>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="fragments/script.jsp"/>
<script src="js/task-table.js"></script>
</body>

</html>