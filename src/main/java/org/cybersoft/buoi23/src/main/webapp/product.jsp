<%--
  Created by IntelliJ IDEA.
  User: quangbui
  Date: 11/06/2024
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid my-5">
    <div class="mb-3">
        <span class="h1">Quản Lý Sản Phẩm</span>
    </div>
    <div class="card p-3">
        <div class="card-body p-0">
            <form action="product" method="POST" class="vstack gap-3 w-50">
                <div>
                    <label for="product-name" class="form-label">Tên Sản Phẩm</label>
                    <input type="text" name="product-name" class="form-control" id="product-name"
                           aria-describedby="basic-addon3 basic-addon4">
                </div>
                <div>
                    <label for="product-quantity" class="form-label">Số Lượng</label>
                    <input type="number" name="product-quantity" class="form-control" id="product-quantity"
                           aria-describedby="basic-addon3 basic-addon4">
                </div>
                <div>
                    <label for="product-price" class="form-label">Giá bán</label>
                    <input type="number" min="1" step="any" name="product-price" class="form-control" id="product-price"
                           aria-describedby="basic-addon3 basic-addon4">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Lưu lại</button>
                </div>
            </form>
            <div class="table-responsive mt-3">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col" class="p-3">STT</th>
                        <th scope="col" class="p-3">Tên Sản Phẩm</th>
                        <th scope="col" class="p-3">Số Lượng</th>
                        <th scope="col" class="p-3">Giá Bán</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${products}" varStatus="productIndex">
                        <tr>
                            <td class="p-3" scope="row">
                                <c:out value="${productIndex.index + 1}"/>
                            </td>
                            <td class="p-3">
                                <c:out value="${product.getName()}"/>
                            </td>
                            <td class="p-3">
                                <c:out value="${product.getQuantity()}"/>
                            </td>
                            <td class="p-3">
                                <fmt:setLocale value="vi_VN"/>
                                <fmt:formatNumber value="${product.getPrice()}"
                                                  type="currency"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
