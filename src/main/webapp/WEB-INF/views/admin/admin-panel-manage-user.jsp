<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <fieldset>

                    <form:form action="post" modelAttribute="" cssStyle="text-align: center;">

                        Imię <form:input path="" />
                        Nazwisko <form:input path="" />
                        Login <form:input path="" />
                        Hasło <form:input path="" />
                        E-mail <form:input path="" />
                        Numer telefonu <form:input path="" />
                        Adres <form:input path="" />
                        Kod pocztowy <form:input path="" />
                        Miasto <form:input path="" />

                        <button type="submit" class="btn waves-effect waves-light">Dodaj</button>
                        <button type="submit" class="btn waves-effect waves-light">Uaktualnij</button>
                        <button type="submit" class="btn waves-effect waves-light">Usuń</button>


                    </form:form>
                </fieldset>
            </div>
        </div>
    </div>



</body>
</html>
