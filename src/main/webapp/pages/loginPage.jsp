<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css"
          href="/css/signIn.css">
          <%--href="<c:url value="css/signIn.css"/>">--%>
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >

    <%--<fmt:setBundle basename="login" var="login"/>--%>

</head>
<body>
<jsp:include page="/WEB-INF/includeJSP/navbar.jsp"/>

<div class="container-fluid bg">
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4 col-xs-12">
            <!-- form start -->
            <form class="form-container" method="post" action="polik">
                <h1>Sign in</h1>
                <div class="form-group">
                    <input type="text" id="inputUsername" required="">
                    <label for="inputUsername"><fmt:message key="placeholderUsername" /> </label>
                </div>
                <div class="form-group">
                    <input type="password" id="inputPassword" required="">
                    <label for="inputPassword"><fmt:message key="placeholderPassword" /> </label>
                </div>

                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-success btn-block" name="login" value="Login">Submit</button>
            </form>
            <!-- form end -->
        </div>
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
    </div>
</div>
</body>
</html>