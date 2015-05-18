<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Shop Information</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${shopForm.name}</td>
    </tr>
    <tr>
        <td>Staff Name</td>
        <td>${shopForm.staffName}</td>
    </tr>
</table>
</body>
</html>