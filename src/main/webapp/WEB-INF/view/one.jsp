<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1></h1>
<div>
    <c:if test="${car != null}">
        <p>${car.id}</p>
        <p>${car.model}</p>
        <p>${car.color}</p>
        <p>$${car.price}</p>
    </c:if>
</div>
</body>
</html>
