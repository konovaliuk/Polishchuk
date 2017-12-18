
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registration.css">
</head>
<body>
<div class="box">
    <h2>Registration</h2>
    <form action="">
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
               <%-- <div class="inputBox">
                    <label for="usernameInp">Username</label>
                    <input id="usernameInp" type="text" name="" required="">
                </div>
                <div class="inputBox">
                    <label for="passwordInp">Password</label>
                    <input id="passwordInp" type="password" name="" required="">
                </div>
                <div class="inputBox">
                    <label for="passwordAgain">Password again</label>
                    <input id="passwordAgain" type="password" name="" required="">
                </div>
                <div class="inputBox">
                    <label for="firstNameInp">First name</label>
                    <input id="firstNameInp" type="text" name="" required="">
                </div>
                <div class="inputBox">
                    <label for="secondNameInp">Second name</label>
                    <input id="secondNameInp" type="text" name="" required="">
                </div>--%>
            </div>
            <div class="inputWrap__element">
                <div class="inputBox">
                    <input type="email" name="" required="">
                    <label>E-mail</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>Address</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>City</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="" required="">
                    <label>Phone</label>
                </div>
                <%--<div class="inputBox">
                    <label for="emailInp">E-mail</label>
                    <input id="emailInp" type="email" name="" required="">
                </div>
                <div class="inputBox">
                    <label for="addressInp">Address</label>
                    <input id="addressInp" type="text" name="" required="">
                </div>
                <div class="inputBox">
                    <label for="cityInp">City</label>
                    <input id="cityInp" type="text" name="" required="">
                </div>
                <div class="inputBox">
                    <label for="phoneInp">Phone</label>
                    <input id="phoneInp" type="text" name="" required="">
                </div>--%>
            </div>
        </div>
        <div class="regInput">
            <input type="submit" name="registration" value="Registration">
        </div>
    </form>
</div>
</body>
</html>
