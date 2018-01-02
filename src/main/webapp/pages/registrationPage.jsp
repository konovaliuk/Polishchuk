
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="/css/valerchik.css" type="text/css">
    <link rel="stylesheet" href="/css/registration.css" type="text/css">
</head>
<body>
<div class="box">
    <h2>Registration</h2>
    <form action="polik" method="post" name="registrationForm">
        <input type="hidden" name="command" value="registration">
        <div class="inputWrap">
            <div class="inputWrap__element">
                <div class="inputBox">
                    <input type="text" name="username" required="">
                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="password" required="">
                    <label>Password</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="password" required="">
                    <label>Password again</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="firstName" required="">
                    <label>First name</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="secondName" required="">
                    <label>Second name</label>
                </div>
            </div>
            <div class="inputWrap__element">
                <div class="inputBox">
                    <input type="email" name="email" required="">
                    <label>E-mail</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="address" required="">
                    <label>Adress</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="city" required="">
                    <label>City</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="phone" required="">
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
