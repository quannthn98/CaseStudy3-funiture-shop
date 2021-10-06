<%--
  Created by IntelliJ IDEA.
  User: quans
  Date: 10/6/21
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p id="userAlert"></p>
<input type="text" id="name" onchange="validation()">
<script type="text/javascript">
    function validation() {
        var username = document.getElementById("name").value;///get id with value
        var usernamepattern = /^[A-Za-z .]{3,15}$/;////Regular expression
        if (usernamepattern.test(username)) {
            // action if true
        } else {
            // action if false
        }
    }
</script>
</body>
</html>
