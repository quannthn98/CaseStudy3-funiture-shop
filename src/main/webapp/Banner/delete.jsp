<%--
  Created by IntelliJ IDEA.
  User: Dang Hoa
  Date: 10/4/2021
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>${messege}</h1>
<a href="/Banner">Show Banner list</a>
<h1>Delete product form</h1>
<form method="post">
    <div>
        <p>${banner.name}</p>
    </div>
    <div>
        <p>${banner.image}</p>
    </div>
    <div>
        <p>${banner.location}</p>
    </div>
    <div>
        <p>${banner.status}</p>
    </div>
    <button>Delete</button>
</form>
</body>
</html>
