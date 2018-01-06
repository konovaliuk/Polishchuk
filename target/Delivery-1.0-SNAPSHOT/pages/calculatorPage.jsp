<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="nowDate" class="ua.com.delivery.service.DateService"/>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language"/>

<fmt:message key="calculator.delivery" var="Delivery"/>
<fmt:message key="calculator.schedule" var="Schedule"/>
<fmt:message key="calculator.main" var="Main"/>
<fmt:message key="calculator.condition" var="Condition"/>
<fmt:message key="calculator.calculator" var="Calculator"/>
<fmt:message key="calculator.contacts" var="Contact"/>
<fmt:message key="calculator.order" var="Order"/>
<fmt:message key="calculator.signIn" var="SignIn"/>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Calculator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/mainPolik.css">
    <link rel="stylesheet" href="../css/calculatorPolik.css">
    <link rel="stylesheet" href="css/media.css">
</head>
<body>
<!-- HEADER -->
<header id="header" class="header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-8 col-lg-7 d-flex">
                <div class="logo">
                    <img src="img/logo.png" alt="logo" width="100">
                </div>
                <div class="logo__text">
                    <h1>Polik <small>${Delivery}</small></h1>
                </div>
            </div>
            <div class="col-md-4 col-lg-3 ml-auto">
                <div class="schedule">
                    <span>(063)-625-48-22</span>
                    <p>${Schedule} 9<sup>00</sup> &#8212; 21<sup>00</sup> </p>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- /HEADER -->
<!-- MENU -->
<section id="topMenu" class="topMenu">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <div class="line"></div>
            </div>
            <div class="col-md-9 col-lg-9">
                <nav>
                    <ul class="menu d-flex align-items-center">
                        <li><a href="/con?command=home" >${Main}</a ></li>
                        <li><a href="/con?command=condition">${Condition}</a></li>
                        <li class="active"><a href="/con?command=calculator">${Calculator}</a></li>
                        <li><a href="/con?command=contact">${Contact}</a></li>
                        <%--<li><a href="/con?command=order">${Order}</a></li>--%>
                    </ul>
                </nav>
            </div>
            <div class="col-md-3 col-lg-3 d-flex justify-content-end align-items-center ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="/con?command=localeUa">Укр</a></span>
                    <span class="lang__item"><a href="/con?command=localeEn">En</a></span>
                    <a href="/con?command=signIn">${SignIn} <i class=" fa fa-sign-in"></i></a>
                </div>
            </div>
            <div class="col-md-12 col-lg-12">
                <div class="line"></div>
            </div>
        </div>
    </div>
</section>
<!-- /MENU -->
<!-- CALCULATOR -->
<section id="calculator" class="calculator">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <h2>Калькулятор</h2>
            </div>
        </div>
        <form action="#">
            <div class="row align-items-center">
                <div class="col-md-4 col-lg-4 d-flex justify-content-center">
                    <label >Маршрут:</label>
                </div>
                <div class="col-md-3 col-lg-3 d-flex justify-content-center">
                    <select name="from_city" id="from">
                        <c:forEach items="${listFromToCity}" var="elem">
                            <option value="${elem.fromCity}"><c:out value="${elem.fromCity}"/></option>
                        </c:forEach>
                        <%--<option value="Odessa">Одесса</option>--%>
                        <%--<option value="Lviv">Львов</option>--%>
                    </select>
                </div>
                <div class="col-md-1 col-lg-1 d-flex justify-content-center">
                    <i class="fa fa-arrow-right"></i>
                </div>
                <div class="col-md-3 col-lg-3">
                    <select name="to_city" id="to">
                        <c:forEach items="${listFromToCity}" var="elem">
                            <option value="${elem.fromCity}"><c:out value="${elem.fromCity}"/></option>
                        </c:forEach>
                        <%--<option value="Lviv">Львов</option>--%>
                    </select>
                </div>
                <div class="col-md-4 col-lg-4 d-flex justify-content-center">
                    <label>Дата відправлення:</label>
                </div>
                <div class="col-md-2 col-lg-2">
                    <input class="forDate" type="date" min="<jsp:getProperty name="nowDate" property="date"/>" required="">
                </div>
                <div class="col-md-2 col-lg-2 d-flex justify-content-center dateDel">
                    <label>Бажана дата отримання:</label>
                </div>
                <div class="col-md-2 col-lg-2">
                    <input class="forDate" type="date" min="<jsp:getProperty name="nowDate" property="date"/>" required="">
                </div>
                <div class="col-md-4 col-lg-4 d-flex justify-content-center">
                    <label>Оголошена вартість:</label>
                </div>
                <div class="col-md-8 col-lg-8">
                    <input type="number" min="10" required="">
                </div>
                <div class="col-md-4 col-lg-4 d-flex justify-content-center">
                    <label>Вага:</label>
                </div>
                <div class="col-md-8 col-lg-8">
                    <input type="number" name="weight" min="1" max="19" required="">
                </div>
                <%--<div class="col-lg-4 d-flex justify-content-center">--%>
                    <%--<label>Обьем:</label>--%>
                <%--</div>--%>
                <%--<div class="col-lg-8">--%>
                    <%--<input type="number" min="1" required="">--%>
                <%--</div>--%>
            </div>
            <div class="offset-md-4 col-md-4 offset-lg-4 col-lg-4">
                <input type="submit" value="Расчитать">
            </div>
            <div class="row">
                <div class="col-md-12 col-lg-12"><h2></h2></div>
                <div class="col-md-3 col-lg-3 d-flex justify-content-center">
                    <i class="fa fa-calculator"></i>
                </div>
                <div class="col-md-5 col-lg-5">
                    <h3>Розрахунок вартості:</h3>
                    <span>Вартість доставки:</span>
                </div>
                <div class="col-md-4 col-lg-4">
                    <h3>Вартість:</h3>
                    <span>1000 грн.</span>
                </div>
                <div class="offset-md-3 col-md-5 offset-lg-3 col-lg-5">
                    <h3>Разом до сплати:</h3>
                </div>
                <div class="col-md-4 col-lg-4">
                    <h3>1000 грн.</h3>
                </div>
            </div>
        </form>
    </div>
</section>
<!-- CALCULATOR -->
<!-- MAP -->
<section id="map" class="map">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-8 col-lg-8">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d2540.540206722022!2d30.50255354272231!3d50.44966448382961!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sua!4v1513559315737" width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="col-md-4 col-lg-4">
                <div class="address ">
                    01032 м.Київ вул. Гончара 55а (063)-625-48-22
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
            <div class="col-lg-12 col-lg-12">
                <div class="copy">
                    &#169; 2017 Всі права захищені
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>
