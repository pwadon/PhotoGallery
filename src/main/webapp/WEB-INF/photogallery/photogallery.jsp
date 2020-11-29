<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhoTo Gallery</title>
</head>
<body>
    <h3>Hello ${name} on photo gallery project main page.</h3>
    <sec:authorize access="isAnonymous()">
        <h5>Login to browse your gallery.</h5>
    </sec:authorize>
</body>
</html>

//dodac opcje wyswietlania galerii dla uzytkownika i zdjec w galerii
