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
<body>



<div class="row">
      <div class="container">
			<h3 class="text-center">Liste des posts</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
					<th>Id</th>
                       <th>Titre</th>
                         <th>Description</th>
                         <th>Date Création</th>
                         <th>Actions</th>
					</tr>
				</thead>
			<tbody>

                 <c:forEach var = "post" items = "${posts}">

						<tr>
						     <td>${post.id}</td>
						       <td class="col-2 text-truncate"><a class="disabledLink" href = "/single_post?postid=${post.id}">${post.title}</a></td>
                               <td className="card-text mb-0">${post.description}</td>
                               <td>${created_at}</td>
						       <td><a href="afficheFormUpdated?userid=${post.id}">Modifier</a></td>
								&nbsp;&nbsp;&nbsp;&nbsp;

                        <td><a class="disabledLink" href = "/delete?userid=${post.id}">Supprimer</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

</body>
</html>