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
        <h4 class="card-title">gallery name : ${gallery.name} </h4>
        <p class="card-text">user : ${gallery.getUser().getLogin()} </p>
        <p><a href="http://localhost:8080/photogallery/admin/gallery/${gallery.id}">Add photos to Gallery</a></p>
    </div>
</div>
</c:forEach>


</body>
</html>
