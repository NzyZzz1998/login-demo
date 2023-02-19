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

<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>产品名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${products}" var="product" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${product.brandName}</td>
            <td>${product.name}</td>
            <td>${product.count}</td>
            <td>${product.description}</td>
            <c:if test="${product.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${product.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/login-demo/selectByIdServlet?id=${product.id}">修改</a> <a href="/login-demo/deleteByIdServlet?id=${product.id}">删除</a></td>
        </tr>

    </c:forEach>

</table>

<script>
    document.getElementById("add").onclick = function (){
        location.href = "/login-demo/addProduct.jsp";
    }

</script>
</body>
</html>