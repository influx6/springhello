<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: trino
  Date: 9/5/2020
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DocType html>
<html>
<head>
    <title>Login</title>
</head>
<body>
${errorMessage}
Welcome ${name} to the JSP world!
<form method="post" action="/login.do">
    Enter your name <input type="text" name="name" />
    Enter your password <input type="text" name="password" />
    <input type="submit"  value="Login"/>
</form>
</body>
</html>
