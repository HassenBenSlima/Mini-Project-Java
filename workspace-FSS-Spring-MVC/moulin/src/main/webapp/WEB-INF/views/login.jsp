<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
    <title>Bienvenue</title>

    <!-- Bootstrap core CSS -->
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    

  </head>

  <body  >
  
  <div class="alert alert-success" role="alert"><center><h1>Gestion du Moulin d'Olive</h1></center></div>
  <table width="75%">
  <tr>
  <td>
  <img src="<%=request.getContextPath()%>/resources/images/huile.png" />
  
  </td>
  
  
  <td>

    
 <!--  FORMULAIRE Authentification :-->





<h2 >Authentification :</h2>


<form action="j_spring_security_check" method="post">


<input type="text" name="j_username" class="form-control"  placeholder="Login" required autofocus >

<br>
<input type="password" name="j_password" class="form-control" placeholder="Mot de passe" required >


 <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Enregistrer
          </label>
        </div>
       

<input type="submit" value="Connexion" class="btn btn-lg btn-primary btn-block">




</form>

	    <!-- FIN FORMULAIRE-->
</td>
</tr>
</table>
  </body>
</html>
