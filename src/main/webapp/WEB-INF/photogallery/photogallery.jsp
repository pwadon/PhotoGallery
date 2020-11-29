<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhoTo Gallery</title>
</head>
<body>
    <h3>Hello ${name} on photo gallery project main page.</h3>
    <sec:authorize access="hasRole('USER')">
        <c:if test="${galleryAndPhotos.size() > 0}">
            <c:forEach var="gallery" items="${galleryAndPhotos}">
                <div><h3>Gallery : ${gallery.key}</h3></div>
                <c:forEach var="photo" items="${gallery.value}">
                    <img src="data:image/jpg;base64,${photo}" width="240" height="240"/>
                </c:forEach>
            </c:forEach>
        </c:if>
        <c:if test="${galleryAndPhotos.size() == 0}">
            <h4>There are no photos on your gallery</h4>
        </c:if>
    </sec:authorize>
</body>
</html>
