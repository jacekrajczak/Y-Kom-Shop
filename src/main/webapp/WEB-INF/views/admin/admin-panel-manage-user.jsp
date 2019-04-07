<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>


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
                <fieldset>

                    <form:form action="post" modelAttribute="">

                        imię <form:input path="" />
                        nazwisko <form:input path="" />
                        login <form:input path="" />
                        email <form:input path="" />
                        hasło <form:input path="" />
                        numer telefonu <form:input path="" />
                        adres <form:input path="" />
                        kod pocztowy <form:input path="" />
                        miasto <form:input path="" />

                        <input type="submit" value="Update">
                        <input type="submit" value="Delete">

                    </form:form>
                </fieldset>
            </div>
        </div>
    </div>



</body>
</html>
