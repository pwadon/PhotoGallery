<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST"
           action="galleries"
           modelAttribute="gallery"
           cssClass="container col-6"
           enctype="multipart/form-data">

    <form:label path="name">name</form:label>
    <form:input required="required"  path="name" cssClass="form-input" placeholder="name"/>

    <form:label path="user">user</form:label>
    <form:select name="user" path="user">
        <c:forEach items ="${users}" var ="user">
            <form:option value="${user.id}">${user.login}</form:option>
        </c:forEach>
    </form:select>
    <form:button>submit</form:button>
</form:form>

</body>
</html>
