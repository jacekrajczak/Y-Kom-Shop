<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <form:form method="post" modelAttribute="newUser" action="/registerUser">
                        <div>
                            <fieldset>

                                <legend>Dane produktu</legend>

<%--
                                <div>
                                    <label for="name">Kategoria:</label>
                                    <form:options items="${categories.name}" path="categoryName"/>
                                </div>

                                <div>
                                    <label for="name">Nazwa:</label>
                                    <form:input type="text" name="name" id="name" path="name"/>
                                </div>

                                <div>
                                    <label for="name">Cena:</label>
                                    <form:input type="text" name="prize" id="prize" path="prize"/>
                                </div>

                                <div>
                                    <label for="name">Opis:</label>
                                    <form:input type="text" name="description" id="description" path="description"/>
                                </div>

                                <div>
                                    <label for="name">Ilość w magazynie:</label>
                                    <form:input type="text" name="warehouseQuantity" id="warehouseQuantity" path="warehouseQuantity"/>
                                </div>

--%>
                                    <button type="submit" class="btn waves-effect waves-light">Dodaj</button>
                                </div>

                            </fieldset>
                        </div>
                    </form:form>
            </div>
        </div>
    </div>


</body>
</html>
