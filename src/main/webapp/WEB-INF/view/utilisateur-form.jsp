<html>

<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
 <link rel="stylesheet" type="text/css" href="css/user.css">

<form:form action="processForm" modelAttribute="utilisateur">
   Nom: <form:input path="first_name" />
   <br><br>
     Prenom: <form:input path="last_name" />
    <br><br>
    <br><br>
     Email: <form:input path="email" />
    <br><br>
   <br><br>
     Mot de passe: <form:input path="password" />
    <br><br>
<input type="submit" value="Submit"/>
</form:form>
</html>