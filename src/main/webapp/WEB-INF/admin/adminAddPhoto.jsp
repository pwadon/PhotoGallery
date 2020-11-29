<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paladyn
  Date: 2020-11-29
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${galleries}" var="gallery">
<div class="card border-secondary mb-3" style=" float:left; width: 32rem; height: 28%; overflow: auto; margin-bottom:-60px;">
    <div class="card-header"></div>
    <div class="card-body">
        <h4 class="card-title">fajnie by bylo tutaj dac usera </h4>
        <p class="card-text">gallery name : ${gallery.name} </p>
        <p><a href="http://localhost:8080/photogallery/admin/gallery/${gallery.id}">Show Gallery</a></p>
    </div>
</div>
</c:forEach>

<%--<form:form modelAttribute="gallery" action="photo" method="get" >--%>
<%--    <form:select name="gallery" path="gallery">--%>
<%--        <c:forEach items ="${galleries}" var ="gallery">--%>
<%--            <form:option value="${gallery.id}">${gallery.name}</form:option>--%>
<%--        </c:forEach>--%>
<%--        <form:button>submit</form:button>--%>
<%--    </form:select>--%>
<%--    </form:form>--%>

</body>
</html>
