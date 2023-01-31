<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/1/2023
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Translate</h2>
<form action="/translate" method="post">
    Input word <input type="text" name="word" value="${word}">
    <button>Translate</button>
</form>
<c:if test="${word!=null}">
    <p><span style="color: red">${word}</span> : ${result}</p>
</c:if>

</body>
</body>
</html>
