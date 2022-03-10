<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link rel="stylesheet" type="text/css" href="css/style.css">


<html>
<head>
<meta charset="UTF-8">
<title> Utilisateur - Vue</title>
</head>
<body>

<h2>Utilisateur enregistré</h2>

<table style="width:100%">
  <tr>

     <th>Nom</th>
     <th>Prenom</th>
     <th>email</th>
  </tr>

  <tr>
     <td>${utilisateur.first_name}</td>
       <td>${utilisateur.last_name}</td>
       <td>${utilisateur.email}</td>

    </tr>

</table>
<br><br>
Le message: ${message}

</body>
</html>