<%--
  Created by IntelliJ IDEA.
  User: quangbui
  Date: 04/08/2024
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                    <h4 class="page-title">Thêm mới thành viên</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form class="form-horizontal form-material" method="POST"
                              action="${pageContext.servletContext.contextPath}/profile-edit/${user.id}">
                            <div class="form-group">
                                <label class="col-md-12">First Name</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${firstName != null && user.firstName == null}">
                                            <input type="text"
                                                   name="firstName"
                                                   value="${firstName}"
                                                   placeholder="Enter you first name"
                                                   class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${firstName == null && user.firstName != null}">
                                            <input type="text"
                                                   name="firstName"
                                                   value="${user.firstName}"
                                                   placeholder="Enter you first name"
                                                   class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.firstName != null}">
                                            <input type="text"
                                                   name="firstName"
                                                   value="${user.firstName}"
                                                   placeholder="Enter you first name"
                                                   class="form-control form-control-line">
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.firstName != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.firstName}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Last Name</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${lastName != null && user.lastName == null}">
                                            <input type="text"
                                                   name="lastName"
                                                   value="${lastName}"
                                                   placeholder="Enter you last name"
                                                   class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${lastName == null && user.lastName != null}">
                                            <input type="text"
                                                   name="lastName"
                                                   value="${user.lastName}"
                                                   placeholder="Enter you last name"
                                                   class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.lastName != null}">
                                            <input type="text"
                                                   name="lastName"
                                                   value="${user.lastName}"
                                                   placeholder="Enter you last name"
                                                   class="form-control form-control-line">
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.lastName != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.lastName}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Password (Optional)</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.password == null}">
                                            <input type="password"
                                                   name="password"
                                                   value="${password}"
                                                   placeholder="Enter user password"
                                                   class="form-control form-control-line"
                                            >
                                        </c:when>
                                        <c:when test="${errors.password != null}">
                                            <input type="password"
                                                   name="password"
                                                   placeholder="Enter user password"
                                                   class="form-control form-control-line"
                                            >
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.password != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.password}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Phone No</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${phoneNumber != null && user.phoneNumber == null}">
                                            <input type="text"
                                                   name="phoneNumber"
                                                   value="${phoneNumber}"
                                                   placeholder="Enter user phone number"
                                                   class="form-control form-control-line"
                                            >
                                        </c:when>
                                        <c:when test="${phoneNumber == null && user.phoneNumber != null}">
                                            <input type="text"
                                                   name="phoneNumber"
                                                   value="${user.phoneNumber}"
                                                   placeholder="Enter user phone number"
                                                   class="form-control form-control-line"
                                            >
                                        </c:when>
                                        <c:when test="${errors.phoneNumber != null}">
                                            <input type="text"
                                                   name="phoneNumber"
                                                   value="${user.phoneNumber}"
                                                   placeholder="Enter user phone number"
                                                   class="form-control form-control-line"
                                            >
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.phoneNumber != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.phoneNumber}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-success">Cập nhật</button>
                                    <a href="user-table" class="btn btn-primary">Quay lại</a>
                                    <input type="hidden" name="_method" value="PUT">
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
<!-- jQuery -->
<script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.min.js"></script>
<script src="js/sidebar.js"></script>
</body>

</html>
