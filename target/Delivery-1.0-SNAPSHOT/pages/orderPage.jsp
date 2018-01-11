<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="nowDate" class="ua.com.delivery.service.DateService"/>

<fmt:setBundle basename="language"/>

<fmt:message key="order.delivery" var="Delivery"/>
<fmt:message key="order.schedule" var="Schedule"/>
<fmt:message key="order.main" var="Main"/>
<fmt:message key="order.condition" var="Condition"/>
<fmt:message key="order.calculator" var="Calculator"/>
<fmt:message key="order.contacts" var="Contact"/>
<fmt:message key="order.order" var="Order"/>
<fmt:message key="order.signIn" var="SignIn"/>
<fmt:message key="order.logout" var="Logout"/>
<fmt:message key="order.createOrder" var="CreateOrder"/>
<fmt:message key="order.payment" var="Pay"/>
<fmt:message key="order.cabinet" var="Cabinet"/>
<fmt:message key="order.receipt" var="Receipt"/>




<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order Delivery</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/mainPolik.css">
    <link rel="stylesheet" href="../css/orderPolik.css">
    <link rel="stylesheet" href="../css/media.css">
</head>
<body>
<!-- HEADER -->
<header id="header" class="header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-8 col-lg-7 d-flex">
                <div class="logo">
                    <img src="../img/logo.png" alt="logo" width="100">
                </div>
                <div class="logo__text">
                    <h1>Polik
                        <small>${Delivery}</small>
                    </h1>
                </div>
            </div>
            <div class="col-md-4 col-lg-3 ml-auto">
                <div class="schedule">
                    <span>(063)-625-48-22</span>
                    <p>${Schedule} 9<sup>00</sup> &#8212; 21<sup>00</sup></p>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- /HEADER -->
<!-- MENU -->
<section id="topMenu" class="topMenu">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-12 col-lg-12">
                <div class="line"></div>
            </div>
            <div class="col-md-9 col-lg-9">
                <input type="checkbox" id="hideMenu">
                <label for="hideMenu"><i class="fa fa-bars"></i></label>
                <nav>
                    <ul class="menu d-flex">
                        <li><a href="/">${Main}</a></li>
                        <li><a href="/con?command=condition">${Condition}</a></li>
                        <li><a href="/con?command=calculator">${Calculator}</a></li>
                        <li><a href="/con?command=contact">${Contact}</a></li>
                        <li class="active"><a href="/con?command=order">${Order}</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-md-3 col-lg-3 d-flex justify-content-end ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="?command=localeUa">Укр</a></span>
                    <span class="lang__item"><a href="?command=localeEn">En</a></span>
                    <c:choose>
                        <c:when test="${visibleLogout == true}">
                            <a href="/con?command=logout">${Logout}<i class="fa fa-sign-out"></i> </a>
                        </c:when>
                        <c:otherwise>
                            <a href="/con?command=signIn">${SignIn} <i class=" fa fa-sign-in"></i></a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="col-md-12 col-lg-12">
                <div class="line"></div>
            </div>
        </div>
    </div>
