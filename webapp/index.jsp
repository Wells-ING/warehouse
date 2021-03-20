<%--
  Created by IntelliJ IDEA.
  User: wells
  Date: 2021/1/21
  Time: 10:57 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <%
        String path = request.getContextPath();
    %>
<%-- 转换至登陆界面 --%>
    <script>
        window.location.href= '<%=path%>/html/login.html';
    </script>
</body>
</html>
