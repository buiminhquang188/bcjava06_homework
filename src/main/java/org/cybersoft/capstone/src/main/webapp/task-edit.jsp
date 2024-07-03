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
                    <h4 class="page-title">Chỉnh sửa công việc - ${task.id}</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form method="POST"
                              action="${pageContext.request.contextPath}/task/${task.id}"
                              class="form-horizontal form-material">
                            <div class="form-group">
                                <label class="col-md-12">Dự án</label>
                                <div class="col-md-12">
                                    <select name="projectId" class="form-control form-control-line">
                                        <option disabled selected="${task.project.id == null}">Chọn dự án
                                        </option>
                                        <c:forEach items="${projects}" var="project">
                                            <option value="${project.id}"
                                                    selected="${task.project.id == project.id}">${project.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Tên công việc</label>
                                <div class="col-md-12">
                                    <input type="text"
                                           name="name"
                                           value="${task.name}"
                                           placeholder="Tên công việc"
                                           class="form-control form-control-line">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Người thực hiện</label>
                                <div class="col-md-12">
                                    <select name="userId" class="form-control form-control-line">
                                        <option disabled selected="${task.user.id == null}">Chọn người thực hiện
                                        </option>
                                        <c:forEach items="${users}" var="user">
                                            <option value="${user.id}"
                                                    selected="${task.user.id == user.id}">
                                                    ${user.firstName} ${user.lastName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Ngày bắt đầu</label>
                                <div class="col-md-12">
                                    <input type="date"
                                           name="startDate"
                                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.startDate}"/>"
                                           placeholder="dd/MM/yyyy"
                                           class="form-control form-control-line">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Ngày kết thúc</label>
                                <div class="col-md-12">
                                    <input type="date"
                                           name="endDate"
                                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.endDate}"/>"
                                           placeholder="dd/MM/yyyy"
                                           class="form-control form-control-line">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Trạng thái</label>
                                <div class="col-md-12">
                                    <select name="statusId" class="form-control form-control-line">
                                        <option disabled selected="${task.status.id == null}">Chọn trạng thái</option>
                                        <c:forEach items="${statuses}" var="status">
                                            <option value="${status.id}"
                                                    selected="${task.status.id == status.id}">
                                                    ${status.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-success">Lưu lại</button>
                                    <a href="task" class="btn btn-primary">Quay lại</a>
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
<jsp:include page="fragments/script.jsp"/>
</body>

</html>