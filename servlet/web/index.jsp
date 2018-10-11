<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/10
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" errorPage="ErrorPage.jsp" %>
<%--include 其他界面要和当前界面的contentType保持一致,否则报错--%>
<%@include file="OtherPager.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <hr>

  <c:set var="name" value="zhangsan" scope="session">
  </c:set>
  ${name}
  ${sessionScope.name}

    
<%@include file="OtherPager.jsp"%>
    <h2>你是谁?</h2>
  <%--<% int a = 10/0;%>--%>



  <%--<jsp:include page="OtherPager.jsp"></jsp:include>--%>

  <%--<jsp:forward page="OtherPager.jsp">--%>
    <%--<jsp:param name="address" value="合肥"/>--%>

  <%--</jsp:forward>--%>
    <%--等同于请求转发--%>
  <%--<% request.getRequestDispatcher("OtherPager.jsp").forward(request,response); %>--%>

    <%--九大内置对象  --%>
  <%
    application.setAttribute("haha", "application");//ServletContext  整个工程都可以访问,服务器关闭就不能访问了
    session.setAttribute("haha", "session");//HttpSession  作用于多次会话
    request.setAttribute("haha", "request");//HttpServletRequest  作用域 仅限一次请求,只要服务器对这个请求做出了响应,这个域中存在的值就没了

//    pageContext  作用域仅限当前界面
    //out  JspWriter
    //exception  Throwable
    //page   Object
    //config   ServletConfig
    //response  HttpServletResponse
  %>
  <hr>
  <%=application.getAttribute("haha")%>

  <hr>
  <%--EL表达式 用来取值 11个隐式对象--%>
  ${applicationScope.haha}
  ${sessionScope.haha}
  ${requestScope.haha}
  <%--${pageScope.haha}--%>

  <%--${pageContext.haha}--%>
  <hr>
  ${header}
  ${headerValues}
  <hr>
  ${param}
  ${paramValues}
  <hr>
  ${cookie}
  <hr>
  ${initParam}

  <hr>

  <%
    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("2");
    list.add("3");

    session.setAttribute("list",list);
  %>

  <c:forEach var="str" items="${list}" >
      ${str}
  </c:forEach>





  </body>
</html>
<%@include file="OtherPager.jsp"%>