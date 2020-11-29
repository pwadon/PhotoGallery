<%--
  Created by IntelliJ IDEA.
  User: Paladyn
  Date: 2020-11-29
  Time: 00:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 class="card-title">gallery name : ${gallery.getName()} </h3>
<h4 class="card-text">user : ${gallery.getUser().getLogin()} </h4>
<h4>${message}</h4>

<form method="POST"
      action="/photogallery/admin/gallery/${gallery.getId()}"
      cssClass="container col-6"
      enctype="multipart/form-data">
    <input  required="required" type="file" name="file" />
    <button type="submit">Submit</button>
</form>
</body>
</html>
