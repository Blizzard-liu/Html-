<%--
  Created by IntelliJ IDEA.
  User: liubo
  Date: 2018/10/11
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>我是其他界面的  哈哈</h1>

收到的参数:<br>
<% request.setCharacterEncoding("utf-8");%>
<%=request.getParameter("address")%>
</body>
</html>
