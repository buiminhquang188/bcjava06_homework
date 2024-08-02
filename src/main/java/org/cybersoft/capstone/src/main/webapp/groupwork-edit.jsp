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
                    <h4 class="page-title">Cập nhật dự án</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form id="groupwork-edit"
                              method="POST"
                              class="form-horizontal form-material"
                              action="${pageContext.request.contextPath}/groupwork/${project.id}">
                            <div class="form-group">
                                <label class="col-md-12">Tên dự án</label>
                                <div class="col-md-12">
                                    <input
                                            type="text"
                                            name="name"
                                            value="${project.name}"
                                            placeholder="Tên công việc"
                                            class="form-control form-control-line">
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
                                        <c:when test="${startDate != null}">
                                            <input
                                                    type="date"
                                                    name="startDate"
                                                    value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${startDate}"/>"
                                                    placeholder="dd/MM/yyyy"
                                                    class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.startDate == null && startDate == null}">
                                            <input
                                                    type="date"
                                                    name="startDate"
                                                    value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${project.startDate}"/>"
                                                    placeholder="dd/MM/yyyy"
                                                    class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.startDate != null}">
                                            <input
                                                    type="date"
                                                    name="startDate"
                                                    value=""
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
                                        <c:when test="${endDate != null}">
                                            <input
                                                    type="date"
                                                    name="endDate"
                                                    value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${endDate}"/>"
                                                    placeholder="dd/MM/yyyy"
                                                    class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.endDate == null && endDate == null}">
                                            <input
                                                    type="date"
                                                    name="endDate"
                                                    value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${project.endDate}"/>"
                                                    placeholder="dd/MM/yyyy"
                                                    class="form-control form-control-line">
                                        </c:when>
                                        <c:when test="${errors.endDate != null}">
                                            <input
                                                    type="date"
                                                    name="endDate"
                                                    value=""
                                                    placeholder="dd/MM/yyyy"
                                                    class="form-control form-control-line">
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${errors.endDate != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.endDate}
                                        </small>
                                    </c:if>
                                    <c:if test="${errors.rangeDate != null}">
                                        <small class="form-text text-danger mt-2">
                                                ${errors.rangeDate}
                                        </small>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Người quản lý dự án</label>
                                <div class="col-md-12">
                                    <c:choose>
                                        <c:when test="${errors.userIdProject == null && userIdProject == null && project.user.id == null}">
                                            <select name="userIdProject" class="form-control form-control-line">
                                                <option disabled selected>Chọn
                                                    người
                                                    thực
                                                    hiện
                                                </option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.id}">
                                                            ${user.firstName} ${user.lastName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:when test="${errors.userIdProject == null && userIdProject == null && project.user.id != null}">
                                            <select name="userIdProject" class="form-control form-control-line">
                                                <option disabled ${project.user.id == null ? "selected" : null}>Chọn
                                                    người
                                                    thực
                                                    hiện
                                                </option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.id}" ${user.id == project.user.id ? "selected" : null}>
                                                            ${user.firstName} ${user.lastName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:when test="${errors.userIdProject == null && userIdProject != null && project.user.id == null}">
                                            <select name="userIdProject" class="form-control form-control-line">
                                                <option disabled>Chọn người
                                                    thực
                                                    hiện
                                                </option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.id}" ${user.id == userIdProject ? "selected" : null}>
                                                            ${user.firstName} ${user.lastName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:when test="${errors.userIdProject == null && userIdProject != null && project.user.id != null}">
                                            <select name="userIdProject" class="form-control form-control-line">
                                                <option disabled>Chọn người
                                                    thực
                                                    hiện
                                                </option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.id}" ${user.id == userIdProject ? "selected" : null}>
                                                            ${user.firstName} ${user.lastName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:when test="${errors.userIdProject != null}">
                                            <select name="userIdProject" class="form-control form-control-line">
                                                <option disabled selected>Chọn người
                                                    thực
                                                    hiện
                                                </option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.id}">
                                                            ${user.firstName} ${user.lastName}
                                                    </option>
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
                                    <button type="submit" class="btn btn-success">Chỉnh sửa
                                    </button>
                                    <a href="${pageContext.servletContext.contextPath}/groupwork"
                                       class="btn btn-primary">Quay lại</a>
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
<jsp:include page="fragments/script.jsp"/>
</body>
</html>