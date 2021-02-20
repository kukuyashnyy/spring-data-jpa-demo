<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>All cars</title>
    <style>
        table {
            border-collapse: collapse;
        }
        table, td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>All cars</h1>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Model</th>
        <th>Color</th>
        <th>Price</th>
    </tr>
    </thead>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.model}</td>
            <td>${car.color}</td>
            <td>${car.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
