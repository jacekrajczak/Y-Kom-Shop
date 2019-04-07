<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="deep-orange">
    <div class="nav-wrapper container" role="navigation">
        <div class="row">
            <ul>
                <div class="col s3">
                    <li><a href="/">Y-Kom</a></li>
                </div>
                <div class="col s5">
                    <li>
                        <form action="/search" method="post" style="display: inline">
                            <input type="text" name="search" placeholder="Czego szukasz?">
                        </form>
                    </li>
                </div>
                <div class="col s2">
                    <li><a href="/">Zaloguj</a></li>
                </div>
                <div class="col s2">
                    <li><a href="/basket">Koszyk</a></li>
                </div>
            </ul>
        </div>
    </div>
</nav>