<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exemple</title>
</head>
<body>
	<%
		String login = request.getParameter("login");

		String erreur = (String) request.getAttribute("erreur");
		if (erreur != null)
	%>
	<h1 style="color: red">
		<%=erreur%>

		<h1>Authentification :</h1>
		<form method='post' action='AuthControle'>
			Login : <input type='text' name='login' 
			value=<%=((login != null) ?login : "")  %> /><br> 
			MP : <input type='text' name='mp' /><br>
			 <input type='submit' value='Go' />
		</form>
		 

		<form method='post' action='Inscription'>

			<input type='submit' value='Inscription' />
		</form>
</body>
</html>