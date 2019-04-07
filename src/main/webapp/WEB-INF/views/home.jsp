<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Y-Kom</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s3">
            <div class="collection">
                <c:forEach items="${categories}" var="category">
                    <a href="/category/${category.name}" class="collection-item"
                       style="padding: 5px 5px">${category.name}</a>
                </c:forEach>
            </div>
        </div>

        <div class="col s9">
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
                        <th>
                            <form action="/basket/add" method="post">
                                <input type="hidden" name="productId" value="${product.id}"/>
                                <button type="submit" class="btn btn-success">
                                    <i class="fas fa-cart-plus" style="font-size: 1.4rem"></i>
                                </button>
                            </form>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
