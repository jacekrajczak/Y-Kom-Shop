<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Koszyk - poprawa zamówienia</title>
    <jsp:include page="elements/header.jsp"/>

    <style>
        th {
            font-weight: normal;
        }

        p {
            text-align: right;
        }

        .toasts p {
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="elements/menu.jsp"/>

<div class="container">

    <table>
        <thead>
        <tr>
            <th>Produkt</th>
            <th>Cena</th>
            <th>Ilość</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <th>${product.name}</th>
                <th>${product.prize} zł</th>
                <th>${product.basketQuantity}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="toasts">
        <p><a onclick="M.toast({html: 'simple toast'})" class="btn">Zmieniono zamówienie</a></p>
        <c:forEach items="${productsWithChangedQuantity}" var="product">
            <p><a onclick="M.toast({html: 'product toast'})" class="btn">Zmieniono ${product.name} ilość w koszyku
                na: ${product.basketQuantity}</a></p>
        </c:forEach>
    </div>

    <p>Koszt zamówienia: ${totalPrice.toString()}</p>

    <p><a href="basket/order" class="waves-effect waves-light btn">Potwierdź zamówienie</a></p>

</div>

</body>
</html>
