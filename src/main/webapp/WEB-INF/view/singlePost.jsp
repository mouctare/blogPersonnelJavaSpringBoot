<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link rel="stylesheet" type="text/css" href="css/style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet"
 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 	crossorigin="anonymous">
</head>


<div class="row">
      <div class="container">
			<h3 class="text-center">Liste des posts</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>

                       <th>Titre</th>
                         <th>Description</th>
                         <th>Date Création</th>
                         <th>Actions</th>
					</tr>
				</thead>
			<tbody>
      </tr>
       <tr>

         <td class="col-2 text-truncate">${postSingle.title}</td>
         <td className="card-text mb-0">${postSingle.description}</td>
         <td>${created_at}</td>
         <td><a href="afficheFormUpdated?postid=${post.id}">Modifier</a></td>
       								&nbsp;&nbsp;&nbsp;&nbsp;

          <td><a class="disabledLink" href = "/delete?userid=${post.id}">Supprimer</a></td>
         </tr>
      </table>

        <c:choose>
           <c:when test="${empty commentaires}">
            <br></br>
             <h2> Ce post n'a pas été commenté <h2/>
            </c:when>
        <c:otherwise>
            <table style="width:100%">
                <tr>
                  <th>Contenu</th>
                   <th>Nom & Prénom de l'auteur du commentaire </th>
                   <th>Date_de_creation</th>

                 </tr>
                     <c:forEach var = "comment" items = "${commentaires}">
                     <tr>

                       <td>${comment.description}</td>
                        <td>Cet article a été commenté par : ${comment.firstName}  ${comment.last_name}</td>
                         <td>Ce commentaire a été réalisé le : ${comment.created_at}</td>
                       </tr>
                   </c:forEach>

        </c:otherwise>
        </c:choose>

      <br><br>
</body>
</html>