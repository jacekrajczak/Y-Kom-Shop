<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Koszyk</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/>

<ul class="collection">
    <c:forEach items="${products}" var="product">
        <li class="collection-item">
            <div class="container" style="display: inline-block;">
                <div class="col s8">${product.name}</div>
                <div class="col s3">${product.prize} zł</div>
                <div class="col s1">${product.basketQuantity}</div>
            </div>
        </li>
    </c:forEach>
</ul>

<a href="basket/order" class="waves-effect waves-light btn">Potwierdź zamówienie</a>

</body>
</html>
