<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>删除</title>
</head>
<body>
<h3>删除产品</h3>
<form action="/login-demo/deleteByIdServlet" method="post">

    <input type="hidden" name="id" value="${product.id}"><br>
    <h1>确定要删除${product.id}产品吗？</h1>

    <td><a href="/login-demo/deleteServlet?id=${product.id}">确定</a> <a href="/login-demo/selectAllServlet">取消</a></td>
</form>
</body>
</html>