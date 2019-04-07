<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona logowania</title>
    <jsp:include page="elements/header.jsp"/>
</head>
<body>
<jsp:include page="elements/regMenu.jsp"/>
<div class="container">
    <div class="row center"><h2>Formularz logowania</h2>
        <form method="get" action="/">
            <div>
                <fieldset>
                    <legend>Dane logowania</legend>
                    <div><label for="login">Login: </label><input type="text" required name="login"
                                                                  id="login"/></div>
                    <div><label for="password">Password</label><input type="password" required
                                                                      name="password"
                                                                      id="password"/></div>
                    <div>
                        <button type="submit" class="btn waves-effect waves-light">Zaloguj</button>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</div>
</body>
</html>