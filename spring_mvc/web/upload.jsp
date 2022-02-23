<%--
  Created by IntelliJ IDEA.
  User: 14450
  Date: 2021-12-14
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
    mingcheng<input type="text" name="username"><br/>
    filename<input type="file" name="uploadFile"><br/>
    filename<input type="file" name="uploadFile2"><br/>
    <input type="submit" name="tijiao">
</form>

</body>
</html>
