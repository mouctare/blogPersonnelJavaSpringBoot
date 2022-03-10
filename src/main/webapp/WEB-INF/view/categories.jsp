<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link rel="stylesheet" type="text/css" href="css/style.css">


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h2>Liste des categories</h2>

<table style="width:100%">
  <tr>
    <th>Id</th>
     <th>Nom</th>
   </tr>
  <c:forEach var = "categorie" items = "${categories}">

  <tr>
    <td>${categorie.id}</td>
    <td>${categorie.name}</td>
  </tr>
 </c:forEach>
</table>
</body>
</html>