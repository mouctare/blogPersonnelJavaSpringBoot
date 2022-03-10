<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link rel="stylesheet" type="text/css" href="css/style.css">


<html>
<head>
<meta charset="UTF-8">
<title>Article Crée</title>
</head>
<body>

<h2>Utilisateur enregistré</h2>

<table style="width:100%">
  <tr>
     <th>Titre</th>
     <th>Description</th>
     <th>Date création</th>

  </tr>

  <tr>
      <td>${post.title}</td>
       <td>${post.description}</td>
       <td>${post.created_at}</td>
    </tr>

</table>
<br><br>
Le message: ${message}

</body>
</html>