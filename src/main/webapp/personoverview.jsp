<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="PersonOverview"></jsp:param>
    </jsp:include>

    <main>
        <table>
            <tr>
                <th>E-mail</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Arrival</th>
                <th>Departure</th>
            </tr>

            <c:forEach var="person" items="${persons}">
                <tr>
                    <td>${person.email}</td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>${person.arrival}</td>
                    <td>${person.leave}</td>
                </tr>
            </c:forEach>

            <caption>Users Overview</caption>
        </table>
    </main>

    <jsp:include page="footer.jsp" />
</div>
</body>
</html>