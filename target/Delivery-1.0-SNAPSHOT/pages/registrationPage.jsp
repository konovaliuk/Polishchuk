<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    <%--<link rel="stylesheet" type="text/css" href="../css/mainPolik.css" >--%>
    <link rel="stylesheet" type="text/css" href="../css/registrationF.css">
</head>
<body>
<%--REGISTRATION--%>
    <section id="registrrationForm" class="registrationForm">
        <div class="box">
            <h2>Registration</h2>
            <form action="con" method="post" name="registrationForm">
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
                            <label>Address</label>
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
                    <a href="/">На головну</a>
                    <%--<button type="submit" class="btn btn-success btn-block" &lt;%&ndash;name="sub" value="sub"&ndash;%&gt;>MySubmit</button>--%>
                    <input type="submit" value="Registration">
                    <input type="hidden" name="command" value="registration">
                </div>
            </form>
        </div>
    </section>
<%--/REGISTRATION--%>

</body>
</html>
