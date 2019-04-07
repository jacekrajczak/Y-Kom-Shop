<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Strona rejestracji</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/regMenu.jsp"/>
<div class="container">
    <div class="row center"><h2>Formularz rejestracyjny</h2>
        <form:form method="post" modelAttribute="newUser" action="/registerUser">
            <div>
                <fieldset>
                    <legend>Dane</legend>
                    <div><label for="password">Imię:</label><form:input type="text"
                                                                        name="name"
                                                                        id="name" path="firstName"/></div>
                    <div><label for="password">Nazwisko:</label><form:input type="text"
                                                                            name="surname"
                                                                            id="surname" path="lastName"/></div>
                    <div><label for="password">Login:</label><form:input type="text"
                                                                         name="login"
                                                                         id="login" path="login"/></div>
                    <div><label for="password">Hasło:</label><form:input type="password"
                                                                         name="password"
                                                                         id="password" path="password"/></div>
                    <div><label for="password">Numer telefonu:</label><form:input type="text"
                                                                                  name="phone"
                                                                                  id="phone" path="phoneNumber"/></div>
                    <div><label for="password">Adres:</label><form:input type="text"
                                                                         name="address"
                                                                         id="address" path="address"/></div>
                    <div><label for="password">Kod pocztowy:</label><form:input type="text"
                                                                                name="postcode"
                                                                                id="postcode" path="postcode"/></div>
                    <div><label for="password">Miasto:</label><form:input type="text"
                                                                          name="city"
                                                                          id="city" path="city"/></div>
                    <div>
                        <button type="submit" class="btn waves-effect waves-light">Rejestruj</button>
                    </div>
                </fieldset>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>