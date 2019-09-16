
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>list costumers</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Simple CRM - customer Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                </tr>
            </c:forEach>
        </table>

        </div>
    </div>

LIST CUSTOMERS!!!!
</body>
</html>
