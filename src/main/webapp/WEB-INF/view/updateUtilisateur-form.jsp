<html>
<style>
input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<form:form action="updateForm" modelAttribute="utilisateurModifie">
Prenom: <form:input path= "first_name" />
<br><br>
<form:hidden path= "id" />
<br><br>
<br><br>
Prenom: <form:input path= "last_name" />
<br><br>
<br><br>
 Email: <form:input path="email"/>
<br><br>
<br><br>
Mot de passe: <form:input path="password"/>
<br><br>
<input type="submit" value="Submit"/>
</form:form>
</html>