<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/2/2023
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/" method="post">
    <input type="number" value="${number1}" name="number1">
    <input type="number" value="${number2}" name="number2">
    <button value="addition" name="condition">Addition(+)</button>
    <button value="suptraction" name="condition">Suptraction(-)</button>
    <button value="sutiplication" name="condition">Mutiplication(x)</button>
    <button value="sivition" name="condition">Divition(:)</button>
    <h3>Result: ${resutl}</h3>

</form>
</body>
</html>
