<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My CMS</title>
    <meta charset=UTF-8" />
    <script type="text/javascript">
        window.addEventListener("DOMContentLoaded", function () {
            document.querySelector('.container').innerHTML = '${content}';
        });
    </script>
</head>
<body>
    <h1>
        <c:out value="${title}" />
    </h1>
    <div class="container">
    </div>
    <h6>
        <c:out value="${publicationDate}" />
    </h6>
</body>
</html>
