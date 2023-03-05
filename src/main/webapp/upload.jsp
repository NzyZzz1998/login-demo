<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>文件上传</title>
</head>

<body>
<form action="/login-demo/uploadServlet" method="post" enctype="multipart/form-data" >

        上传用户：<input type="text" value="${user.username}"><br/>
        上传文件1：<input type="file" name="file1"><br/>
        <input type="submit" value="提交">

</form>

</form>
</body>
</html>
