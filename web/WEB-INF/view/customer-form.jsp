<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Simple CRM - </h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <form:form action="saveCustomer" modelAttribute="customer" method="POST">

                <!-- need to associate this data with customer id-->
                <form:hidden path="id"/>

                <table>
                    <tbody>
                    <tr>
                       <td><label>First Name</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label>Last Name</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                    <tr>
                        <td><label>Email</label></td>
                        <td><form:input path="email"/></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
                    </tbody>
                </table>
            </form:form>

            <div style="clear; both;"></div>

            <p>
                <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
            </p>

        </div>
    </div>
</body>
</html>
