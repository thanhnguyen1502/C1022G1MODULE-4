<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2023
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="/update" method="get" modelAttribute="email">

    <div>
        <form:label for="language" path="language"><b>Languages:</b></form:label>
        <form:select id="language" path="language" items="${language}"></form:select>
    </div>
    <br>
    <div>
        <form:label for="pageSize" path="pageSize"><b>Page Size:</b></form:label>
        Show <form:select id="pageSize" path="pageSize" items="${pageSize}"></form:select> emails per page
    </div>
    <br>
    <div>
        <form:label for="spamsFilter" path="spamsFilter"><b>Spams Filter:</b></form:label>
        <form:checkbox id="spamsFilter" path="spamsFilter"></form:checkbox> Enable spams filter
    </div>
    <br>
    <div>
        <form:label for="signature" path="signature"><b>Signature:</b></form:label>
        <form:textarea id="signature" path="signature"></form:textarea>
    </div>
    <br>
    <div>
        <button type="submit">Update</button>
    </div>
</form:form>
</body>
</html>
