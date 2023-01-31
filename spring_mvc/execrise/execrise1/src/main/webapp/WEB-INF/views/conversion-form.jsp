<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/1/2023
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ</h1>
<form action="/convert" method="get" >
    <div class="col-2 ms-2" >
        <label >USD</label>
        <input type="number" name="usd" value="${usd}">
    </div>
    <div class="mt-2 col-2 ms-2">
        <label >Rate</label>
        <input type="number" name="rate" value="${rate}">
    </div>
    <div >
        <button type="submit">Convert</button>
    </div>

    <c:if test="${result!=null}">
        <p> VND:  <fmt:formatNumber type = "number"
                                    maxFractionDigits = "3" value = "${result}" /></p>
    </c:if>
</form>
</body>
</html>
