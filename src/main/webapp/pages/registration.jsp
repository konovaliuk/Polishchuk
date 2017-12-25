
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signIn.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registration.css" type="text/css">
</head>
<body>
<div class="box">
    <h2>Registration</h2>
    <form action="#">
        <div class="inputWrap">
            <div class="inputWrap__element">
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="" required="">
                    <label>Password</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="" required="">
                    <label>Password again</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>First name</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>Second name</label>
                </div>
            </div>
            <div class="inputWrap__element">
                <div class="inputBox">
                    <input type="email" name="" required="">
                    <label>E-mail</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>Adress</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>City</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>Phone</label>
                </div>
            </div>
        </div>
        <div class="regInput">
            <input type="submit" name="registration" value="Registration">
        </div>
    </form>
</div>
</body>
</html>
