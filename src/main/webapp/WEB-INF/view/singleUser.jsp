<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link rel="stylesheet" type="text/css" href="css/post.css">


<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>
<br/>
<table class="tab">
  <h2>Voici le detail de utilisateur avec les articles qu'il a créés</h2>
   <tr>
       <th>Nom</th>
        <th>Prenom</th>
        <th>Email</th>

      </tr>
        <tr>
          <th>${utilisateur.first_name}</th>
          <th>${utilisateur.first_name}</th>
          <th>${utilisateur.email}</th>
        </tr>
      </table>

        <c:choose>
           <c:when test="${empty utilisateur.posts}">
            <br></br>
             <h2> Ce utilisateur n'a pas écrit d'article<h2/>
            </c:when>
        <c:otherwise>
            <table style="width:100%">
                <tr>
                  <th>Titre</th>
                  <th>Description</th>
                   <th>Date_de_creation</th>
                 </tr>
                     <c:forEach var = "post" items = "${utilisateur.posts}">
                     <tr>
                       <td>${post.title}</td>
                        <td>${post.description}</td>
                        <td>${post.created_at}</td>
                       </tr>
                   </c:forEach>

        </c:otherwise>
        </c:choose>
<br><br>
</body>
</html>