<%--
  Created by IntelliJ IDEA.
  User: quangbui
  Date: 30/07/2024
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<form method="POST"
      action="${pageContext.request.contextPath}/task/${task.id}"
      class="form-horizontal form-material">
    <div class="form-group">
        <label class="col-md-12">Dự án</label>
        <div class="col-md-12">
            <c:choose>
                <c:when test="${errors.projectId == null && projectId == null}">
                    <select name="projectId" class="form-control form-control-line">
                        <option disabled ${task.project.id == null ? "selected" : null}>Chọn dự
                            án
                        </option>
                        <c:forEach items="${projects}" var="project">
                            <option value="${project.id}" ${project.id == task.project.id ? "selected" : null}>${project.name}</option>
                        </c:forEach>
                    </select>
                </c:when>
                <c:when test="${errors.projectId == null && projectId != null}">
                    <select name="projectId" class="form-control form-control-line">
                        <option disabled>Chọn dự
                            án
                        </option>
                        <c:forEach items="${projects}" var="project">
                            <option value="${project.id}" ${project.id == task.project.id ? "selected" : null}>${project.name}</option>
                        </c:forEach>
                    </select>
                </c:when>
                <c:when test="${errors.projectId != null}">
                    <select name="projectId" class="form-control form-control-line">
                        <option disabled selected>Chọn dự
                            án
                        </option>
                        <c:forEach items="${projects}" var="project">
                            <option value="${project.id}">
                                    ${project.name}
                            </option>
                        </c:forEach>
                    </select>
                </c:when>
            </c:choose>
            <c:if test="${errors.projectId != null}">
                <small class="form-text text-danger mt-2">
                        ${errors.projectId}
                </small>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-12">Tên công việc</label>
        <div class="col-md-12">
            <c:choose>
                <c:when test="${errors.name == null && name == null}">
                    <input type="text"
                           name="name"
                           value="${task.name}"
                           placeholder="Tên công việc"
                           class="form-control form-control-line">
                </c:when>
                <c:when test="${errors.name == null && name != null}">
                    <input type="text"
                           name="name"
                           value="${name}"
                           placeholder="Tên công việc"
                           class="form-control form-control-line">
                </c:when>
                <c:when test="${errors.name != null}">
                    <input type="text"
                           name="name"
                           placeholder="Tên công việc"
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
        <label class="col-md-12">Người thực hiện</label>
        <div class="col-md-12">
            <c:choose>
                <c:when test="${errors.userIdTask == null && userIdTask == null}">
                    <select name="userIdTask" class="form-control form-control-line">
                        <option disabled ${task.user.id == null ? "selected" : null}>Chọn người
                            thực
                            hiện
                        </option>
                        <c:forEach items="${users}" var="user">
                            <option value="${user.id}" ${user.id == task.user.id ? "selected" : null}>
                                    ${user.firstName} ${user.lastName}
                            </option>
                        </c:forEach>
                    </select>
                </c:when>
                <c:when test="${errors.userIdTask == null && userIdTask != null}">
                    <select name="userIdTask" class="form-control form-control-line">
                        <option disabled>Chọn người
                            thực
                            hiện
                        </option>
                        <c:forEach items="${users}" var="user">
                            <option value="${user.id}" ${user.id == userIdTask ? "selected" : null}>
                                    ${user.firstName} ${user.lastName}
                            </option>
                        </c:forEach>
                    </select>
                </c:when>
                <c:when test="${errors.userIdTask != null}">
                    <select name="userIdTask" class="form-control form-control-line">
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
            <c:if test="${errors.userIdTask != null}">
                <small class="form-text text-danger mt-2">
                        ${errors.userIdTask}
                </small>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-12">Ngày bắt đầu</label>
        <div class="col-md-12">
            <c:choose>
                <c:when test="${errors.startDate == null && startDate == null}">
                    <input type="date"
                           name="startDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.startDate}"/>"
                           placeholder="dd/MM/yyyy"
                           class="form-control form-control-line">
                </c:when>
                <c:when test="${errors.startDate == null && startDate != null}">
                    <input type="date"
                           name="startDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${startDate}"/>"
                           placeholder="dd/MM/yyyy"
                           class="form-control form-control-line">
                </c:when>
                <c:when test="${errors.startDate != null}">
                    <input type="date"
                           name="startDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.startDate}"/>"
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
                <c:when test="${errors.endDate == null && endDate == null}">
                    <input type="date"
                           name="endDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.endDate}"/>"
                           placeholder="dd/MM/yyyy"
                           class="form-control form-control-line">
                </c:when>
                <c:when test="${errors.endDate == null && endDate != null}">
                    <input type="date"
                           name="endDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${endDate}"/>"
                           placeholder="dd/MM/yyyy"
                           class="form-control form-control-line">
                </c:when>
                <c:when test="${errors.endDate != null}">
                    <input type="date"
                           name="endDate"
                           value="<fmt:formatDate pattern="yyyy-MM-dd"
                                                            value="${task.endDate}"/>"
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
        <label class="col-md-12">Trạng thái</label>
        <div class="col-md-12">
            <c:choose>
                <c:when test="${errors.statusId == null && statusId == null}">
                    <select name="statusId" class="form-control form-control-line">
                        <option disabled ${task.status.id == null ? "selected" : null}>Chọn
                            trạng thái
                        </option>
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status.id}" ${task.status.id == status.id ? "selected" : null}>
                                    ${status.name}
                            </option>
                        </c:forEach>
                    </select>
                </c:when>
                <c:when test="${errors.statusId == null && statusId != null}">
                    <select name="statusId" class="form-control form-control-line">
                        <option disabled ${statusId == null ? "selected" : null}>Chọn
                            trạng thái
                        </option>
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status.id}" ${status.id == statusId ? "selected" : null}>
                                    ${status.name}
                            </option>
                        </c:forEach>
                    </select>
                </c:when>
                <c:when test="${errors.statusId != null}">
                    <select name="statusId" class="form-control form-control-line">
                        <option disabled selected>Chọn
                            trạng thái
                        </option>
                        <c:forEach items="${statuses}" var="status">
                            <option value="${status.id}">
                                    ${status.name}
                            </option>
                        </c:forEach>
                    </select>
                </c:when>
            </c:choose>
            <c:if test="${errors.statusId != null}">
                <small class="form-text text-danger mt-2">
                        ${errors.statusId}
                </small>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-12">
            <button type="submit" class="btn btn-success">Lưu lại</button>
            <a href="${pageContext.servletContext.contextPath}/task" class="btn btn-primary">Quay
                lại</a>
            <input type="hidden" name="_method" value="PUT">
        </div>
    </div>
</form>