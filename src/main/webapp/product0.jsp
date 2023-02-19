<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>${user.username},欢迎您</h1>

<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>产品名称</th>
        <th>数量</th>
        <th>品牌介绍</th>


    </tr>


    <c:forEach items="${products}" var="product" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${product.brandName}</td>
            <td>${product.name}</td>
            <td>${product.count}</td>
            <td>${product.description}</td>

        </tr>

    </c:forEach>

</table>

</body>
</html>