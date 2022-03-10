<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link rel="stylesheet" type="text/css" href="css/style.css">


<html>
<head>
<meta charset="UTF-8">
<title>Category - Vue</title>
</head>
<body>

<h2>Categorie enregistrée</h2>

<table style="width:100%">
  <tr>
   <th>Id</th>
     <th>Nom</th>
   </tr>

  <tr>
      <td>${categorie.id}</td>
       <td>${categorie.name}</td>

    </tr>
</table>
<br><br>
Le message: ${message}

</body>
</html>