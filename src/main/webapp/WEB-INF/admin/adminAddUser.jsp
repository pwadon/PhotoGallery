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
           action="users"
           modelAttribute="user"
           cssClass="container col-6"
           enctype="multipart/form-data">
            <form:label path="login">Login</form:label>
            <form:input required="required" path="login" cssClass="form-input" placeholder="login"/>
            <form:label path="password">Password</form:label>
            <form:password required="required" path="password" cssClass="form-input" placeholder="password"/>
            <form:button>submit</form:button>
</form:form>


</body>
</html>
