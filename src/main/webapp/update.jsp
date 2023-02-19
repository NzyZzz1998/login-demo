<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/login-demo/updateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${product.id}"><br>

    品牌名称：<input name="brandName" value="${product.brandName}"><br>
    产品名称：<input name="name" value="${product.name}"><br>
    数量：<input name="count" value="${product.count}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${product.description} </textarea><br>
    状态：
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1">启用<br>


    <input type="submit" value="提交">
</form>
</body>
</html>