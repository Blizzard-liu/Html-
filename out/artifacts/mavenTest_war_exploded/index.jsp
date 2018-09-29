<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<img src="2304-106.jpg" width="500px" alt="加载出错！">
<p>
<form action="index.jsp" method="get">
    用户名：<input type="text" placeholder="请输入用户名"><br>
    密码：<input type="password"><br>
    性别：<input type="radio" name="sex"> 男
    <input type="radio" name="sex"> 女<br>
    爱好：<input type="checkbox"> 抽烟 <input type="checkbox"> 喝酒 <input type="checkbox"> 泡妞 <br>
    介绍：<textarea rows="10" cols="50" placeholder="请输入">  </textarea><br>
    籍贯：<select>
    <option>--请选择--</option>
    <option>地球</option>
    <option>火星</option>
</select>
    <br>
    文件：<input type="file"> <br>
    <input type="button" value="按钮"> <br>
    <input type="reset" value="重置"> <br>
    <input type="submit" value="提交">
</form>

</p>




<hr/>

<font size="7" color="red">哈哈</font> <br>
<strong>加粗</strong><br>
<em>斜体</em><br>

<%--无序列表--%>
<ul>
    <%--a 超链接标签--%>
    <li><a href="index.jsp" target="_blank">111111111111111111111</a></li>
    <li><a href="index.jsp" target="_self">222222222222</a></li>
    <li><a href="index.jsp">333333333333333333</a></li>
    <li><a href="index.jsp">444444444444444</a></li>

</ul>

<hr/>

<%--无序列表--%>
<ol type="a" start="2">
    <li><a href="#">aaaaaaaaaaaaaaaaaa</a></li>
    <li><a>bbbbbbbbbbbb</a></li>
    <li><a>ccccccccccc</a></li>
    <li><a>ddddddddddd</a></li>
</ol>

<hr/>

<table bgcolor="aqua" width="400" border="1" align="center">
    <tr bgcolor="#faebd7" align="center">
        <td colspan="2">6</td>
        <td>6</td>
        <td>6</td>
    </tr>

    <tr>
        <td>6</td>
        <%--表格嵌套--%>
        <td bgcolor="#dc143c" align="center" colspan="2" rowspan="2">
            <table border="1" width="100%">
                <tr>
                    <td>1</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                </tr>
            </table>
        </td>
        <td>6</td>
    </tr>

    <tr>
        <td rowspan="2">6</td>
        <td>6</td>
    </tr>

    <tr align="right">
        <td>6</td>
        <td>6</td>
        <td>6</td>
    </tr>
</table>

</body>
</html>
