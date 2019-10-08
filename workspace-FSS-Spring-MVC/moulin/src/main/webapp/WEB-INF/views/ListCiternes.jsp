<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Citerne</title>

<title>Recherche Citerne</title>
<!--Style Template-->
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" />
   <!-- Custom CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
<!--Fin Style-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-iso.css"/>

<!-- Menu -->
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
 <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/resources/js/bootstrap-datepicker.js"></script>

<script type="text/javascript">
  function confirmation(code){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppCiterne?code="+code;
	     alert("suppression reussite");

	  }
  }

</script>

</head>
<body>	

<div >
${exception}
</div>

 <!--DEBUT du menu-->
 <body>


<!-- START PAGE SOURCE -->
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
       <h1> <a href="#"><small>Societé</small>
          Moulin d'olive.</a></h1></br><br />
      </div>

      <div class="logo_text"><a href="<c:url value="/moulin/FactureImp/indexfac"/>">Commande</a> | <a href="<c:url value="/j_spring_security_logout" />" >Deconnection</a></div>
      <div class="clr"></div>
    </div>
	
		  <div>
	  
 <!--Menu-->
<div class="container">
  <ul class="nav nav-tabs">
    <li class=""><a href="<c:url value="/moulin/Caisse/indexcaisse"/>">Accueil</a></li>
    <li class="dropdown">
     <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Reservations <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinOlive/indexr"/>">Ajouter reservation</a></li>
        <li><a href="<c:url value="/moulin/moulinOlive/ALLR"/>">Consulter les reservations</a></li>                        
     
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Commande<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/FactureImp/indexfac"/>">Ajouter une commande</a></li>
        <li><a href=" <c:url value="/moulin/FactureImp/indexfactClient"/>">Factures du client</a></li>                        
      </ul>
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Achat d'olive <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinBonAchat/indexba"/>">Ajouter un achat</a></li>
        <li><a href="<c:url value="/moulin/moulinBonAchat/indexfrnsbonachat"/>">Bons d'achats du fournisseur</a></li>  
        <li><a href="<c:url value="/moulin/moulinFrns/ALLFOL"/>">Consulter les fournisseurs</a></li>  		
      </ul>
      
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Maintenance <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinOlive/indexmta"/>">Ajouter une maintenance</a></li>
        <li><a href="<c:url value="/moulin/moulinOlive/ALLMain"/>">Consulter les maintenances</a></li>                        
      <li><a href="<c:url value="/moulin/moulinFrns/ALLFO"/>">Consulter les fournisseurs</a></li> 
	  </ul>
	  
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Fournisseurs <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinFrns/indexfm"/>">Fournisseur de maintenance</a></li>
        <li><a href="<c:url value="/moulin/moulinFrns/indexfo"/>">Fournisseur d'olive</a></li>                        
      </ul>

    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Stock <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinStock/indexv"/>">Stock d'olive</a></li>
        <li><a href="<c:url value="/moulin/moulinStock/indexc"/>">Stock d'huile</a></li>                        
        <li><a href="<c:url value="/moulin/moulinStock/indexhuile"/>">Gerer le stock</a></li>                        
      
      </ul>
    </li>
	<!--<li><a href="#">Menu 2</a></li>-->
  </ul>
</div>
<!--Fin Menu-->


</div>
    <div class="headert_text_resize">
     
      <div class="clr"></div>
      <h2 class="bigtext"><span> Gestion <br/>du Moulin d'Olive</span></h2>
       
    </div>
  </div>
 
   
   <!---->
   <div>
   </br>
   </br>
   <table align="left">
   <tr>
   
    <td>
            <div class="body"><div class="body_resize">
   
<div align="center">
        <div class="list-group">
  <a href="#" class="list-group-item disabled"><center>Sous menu</center></a>
  <a href="<c:url value="/moulin/moulinStock/indexc"/>" class="list-group-item ">Ajouter une citerne</a>
  <a href="<c:url value="/moulin/moulinStock/ALLCiterne"/>" class="list-group-item active ">Consulter la liste des citernes</a>
  <a href=" <c:url value="/moulin/moulinStock/indexhuile" />" class="list-group-item ">Gérer le stock </a>

</div>
</div>
</div></div>
       </td>
	  
   
   <td>
   </tr>
   </table>
<!--fIN du menu-->
 
 
 
 
 
<!-- rechercher--> 
<center>
<f:form modelAttribute="ctrn"  action="citerneRechercher" class="form-inline" method="post"  >
<div class="form-group">

<label>Recherche par reference:</label>
<f:input path="codeStock" class="form-control" placeholder="Reference citerne"/>
<f:errors path="codeStock" cssClass="error"></f:errors>
</div>
  <div class="form-group">
<input type="submit" value="Rechercher" class="btn btn-primary"/>
</div> 
</f:form>

<!--fin rechercher------>
   
   <br>
   <br>
   <br>
   <br>
   
   <center>
<table width="80%">
<tr>
<td>
<table  class="table table-bordered" width="75%">
<tr class="bg-success">

<th>Reference du citerne </th><th> Capacité</th><th>Prix unitaire</th>
<th>Quantite huile</th><th>qualite huile</th><th colspan="2">Action</th>
</tr>

<c:if test="${ not  empty ctrn.citerneByName}"></c:if>
<c:forEach items="${cit}" var="cc" >

<tr>
<td style="word-break:break-all;">${cc.codeStock}</td>
<td>${cc.capacite}</td>
<td>${cc.prixUT}</td>
<td>${cc.quantiteHuile}</td>
<td>${cc.qualiteHuile}</td>

<td><a href="javascript:confirmation('${cc.codeStock}')">Supprimer</a></td>
<td><a href="editCiterne?code=${cc.codeStock}">Modifier</a></td>
</tr>
</c:forEach>
<c:if test="${ not empty citern.ctrns}"> 

<c:forEach items="${citern.ctrns}" var="cc" >
<tr>
<td style="word-break:break-all;">${cc.codeStock}</td>
<td>${cc.capacite}</td>
<td>${cc.prixUT}</td>
<td>${cc.quantiteHuile}</td>
<td>${cc.qualiteHuile}</td>
<td><a href="javascript:confirmation('${cc.codeStock}')">Supprimer</a></td>
<td><a href="editCiterne?code=${cc.codeStock}">Modifier</a></td>
</tr>
</c:forEach>
</c:if>
</table>
</td>
</tr>
</table>

<div align="right" class ="container">
<ul class="pagination" >
<c:if test="${ not empty citern.ctrns}"> 

<c:forEach begin="0" end="${citern.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==citern.nombrePages}">
<li><span >page ${p}</span>
</li></c:when>
<c:otherwise>
<li><span >
<a href="ALLCiterne?page=${p}&codeStock=${citern.codeStock}">page ${p}</a>
</span></li>
</c:otherwise>
</c:choose>
</c:forEach>

</c:if>
</ul>
</div>
<c:if test="${  not empty ctrn.exception}">
<div>
  ${ctrn.exception}
<script>
    
  alert("Citerne introuvable");
 
 </script>
</div>

</c:if>

	


</body>
</html>