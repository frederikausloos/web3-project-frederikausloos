<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="page" value="Index"></jsp:param>
    </jsp:include>

    <main>
        <c:choose>
            <c:when test="${not empty person}">
                <h3>Welkom, ${person.firstName}</h3>

                <form method="POST" action="Servlet?command=Logout">
                    <input type="submit" id="logout" value="Logout"></input>
                </form>
            </c:when>

            <c:otherwise>
                <h3>Login</h3>
                <c:if test="${not empty errorLogin}">
                    <ul>
                        <li>${errorLogin}</li>
                    </ul>
                </c:if>

                <form  method="POST" action="Servlet?command=Login" novalidate>
                    <p><label for="userId">Your user id</label><input type="text" id="userId" name="userId"
                                                                      value="${userIdPrevious}" required></p>
                    <p><label for="password">Your password</label><input type="password" id="password"
                                                                         name="password" required></p>
                    <p><input type="submit" id="login" value="Login"></p>
                </form>
                <p>If you dont have an account already, <a href="Servlet?command=Register">register here.</a></p>
            </c:otherwise>
        </c:choose>

    </main>

    <jsp:include page="footer.jsp" />
</div>


</body>
</html>