<%--
  Created by IntelliJ IDEA.
  User: tanke
  Date: 18.02.2021
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book JDBC Example</title>
</head>
<body>

<h1>My CMS</h1>
<h5>Лучшая CMS в мире!!!!</h5>

<a href="${s:mvcUrl('DC#articleGenerator').build()}">Сгенерировать статью</a>

<c:forEach var="article" items="${articles}">
    <h1>${article.title}</h1>
</c:forEach>

</body>
</html>
