<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${message}</h2>
<span>Gallery:</span><span>${gallery.name}</span>


<form:form method="POST"
           action="galleries"
           modelAttribute="gallery"
           cssClass="container col-6"
           enctype="multipart/form-data">

    <form:label path="name">name</form:label>
    <form:input path="name" cssClass="form-input" placeholder="name"/>
    <form:button>submit</form:button>
</form:form>
</body>
</html>
