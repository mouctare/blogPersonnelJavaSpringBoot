<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border:1px solid black;
}
</style>
</head>
<body>

<h2>Liste des utilisateurs</h2>
<br/>
<c:forEach var = "utilisateur" items = "${utilisateurs}">
<table style="width:100%>
  <tr>
   <th>Id</th>
     <th>Nom</th>
     <th>Prenom</th>
     <th>email</th>
     <th>Mot de passe</th>
  </tr>
  <tr>
    <td>${utilisateur.id}</td>
    <td>${utilisateur.first_name}</td>
    <td>${utilisateur.last_name}</td>
     <td>${utilisateur.email}</td>
      <d>${utilisateur.password}</td>
    </tr>
</table>
</c:forEach>
</body>
</html>