<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h4 class="page-title">Thêm mới quyền</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form class="form-horizontal form-material" method="POST" action="role-add">
                            <div class="form-group">
                                <label class="col-md-12">Tên quyền</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.name == null}">
                                            <input
                                                    type="text"
                                                    name="name"
                                                    value="${name}"
                                                    placeholder="Tên quyền"
                                                    class="form-control form-control-line"
                                            />
                                        </c:when>
                                        <c:when test="${errors.name != null}">
                                            <input
                                                    type="text"
                                                    name="name"
                                                    placeholder="Tên quyền"
                                                    class="form-control form-control-line"
                                            />
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.name != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.name}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Mô tả</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.description == null}">
                                            <input
                                                    type="text"
                                                    name="description"
                                                    value="${description}"
                                                    placeholder="Mô tả"
                                                    class="form-control form-control-line"
                                            />
                                        </c:when>
                                        <c:when test="${errors.description != null}">
                                            <input
                                                    type="text"
                                                    name="description"
                                                    placeholder="Mô tả"
                                                    class="form-control form-control-line"
                                            />
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.description != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.description}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-success">Add Role</button>
                                    <a href="role-table" class="btn btn-primary">Quay lại</a>
                                </div>
                            </div>
                        </form>
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