<%--
  Created by IntelliJ IDEA.
  User: rengu
  Date: 2018/10/14
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring Boot 集成 JSP 示例</title>
</head>
<body>
<h2>Welcome to spring-boot-jsp user page</h2>
<p>login user is ${login_user}</p>

<h2>用户列表</h2>
<table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.createTime}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
