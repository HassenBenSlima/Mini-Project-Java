<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bon Achat par fournisseur</title>

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
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppBA?idBA="+id;
		 alert("suppression reussite");
	  }
	 
  }

</script>

</head>

 <!--DEBUT du menu-->
 <body>


<!-- START PAGE SOURCE -->
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
       <h1> <a href="<c:url value="/moulin/Caisse/indexcaisse"/>"><small>Societé</small>
          Moulin d'olive.</a></h1><br><br>
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
        <li><a href="<c:url value="/moulin/moulinOlive/indexr"/>">Ajouter une reservation</a></li>
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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Achat d'olive<span class="caret"></span></a>
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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Stock <span class="caret"></span></a>
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
 
   <div class="body">
   <!---->
   <div>
   <br/>
   <br/>
   <table align="left">
   <tr>
   
    <td>
<div class="body_resize">
   
    <div align="center" >
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href="<c:url value="/moulin/moulinBonAchat/indexba"/>" class="list-group-item">Ajouter un achat </a>
  <a href="<c:url value="/moulin/moulinBonAchat/indexfrnsbonachat"/>" class="list-group-item active">Consulter bons par fournisseur</a>
  <a href="<c:url value="/moulin/moulinFrns/ALLFOL"/>" class="list-group-item">Consulter la liste des fournisseurs</a>
        </div>
     </div>

</div>
       </td>
	  
   
   <td>
   </tr>
   </table>
<!--fIN du menu-->



<!-- rechercher-->

<div align="center">

<f:form method="post" action="chargerBon"  class="form-inline" modelAttribute="factcl">
<div class="form-group">
<label>Tapez le Cin de Fournisseur </label>
<f:input path="cinFourn" class="form-control " placeholder="CIN fournisseur"/>
<f:errors path="cinFourn" cssClass="error"></f:errors>
</div>
<div class="form-group">
<input type="submit" value="Rechercher" class="btn btn-primary"/>
</div>
</f:form>
<br><br><br>

<c:if test="${not empty factcl.fro}"> <!-- quant le compte est not vide -->

<table width="80%">
<tr><td>
<table>
<tr>
<td style="font-size:140%;">Numero de carte d'identité: </td>
<td style="font-size:125%;">${factcl.fro.cinFourn}</td>
</tr>
<tr>
<td style="font-size:140%;">Nom du Fournisseur:</td>
<td style="font-size:125%;">${factcl.fro.nomFourn} </td>
</tr> 
<tr>
<td style="font-size:140%;">Prenom du Fournisseur: </td>
<td style="font-size:125%;">${factcl.fro.prenomFourn}</td>
</tr>
<tr>
<td style="font-size:140%;">Adresse du Fournisseur:</td>
<td style="font-size:125%;">${factcl.fro.adrFourn}</td>
</tr>

</table>

<br>

<table class="table table-bordered" width="75%" >
<tr class="bg-success">
<!-- <th>Numero</th> --><th>Date</th><th>Montant d'achat</th>
<th>Maturité d'olive</th><th>quantité d'olive</th><th>Region</th>
<th>Description</th><th>Nom de cuve</th><th colspan="2">Action</th>
</tr>

<c:forEach items="${factcl.listbons}" var="fc" >
<tr>
<!-- <td>${fc.idBA}</td> -->
<td>${fc.dateBA}</td>
<td>${fc.montantAchat}</td>
<td>${fc.maturite}</td>
<td>${fc.quantiteOL}</td>
<td>${fc.regionOlive}</td>
<td>${fc.designation}</td>
<td>${fc.stocko.codeStock}</td>
<td><a href="javascript:confirmation('${fc.idBA}')">Supprimer</a></td>
<td><a href="editBA?idBA=${fc.idBA}">Modifier</a></td>
</tr>
</c:forEach>
</table>
</td>
</tr>
</table>
 <div align="right" class ="container">
 
 <ul class="pagination">
<c:forEach begin="0" end="${factcl.nombrePages-1}" var="p"> 

<c:choose>
<c:when test="${p==factcl.nombrePages}">
<li><span >page ${p}</span></li>
</c:when>
<c:otherwise>

<li><span class="autrePage">
<a href="chargerBon?page=${p}&cinFourn=${factcl.cinFourn}">page ${p}</a>
</span></li>

</c:otherwise>
</c:choose>

</c:forEach>
</ul>
</div>
</c:if>
</div>
<c:if test="${not empty factcl.exception }">
<div>
  ${factcl.exception}
</div>

</c:if>

</div>
</div>
</body>
</html>