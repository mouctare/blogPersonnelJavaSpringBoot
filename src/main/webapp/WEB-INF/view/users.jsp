<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
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
			<h3 class="text-center">Liste des Utilisateurs</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>

                       <th>Nom</th>
                         <th>Prenom</th>
                         <th>email</th>
                         <th>Actions</th>
					</tr>
				</thead>
				<tbody>


					  <c:forEach var = "utilisateur" items = "${utilisateurs}">

						<tr>
				             <td><a class="disabledLink" href = "/afficheUtilisateur?userid=${utilisateur.id}">${utilisateur.last_name}</a></td>
                               <td>${utilisateur.first_name}</td>
                               <td>${utilisateur.email}</td>

					           <td><a href="afficheFormUpdated?userid=${utilisateur.id}">Modifier</a></td>
								&nbsp;&nbsp;&nbsp;&nbsp;

                        <td><a class="disabledLink" href = "/delete?userid=${utilisateur.id}">Supprimer</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

</body>
</html>