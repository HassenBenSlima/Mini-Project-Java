<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Factures Client</title>

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
		 document.location="suppFacture?idfacture="+id;
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

      <div class="logo_text"><a href="http://localhost:8082/ml/FactureImp/indexfac">Commande</a> | <a href="<c:url value="/j_spring_security_logout" />" >Deconnection</a></div>
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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Commande<span class="caret"></span></a>
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
 
   
   <!---->
   <div>
   <br/>
   <br/>
   <table align="left">
   <tr>
   
    <td>
       <div class="body"><div class="body_resize">
    
   <div align="center">
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href="<c:url value="/moulin/FactureImp/indexfactClient"/>" class="list-group-item active">Consulter factures du client</a>
   <a href="<c:url value="/moulin/moulinClient/ALLnameClient"/>" class="list-group-item">Consulter client par nom</a>
 
  <a href="<c:url value="/moulin/moulinClient/ALLClient"/>" class="list-group-item ">Consulter client par CIN</a>
       </div>
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

<f:form method="post" action="chargerFacture" class="form-inline"  modelAttribute="factcl">
<div class="form-group">

<label>Tapez le Cin du Client: </label>
<f:input path="cinClient" class="form-control" placeholder="Cin client"/>
<f:errors path="cinClient" cssClass="error"></f:errors>
</div>
  <div class="form-group">
<input type="submit" value="Rechercher" class="btn btn-primary"/>
</div>
</f:form>

<c:if test="${not empty factcl.client}"> <!-- quant le compte est not vide -->

<table width="80%">
<tr><td>
<div>
<table>
<tr>
<td style="font-size:140%;">Numero de carte d'identité : </td>
<td style="font-size:125%;">${factcl.client.cinClient}</td>
</tr>
<tr>
<td style="font-size:140%;">Nom du client:</td>
<td style="font-size:125%;">${factcl.client.nomClient} </td>
</tr> 
<tr>
<td style="font-size:140%;">Prenom du client: </td>
<td style="font-size:125%;">${factcl.client.prenomClient}</td>
</tr>
<tr>
<td style="font-size:140%;">Adresse du client:</td>
<td style="font-size:125%;">${factcl.client.adrClient}</td>
</tr>
<tr>
<td style="font-size:140%;">Numero du téléphone:  </td>
<td style="font-size:125%;">${factcl.client.telClient}</td>
</tr> 
</table>
</div>
<br><br>
<table class="table table-bordered" width="75%" >
<tr class="bg-success">
<th>Type de reglement</th><th>Date</th><th>Montant</th>
<th>Quantité</th><th>description</th><th colspan="2">Action</th>
</tr>

<c:forEach items="${factcl.factureClient}" var="fc" >
<tr>
<td>${fc.typeReglement}</td>
<td>${fc.dateVente}</td>
<td>${fc.montantf}</td>
<td>${fc.quantite}</td>
<td>${fc.designation}</td>
<td><a href="javascript:confirmation('${fc.idVente}')">Suppimer</a></td>
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
<li><span class ="current">page ${p}</span></li>
</c:when>
<c:otherwise>

<li><span>
<a href="chargerFacture?page=${p}&cinClient=${factcl.cinClient}">page ${p}</a>
</span></li>

</c:otherwise>
</c:choose>

</c:forEach>
</ul>
</div>
</c:if>
<c:if test="${not empty factcl.exception }">
<div>
  ${factcl.exception}
</div>

</c:if>

</div>
</div>
</div>

</body>
</html>