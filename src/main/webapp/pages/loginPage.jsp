<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Link</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signIn.css"/>

</head>
<body>
<div class="box">
    <h2>Sign in</h2>
    <form action="#">
        <div class="inputBox">
            <input type="text" name="" required="">
            <label>Username</label>
        </div>
        <div class="inputBox">
            <input type="text" name="" required="">
            <label>Password</label>
        </div>
        <input type="submit" name="registration" value="Registration">
        <input type="submit" name="submit" value="Submit">
    </form>
</div>
</body>
</html>