</section>
<!-- /MENU -->
<!-- ORDER -->
<section id="order" class="order">
    <div class="container">
        <div class="row ">
            <div class="col-md-12 col-lg-12">
                <h2>${Cabinet}</h2>
                <!-- Line -->
                <div class="line"></div>
                <!-- /Line -->
                <input type="checkbox" id="test">
                <label class="myButton" for="test">${CreateOrder}</label>
                <input class="myButton" type="button" value="${Pay}">
                <!-- Line -->
                <div class="line"></div>
                <!-- /Line -->
                <form action="#">
                    <!-- Забор груза -->
                    <div class="col-md-12 col-lg-12 d-flex justify-content-center">
                        <input type="radio" name="type" id="receipt">
                        <label for="receipt">${Receipt}</label>
                        <div class="receiptTab">
                            <div class="receiptTab__element">
                                <label for="recDate">Дата отримання:</label>
                                <input class="forDate" type="date" id="recDate"
                                       min="<jsp:getProperty name="nowDate" property="date"/>"
                                       required=""
                                       name="dateOfDelivery">
                                <label for="recPhone">Телефон:</label>
                                <input type="text" id="recPhone" required=""
                                       name="phone">
                            </div>
                            <div class="receiptTab__element">
                                <label for="recCity">Місто відправлення:</label>
                                <input type="text" id="recCity" required=""
                                       name="directionId">
                                <label for="recAdress">Адреса отримання:</label>
                                <input type="text" id="recAdress" required=""
                                       name="addressOfDelivery">
                            </div>
                            <div class="receiptTab__element">
                                <%--<label for="recLast">Фамилия:</label>--%>
                                <%--<input type="text" id="recLast" required="">--%>
                                <label for="recName">Ім'я:</label>
                                <input type="text" id="recName" required=""
                                       name="userId">
                                <label for="recWeight">Вага вантажу:</label>
                                <input type="text" id="recWeight" required=""
                                name="weightOfParcel">
                            </div>
                            <%--<div class="receiptTab__element">--%>
                            <%--<label for="recName">Имя:</label>--%>
                            <%--<input type="text" id="recName" required="">--%>
                            <%--<label for="recVolume">Обьем груза:</label>--%>
                            <%--<input type="text" id="recVolume" required="">--%>
                            <%--</div>--%>
                            <div class="receiptTab__element">
                                <label for="recEmail">E-mail:</label>
                                <input type="text" id="recEmail" required=""
                                name="email">
                            </div>
                        </div>
                    </div>
                    <!-- /Забор груза -->
                    <!-- Line -->
                    <div class="line"></div>
                    <!-- /Line -->
                    <!-- Доставка груза -->
                    <div class="col-md-12 col-lg-12 d-flex justify-content-center">
                        <input type="radio" name="type" id="delivery">
                        <label for="delivery">Доставка вантажу</label>
                        <div class="deliveryTab">
                            <div class="deliveryTab__element">
                                <label for="delDate">Дата відправлення:</label>
                                <input class="forDate" type="date" id="delDate"
                                       min="<jsp:getProperty name="nowDate" property="date"/>"
                                       required="">
                                <label for="delPhone">Телефон:</label>
                                <input type="text" id="delPhone" required="">
                            </div>
                            <div class="deliveryTab__element">
                                <label for="delCity">Адрес відправлення:</label>
                                <input type="text" id="delCity" required="">
                                <label for="delAdress">Місто отримання:</label>
                                <input type="text" id="delAdress" required="">
                            </div>
                            <div class="deliveryTab__element">
                                <%--<label for="delLast">Фамилия:</label>--%>
                                <%--<input type="text" id="delLast" required="">--%>
                                <label for="delName">Имя:</label>
                                <input type="text" id="delName" required="">
                                <label for="delWeight">Вага вантажу:</label>
                                <input type="text" id="delWeight" required="">
                            </div>
                            <%--<div class="deliveryTab__element">--%>
                            <%--<label for="delName">Имя:</label>--%>
                            <%--<input type="text" id="delName" required="">--%>
                            <%--<label for="delVolume">Обьем груза:</label>--%>
                            <%--<input type="text" id="delVolume" required="">--%>
                            <%--</div>--%>
                            <div class="deliveryTab__element">
                                <label for="delEmail">E-mail:</label>
                                <input type="text" id="delEmail" required="">
                            </div>
                        </div>
                    </div>
                    <!-- /Доставка груза -->
                    <!-- Line -->
                    <div class="line"></div>
                    <!-- /Line -->
                    <div class="offset-md-5 col-md-5 offset-lg-5 col-lg-6">
                        <div class="price d-flex justify-content-around align-items-center">
                            <h3>Стоимость:</h3>
                            <p>1000 грн.</p>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <input type="submit" value="Відправити заявку">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- ORDER -->
<!-- MAP -->
<section id="map" class="map">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-8 col-lg-8">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d2540.540206722022!2d30.50255354272231!3d50.44966448382961!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sua!4v1513559315737"
                        width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="col-md-4 col-lg-4">
                <div class="address ">
                    01032 м.Киев вул. Гончара 55а (063)-625-48-22
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /MAP -->
<!-- FOOTER -->
<footer id="footer" class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <div class="copy">
                    &#169; 2017 Все права защищены
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>