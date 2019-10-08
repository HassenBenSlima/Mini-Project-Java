<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
<%@include file="header.jsp"%>
<div class="container col-md-10 col-md-offset-1">
<div class="panel panel-primary">
	<div class="panel-heading">Recherche des produits</div>
	<div class="panel-body">
<form action="chercher.php" method="get">
<label>motCle</label>
<input type="text" name="motCle" value="${model.motCle}"/>
<button type="submit" class="btn btn-primary">Chercher</button>
</form>


<table class="table table-striped">
<tr>
<th>ID</th><th>Désignation</th><th>Prix</th><th>Quantité</th>
</tr>
<tr>
<c:forEach items="${model.produits}" var="p">
<tr>
<td>${p.id}</td>
<td>${p.designation}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td><a onclick="return confirm('Etes vous sure de vouloir supprimer?')"
href="Supprime.php?id=${p.id}">Supprimer</a></td>

<td><a href="Edit.php?id=${p.id}">Modifier</a></td>


</tr>
</c:forEach>
</tr>
</table>

	</div>
	</div>
</div>
</body>
</html>