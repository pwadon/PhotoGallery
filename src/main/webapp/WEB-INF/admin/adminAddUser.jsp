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
            <form:input path="login" cssClass="form-input" placeholder="login"/>
            <form:errors path="login" cssClass="alet alert-danger" element="div"/>
            <form:password path="password" cssClass="form-input" placeholder="password"/>
            <form:errors path="password" cssClass="alet alert-danger" element="div"/>
            <form:button>submit</form:button>
</form:form>
// dodac delete z listy userow

<%--<form:form method="DELETE"--%>
<%--                       action="Users"--%>
<%--                       modelAttribute="Users">--%>

<%--    <form:label path="Users">user</form:label>--%>
<%--    <form:select path="Users" items="${Users.login}" cssClass="form-input"/>--%>
<%--    <form:button>delete</form:button>--%>
<%--</form:form>--%>

</body>
</html>
