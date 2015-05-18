<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" commandName="shopForm" action="addShop">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td>
                <form:input path="name" />
                <form:errors path='name' />
            </td>
        </tr>
        <tr>
            <td><form:label path="staffName">Staff Name</form:label></td>
            <td><form:input path="staffName" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
    <c:if test="${!empty shops}">
        <h3>Shops</h3>
        <table border="1">
            <thead>
            <tr>
                <th>Name</th>
                <th>Staff Name</th>
                <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${shops}" var="shopForm">
                <tr>
                    <td>${shopForm.name}</td>
                    <td>${shopForm.staffName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</form:form>
</body>
</html>