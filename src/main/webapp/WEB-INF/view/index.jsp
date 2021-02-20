<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ci" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        label {
            display: inline-block;
            width: 150px;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Sprint Data JPA</h1>
<form:form method="post" modelAttribute="car">
    <form:hidden path="id"/>
    <div>
        <form:label path="model">Model</form:label>
        <form:input path="model" type="text"/>
        <form:errors path="model" cssClass="error"/>
    </div>
    <div>
        <form:label path="color">Color</form:label>
        <form:input path="color" type="color"/>
        <form:errors path="color" cssClass="error"/>
    </div>
    <div>
        <form:label path="price">Color</form:label>
        <form:input path="price" type="number" min="0"/>
        <form:errors path="price" cssClass="error"/>
    </div>
    <div>
        <form:label path="category">Category</form:label>
<%--        <form:select path="category">--%>
<%--            <ci:forEach items="${categories}" var="category">--%>
<%--                <form:option value="${category.name}" />--%>
<%--            </ci:forEach>--%>
<%--        </form:select>--%>
        <form:input path="category" type="text"/>
        <form:errors path="category" cssClass="error"/>
    </div>
    <input type="submit"/>
</form:form>

<div>
    <a href="<spring:url value="/h2console"/>">h2 console</a>
    <a href="<spring:url value="/all"/>">all</a>
</div>

<h2>Links</h2>
<ul>
    <li><a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface">Open References</a></li>
</ul>
</body>
</html>
