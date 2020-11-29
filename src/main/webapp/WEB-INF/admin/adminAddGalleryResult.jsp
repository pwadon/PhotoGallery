<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${message}</h2>
<h4>Gallery: ${gallery.name}</h4>


<form:form method="POST"
           action="galleries"
           modelAttribute="gallery"
           enctype="multipart/form-data">

    <form:label path="name">name</form:label>
    <form:input required="required" path="name"  placeholder="name"/>

    <form:label path="user">name</form:label>
    <form:select name="user" path="user">
        <c:forEach items ="${users}" var ="user">
            <form:option value="${user.id}">${user.login}</form:option>
        </c:forEach>
    </form:select>
    <form:button>submit</form:button>
</form:form>
</body>
</html>
