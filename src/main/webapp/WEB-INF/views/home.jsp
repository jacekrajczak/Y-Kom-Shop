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
                    <a href="/category/${category.name}" class="collection-item">${category.name}</a>
                </c:forEach>
            </div>
        </div>

        <div class="col s9">
            <ul class="collection">
                <c:forEach items="${products}" var="product">
                    <li class="collection-item">
                        <div class="container" style="display: inline-block; width: 100%;">
                            <div class="col s8">${product.name}</div>
                            <div class="col s3">${product.prize} zł</div>
                            <div class="col s1">
                                <form action="/basket/add" method="post">
                                    <input type="hidden" name="productId" value="${product.id}"/>
                                    <button type="submit" class="btn btn-success">
                                        <i class="fas fa-cart-plus" style="font-size: 1.4rem"></i>
                                    </button>
                                </form>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
