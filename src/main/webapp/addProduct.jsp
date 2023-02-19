<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加</title>
</head>
<body>
<h3>添加</h3>
<form action="/login-demo/addServlet" method="post">
    品牌名称：<input name="brandName"><br>
    产品名称：<input name="name"><br>
    数量：<input name="count"><br>
    描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
    状态：
    <input type="radio" name="status" value="0">禁用
    <input type="radio" name="status" value="1">启用<br>

    <input type="submit" value="提交">
</form>
</body>
</html>