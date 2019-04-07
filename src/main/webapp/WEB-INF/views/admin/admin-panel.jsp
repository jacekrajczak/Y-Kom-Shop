<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
    <jsp:include page="../elements/menu.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col s3">
                <div class="collection">
                        <a href="/admin" class="collection-item">Zlecenia</a>
                        <a href="/admin/manage-product" class="collection-item">Produkty</a>
                        <a href="/admin/manage-user" class="collection-item">Użytkownicy</a>
                </div>
            </div>

            <div class="col s9">
                    <c:forEach items="${orders}" var="orders">
                        <li class="collection-item">
                            <p>${orders}</p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>



</body>
</html>