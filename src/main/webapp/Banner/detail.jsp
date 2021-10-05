<%--
  Created by IntelliJ IDEA.
  User: Dang Hoa
  Date: 10/4/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Detail</title>
</head>
<body>
<h1>${messege}</h1>
<a href="/Banner">Show Banner list</a>
<h1>Detail product form</h1>
<form method="post">
    <div>
        <input type="text" name="id" value="${banner.id}" readonly>
    </div>
    <div>
        <input type="text" name="name" value="${banner.name}">
    </div>
    <div>
        <input type="text" name="image" value="${banner.image}">
    </div>
    <div>
        <input type="text" name="location" value="${banner.location}">
    </div>
    <div>
        <c:choose>
            <c:when test="${banner.status}">
                <input type="radio" name="status" value="1" checked>Hiện
                <input type="radio" name="status" value="0">Ẩn
            </c:when>
            <c:otherwise>
                <input type="radio" name="status" value="1" >Hiện
                <input type="radio" name="status" value="0" checked>Ẩn
            </c:otherwise>
        </c:choose>
    </div>
    <button>update</button>
</form>
</body>
</html>
