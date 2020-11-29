<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
    <style type ="text/css">
        label {
            display: inline-block;
            width: 200px;
            maring: 5px;
            text-align: left;
        }
        button {
            padding: 10px;
            margin: 10px;
        }
        span {
            display: inline-block;
            width: 200px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>${message}</h2>
    <span>Login:</span><span>${user.login}</span>


<form:form method="POST"
           action="users"
           modelAttribute="user"
           cssClass="container col-6"
           enctype="multipart/form-data">
            <form:label path="login">Login</form:label>
            <form:input path="login" cssClass="form-input" placeholder="login"/>
            <form:errors path="login" cssClass="alet alert-danger" element="div"/>
            <form:password path="password" cssClass="form-input" placeholder="password"/>
            <form:errors path="password" cssClass="alet alert-danger" element="div"/>
            <form:button>submit</form:button>
</form:form>

</body>
</html>
