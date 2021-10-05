<%--
  Created by IntelliJ IDEA.
  User: Dang Hoa
  Date: 10/4/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>${message}</h1>
<a href="/Banner">Show Banner list</a>
<h1>Create product form</h1>
<form method="post">
    <div>
        <input type="text" name="name">
    </div>
    <div>
        <input type="text" name="image">
    </div>
    <div>
        <input type="text" name="location">
    </div>
    <div>
        <input type="radio" name="status" value="1">Hiện
        <input type="radio" name="status" value="0">Ẩn
    </div>
    <button>Create</button>
</form>
</body>
</html>
