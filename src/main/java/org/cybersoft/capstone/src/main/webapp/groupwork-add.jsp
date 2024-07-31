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
                    <h4 class="page-title">Thêm mới dự án</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form class="form-horizontal form-material" method="POST" action="groupwork-add">
                            <div class="form-group">
                                <label class="col-md-12">Tên dự án</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.name == null}">
                                            <input type="text"
                                                   name="name"
                                                   value="${name}"
                                                   placeholder="Tên dự án"
                                                   class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.name != null}">
                                            <input type="text"
                                                   name="name"
                                                   placeholder="Tên dự án"
                                                   class="form-control form-control-line">
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
                                <label class="col-md-12">Ngày bắt đầu</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.startDate == null}">
                                            <input type="date"
                                                   name="startDate"
                                                   value="${startDate}"
                                                   placeholder="dd/MM/yyyy"
                                                   class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.startDate != null}">
                                            <input type="date"
                                                   name="startDate"
                                                   placeholder="dd/MM/yyyy"
                                                   class="form-control form-control-line">
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.startDate != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.startDate}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Ngày kết thúc</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.endDate == null}">
                                            <input type="date"
                                                   name="endDate"
                                                   value="${endDate}"
                                                   placeholder="dd/MM/yyyy"
                                                   class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.endDate != null}">
                                            <input type="date"
                                                   name="endDate"
                                                   placeholder="dd/MM/yyyy"
                                                   class="form-control form-control-line">
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.endDate != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.endDate}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Người quản lý</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.userIdProject == null}">
                                            <select name="userIdProject" class="form-control form-control-line">
                                                <option disabled ${userIdProject == null ? "selected" : null}>Chọn người
                                                    quản lý
                                                </option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.id}" ${user.id == userIdProject ? "selected" : null}>${user.firstName} ${user.lastName}</option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:when test="${errors.userIdProject != null}">
                                            <select name="userIdProject" class="form-control form-control-line">
                                                <option disabled selected>Chọn người quản lý dự án</option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.id}">${user.firstName} ${user.lastName}</option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.userIdProject != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.userIdProject}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-success">Lưu lại</button>
                                    <a href="${pageContext.servletContext.contextPath}/groupwork"
                                       class="btn btn-primary">Quay lại</a>
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