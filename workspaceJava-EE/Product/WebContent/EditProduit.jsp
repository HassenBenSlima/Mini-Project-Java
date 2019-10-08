<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie Produit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>

<%@include file="header.jsp"%>
<div class="container col-md-8  col-md-offset-2 col-xs-12">
<div class="panel panel-primary">
	<div class="panel-heading">Saisie d'un produit</div>
		<div class="panel-body">
	
	<form action="UpdateProduit.php" method="post">
	
	<div class="form-group">
	<label class="control-label">ID</label>
	<input type="text" name="id" class="form-control" value="${produit.id}" required="required"/>
	<span></span>
	</div>
	
	<div class="form-group">
	<label class="control-label">Désignation</label>
	<input type="text" name="designation" class="form-control" value="${produit.designation}" required="required"/>
	<span></span>
	</div>
	
	<div class="form-group">
	<label class="control-label">Prix</label>
	<input type="text" name="prix" class="form-control" value="${produit.prix}"/>
	<span></span>
	</div>
		
	<div class="form-group">
	<label class="control-label">Quantité</label>
	<input type="text" name="quantite" class="form-control" value="${produit.quantite}"/>
	<span></span>
	</div>
		
	<div>
	<button type="submit" class="btn btn-primary">Save</button>
	</div>
	
	
	
	</form>
	
	
	
	
	
		</div>
	</div>
</div>
	

</body>
</html>