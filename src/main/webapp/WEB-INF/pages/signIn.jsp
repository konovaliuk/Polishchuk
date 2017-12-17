<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Link</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
    <div class="box">
        <h2>Sign in</h2>
        <form action="signInSite" method="post">
            <div class="inputBox">
                <input type="text" name="username" required="">
                <label>Username</label>
            </div>
            <div class="inputBox">
                <input  type="password" name="password" required="">
                <label>Password</label>
            </div>
            <input type="button" name="registration" value="Registration">
            <input type="submit" name="submit" value="Submit">
           <%-- <div class="inputBox">
                <label for="usernameInp">Username</label>
                <input id="usernameInp" type="text" name="" required="">
            </div>
            <div class="inputBox">
                <label for="passwordInp">Password</label>
                <input id="passwordInp" type="text" name="" required="">
            </div>
            <input type="button" name="registration" value="Registration">
            <input type="submit" name="submit" value="Submit">--%>
        </form>
    </div>
</body>
</html>
