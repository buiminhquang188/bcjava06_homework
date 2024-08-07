<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
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
                    <h4 class="page-title">Danh sách thành viên</h4>
                </div>
                <c:if test="${fn:contains(sessionScope.roleDetailDTO.actionCode, 'VIEW_CREATE_MEMBER')}">
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href="user-add" class="btn btn-sm btn-success">Thêm mới</a>
                    </div>
                </c:if>
                <!-- /.col-lg-12 -->
            </div>
            <div class="alert alert-danger hidden" role="alert">
                <strong>Ôi không!</strong> Bạn không thể xóa người này.
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
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Role</th>
                                    <th>#</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users}" var="user" varStatus="userStatus">
                                    <tr>
                                        <td>${userStatus.index + 1}</td>
                                        <td>${user.firstName}</td>
                                        <td>${user.lastName}</td>
                                        <td>${user.username}</td>
                                        <td>${user.role.name}</td>
                                        <td>
                                            <a href="#" class="btn-xoa btn btn-sm btn-danger"
                                               data-id="${user.id}">Xóa</a>
                                            <a href="user-details/${user.id}" class="btn btn-sm btn-info">Xem</a>
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
<script src="js/user-table.js"></script>
</body>

</html>