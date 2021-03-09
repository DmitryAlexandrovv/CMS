<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>My CMS</title>
    <meta charset=UTF-8" />

    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

    <script>
        tinymce.init({
            selector: '#mytextarea'
        });
    </script>
</head>
<body>

<form action="article" method="post">
    <select name="parentId">
        <c:forEach var="article" items="${articles}">
            <option value="${article.id}">${article.title}</option>
        </c:forEach>
    </select>
    <input type="text" placeholder="Введите название статьи" name="title"/>
    <textarea id="mytextarea" name="content">
    </textarea>
    <input type="submit" value="Submit" />
</form>

</body>
</html>
