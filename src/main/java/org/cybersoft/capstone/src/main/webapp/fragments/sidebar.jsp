<%--
  Created by IntelliJ IDEA.
  User: quangbui
  Date: 02/07/2024
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse slimscrollsidebar">
        <ul class="nav" id="side-menu">
            <c:if test="${fn:contains(sessionScope.roleDetailDTO.actionCode, 'VIEW_STATISTIC')}">
                <li style="padding: 10px 0 0;">
                    <a href="${pageContext.servletContext.contextPath}" class="waves-effect"><i
                            class="fa fa-clock-o fa-fw"
                            aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                </li>
            </c:if>
            <c:if test="${fn:contains(sessionScope.roleDetailDTO.actionCode, 'VIEW_ROLES')}">
                <li>
                    <a href="${pageContext.request.contextPath}/role-table" class="waves-effect"><i
                            class="fa fa-modx fa-fw"
                            aria-hidden="true"></i><span
                            class="hide-menu">Quyền</span></a>
                </li>
            </c:if>
            <c:if test="${fn:contains(sessionScope.roleDetailDTO.actionCode, 'VIEW_PROJECTS')}">
                <li>
                    <a href="${pageContext.request.contextPath}/groupwork" class="waves-effect"><i
                            class="fa fa-table fa-fw"
                            aria-hidden="true"></i><span
                            class="hide-menu">Dự án</span></a>
                </li>
            </c:if>
            <c:if test="${fn:contains(sessionScope.roleDetailDTO.actionCode, 'VIEW_TASKS')}">
                <li>
                    <a href="${pageContext.request.contextPath}/task" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                                              aria-hidden="true"></i><span
                            class="hide-menu">Công việc</span></a>
                </li>
            </c:if>
        </ul>
    </div>
</div>