<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Redirect to index page if logged--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row mt-5">
        <div class="col-md-5 m-auto mt-5">
            <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
            <div class="p-4 border mt-4">
                <form method="POST" action="login">
                    <div class="form-group mb-2">
                        <label>Email</label>
                        <c:choose>
                            <c:when test="${errors.username == null}">
                                <input type="email"
                                       class="form-control"
                                       name="username"
                                       value="${username}"
                                >
                            </c:when>
                            <c:when test="${errors.username != null}">
                                <input type="email"
                                       class="form-control"
                                       name="username"
                                >
                            </c:when>
                        </c:choose>
                        <c:if test="${errors.username != null}">
                            <small class="form-text text-danger mt-2">
                                Email is required
                            </small>
                        </c:if>
                    </div>
                    <div class="form-group mb-0">
                        <label>Mật khẩu</label>
                        <c:choose>
                            <c:when test="${errors.password == null}">
                                <input type="password"
                                       class="form-control"
                                       name="password"
                                       value="${password}"
                                >
                            </c:when>
                            <c:when test="${errors.password != null}">
                                <input type="password"
                                       class="form-control"
                                       name="password"
                                >
                            </c:when>
                        </c:choose>
                        <c:if test="${errors.password != null}">
                            <small class="form-text text-danger mt-2">
                                Password is required
                            </small>
                        </c:if>
                    </div>
                    <c:if test="${sessionScope.isValid == false}">
                        <small class="form-text text-danger mt-2">
                            Username or password not correct, please check again.
                        </small>
                    </c:if>
                    <button type="submit" class="btn btn-primary mt-2">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
