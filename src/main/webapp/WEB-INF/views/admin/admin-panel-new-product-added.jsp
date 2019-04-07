<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Admin panel</title>
    <jsp:include page="../elements/header.jsp"/>
</head>
<body>
<jsp:include page="../elements/menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s3">
            <div class="collection">
                <li>
                    <a href="">Zlecenia</a>
                    <a href="">Produkty</a>
                    <a href="">Użytkownicy</a>
                </li>
            </div>
        </div>

        <div class="col s9">
            Produkt dodany.
        </div>
    </div>
</div>

</body>
</html>
