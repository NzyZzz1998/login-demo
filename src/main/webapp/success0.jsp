<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>成功后展示</title>
</head>
<body>
<h1>${user.username},欢迎您</h1>
<a href="/login-demo/selectAllServlet">查询所有产品</a>
</body>
</html>