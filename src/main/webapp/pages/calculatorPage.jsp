<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="nowDate" class="ua.com.delivery.service.DateService"/>

<%--<fmt:setLocale value="${sessionScope.locale}"/>--%>
<fmt:setBundle basename="language"/>

<fmt:message key="calculator.delivery" var="Delivery"/>
<fmt:message key="calculator.schedule" var="Schedule"/>
<fmt:message key="calculator.main" var="Main"/>
<fmt:message key="calculator.condition" var="Condition"/>
<fmt:message key="calculator.calculator" var="Calculator"/>
<fmt:message key="calculator.contacts" var="Contact"/>
<fmt:message key="calculator.order" var="Order"/>
<fmt:message key="calculator.signIn" var="SignIn"/>
<fmt:message key="calculator.logout" var="Logout"/>
<fmt:message key="calculator.calculatorMi" var="CalculatorMi"/>
<fmt:message key="calculator.route" var="Route"/>
<fmt:message key="calculator.dateOfDeparture" var="DepartureDate"/>
<fmt:message key="calculator.desiredDate" var="DesiredDate"/>
<fmt:message key="calculator.declaredPrice" var="DeclaredPrice"/>
<fmt:message key="calculator.weight" var="Weight"/>
<fmt:message key="calculator.calculate" var="Calculate"/>
<fmt:message key="calculator.calculationPrice" var="CalculationPrice"/>
<fmt:message key="calculator.priceByWeight" var="ParcelWeightPrice"/>
<fmt:message key="calculator.priceBetweenCity" var="BetweenCityPrice"/>
<fmt:message key="calculator.price" var="Price"/>
<fmt:message key="calculator.totalPrice" var="TotalPrice"/>
<fmt:message key="calculator.address" var="Address"/>
<fmt:message key="calculator.allRight" var="AllRight"/>


<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Calculator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/mainPolik.css">
    <link rel="stylesheet" href="css/calculatorPolik.css">
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
                    <h1>Polik
                        <small>${Delivery}</small>
                    </h1>
                </div>
            </div>
            <div class="col-md-4 col-lg-3 ml-auto d-flex justify-content-end">
                <div class="schedule">
                    <span>(063)-625-48-22</span>
                    <p>${Schedule} 9<sup>00</sup> &#8212; 21<sup>00</sup></p>
                    <c:if test="${visibleOrder == true}">
                        <p>Hello my friend ${visibleUser}</p>
                    </c:if>
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
                <input type="checkbox" id="hideMenu">
                <label for="hideMenu"><i class="fa fa-bars"></i></label>
                <nav>
                    <ul class="menu d-flex">
                        <li><a href="/con?command=home">${Main}</a></li>
                        <li><a href="/con?command=condition">${Condition}</a></li>
                        <li class="active"><a href="/con?command=calculator">${Calculator}</a></li>
                        <li><a href="/con?command=contact">${Contact}</a></li>
                        <c:if test="${visibleOrder == true}">
                            <li><a href="/con?command=order">${Order}</a></li>
                        </c:if>
                        <%--<li><a href="/con?command=order">${Order}</a></li>--%>
                    </ul>
                </nav>
            </div>
            <div class="col-md-3 col-lg-3 d-flex justify-content-end align-items-center ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="con?command=localeUa">
                        <img src="img/lang_icon-ukr.png" width="16">
                    </a></span>
                    <span class="lang__item"><a href="con?command=localeEn">
                        <img src="img/lang_icon-uk.png" width="16">
                    </a></span>
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
<!-- CALCULATOR -->
<section id="calculator" class="calculator">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <h2>${CalculatorMi}</h2>
                <div class="line"></div>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col-md-12 col-lg-12 d-flex justify-content-center">
                <form action="con" name="calculatorForm" method="post">
                    <input type="hidden" name="command" value="calculate">
                    <div class="calculator__block">
                        <div class="block__element">
                            <label>${Route}</label>
                            <select name="from_city" id="from">
                                <c:forEach items="${listFromToCity}" var="elem">
                                    <option value="${elem.fromCity}"><c:out value="${elem.fromCity}"/></option>
                                </c:forEach>
                                <%--<option value="Odessa">Одесса</option>--%>
                                <%--<option value="Lviv">Львов</option>--%>
                            </select>
                            <i class="fa fa-arrow-right"></i>
                            <select name="to_city" id="to">
                                <c:forEach items="${listFromToCity}" var="elem">
                                    <option value="${elem.fromCity}"><c:out value="${elem.fromCity}"/></option>
                                </c:forEach>
                                <%--<option value="Lviv">Львов</option>--%>
                            </select>
                        </div>
                        <div class="block__element">
                            <label>${DepartureDate}</label>
                            <input class="forDate" type="date" min="<jsp:getProperty name="nowDate" property="date"/>"
                                   required="">
                            <label>${DesiredDate}</label>
                            <input class="forDate" type="date" min="<jsp:getProperty name="nowDate" property="date"/>"
                                   required="">
                        </div>
                        <div class="block__element">
                            <label>${DeclaredPrice}</label>
                            <input type="number" min="10" required="">
                        </div>
                        <div class="block__element">
                            <label>${Weight}</label>
                            <input type="number" name="weight" min="1" max="20" required="">
                        </div>
                    </div>
                    <div class="offset-md-4 col-md-4 offset-lg-4 col-lg-4">
                        <input type="submit" value="${Calculate}">
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-lg-12">
                            <div class="line"></div>
                        </div>
                        <div class="col-md-3 col-lg-3 d-flex justify-content-center">
                            <i class="fa fa-calculator"></i>
                        </div>
                        <div class="col-md-5 col-lg-5">
                            <h3>${CalculationPrice}</h3>
                            <span>${ParcelWeightPrice}</span><br>
                            <span>${BetweenCityPrice}</span><br>
                        </div>
                        <div class="col-md-4 col-lg-4">
                            <h3>${Price}</h3>
                            <span>${priceByWeight} грн.</span><br>
                            <span>${priceBetweenCity} грн.</span><br>

                        </div>
                        <div class="offset-md-3 col-md-5 offset-lg-3 col-lg-5">
                            <h3>${TotalPrice}</h3>
                        </div>
                        <div class="col-md-4 col-lg-4">
                            <h3><span>${priceFromToCity} грн.</span></h3>
                        </div>
                        <div class="col-md-12 col-lg-12">
                            <div class="line"></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- CALCULATOR -->
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
                    01032 ${Address} (063)-625-48-22
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
                    &#169; 2017 ${AllRight}
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>
