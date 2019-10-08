<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html >
<html>
<head>
<title>Gestion du Moulin</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/datepicker.css"/>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" />

<!--Style Template-->
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" />
   <!-- Custom CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
<!--Fin Style-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-iso.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap-tabdrop.js"></script>

<!-- Menu -->
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
 <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>


<script src="<%=request.getContextPath()%>/resources/js/bootstrap-datepicker.js"></script>

</head>
<script type="text/javascript">

jQuery( document ).ready(function( ) {

   $("#p").hide();

});
</script>


<body>

<!-- START PAGE SOURCE -->
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
       <h1> <a href="<c:url value="/moulin/Caisse/indexcaisse"/>"><small>Societé</small>
          Moulin d'olive.</a></h1><br/><br />
      </div>

        <div class="logo_text"><a href="<c:url value="/moulin/FactureImp/indexfac"/>">Commande</a> | <a href="<c:url value="/j_spring_security_logout" />" >Deconnection</a></div>

      <div class="clr"></div>
    </div>
	
		  <div>
	  
<!--Menu-->
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="<c:url value="/moulin/Caisse/indexcaisse"/>">Accueil</a></li>
    <li class="dropdown">
     <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Reservations <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinOlive/indexr"/>">Ajouter une réservation</a></li>
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

   <!--Gestion du molin d'olive-->


    <div class="headert_text_resize">
     
      <div class="clr"></div>
      <h2 class="bigtext"><span> Gestion <br/>du Moulin d'Olive</span></h2>
       
    </div>
  </div>
 <!--Fin Gestion du molin d'olive-->
<div class="body"><div class="body_resize">
  <!--Menu left-->
   
   <table align="left">
   <tr>
   
    <td>
   <br/>
<div class="body"><div class="body_resize">
 
   <div align="center" >
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Bienvenue</a>
  <a href="<c:url value="/moulin/Caisse/indexcaisse"/>" class="list-group-item active">La caisse</a>
  <a href="<c:url value="/moulin/moulinClient/index"/>" class="list-group-item ">Ajouter un client</a>
  <a href="<c:url value="/moulin/moulinClient/ALLClient"/>" class="list-group-item  ">Consulter la liste des client</a>
  <a href="<c:url value="/moulin/moulinEmployer/indexe"/>" class="list-group-item">Ajouter un employé</a>
  <a href="<c:url value="/moulin/moulinEmployer/ALLEmp"/>" class="list-group-item">Consulter la liste des employés</a>
</div>

</div>
</div>
</div>
       </td>
		  
   
   <td>
   </tr>
   </table>
   
   <!--Menu left-->
   
   <!--Code  J2ee-->
   
   <table width="55%" align="center">
   <tr>
   <td>
      <h2>La caisse</h2>

<!--Formulaire J2ee-->

<div align="center" class="lead bg-info">
${error}
</div>

<!-- ajouter montant-->
<f:form modelAttribute="caisa" action="AjouterArgent"  method="post" enctype="multipart/form-data">
<table align="center" width="100%">
<tr>
<td>
<div class="form-group">
<label for="Budget">Budget</label> 
 <div class="input-group">
<div class="input-group-addon">DT</div><f:select class="form-control" path="idCaisse"  items="${cs}" itemValue="idCaisse" itemLabel="solde"></f:select>
<div class="input-group-addon">.00</div></div><f:errors path="idCaisse" cssClass="errors"></f:errors>
</div>
<td>
</tr>

<tr>
<td>
<div class="form-group">
  
    <label for="Montant" > Montant:</label>
    <f:input path="montantAjouter" class="form-control"  />
    <f:errors path="montantAjouter" cssClass="errors"></f:errors>  
  </div>

<input type="submit" value="Ajouter argent" class="btn btn-primary"/>  

</td>
</tr>
</table>
</f:form>
<hr/>
<br/>
<!-- Retier montant  -->

<f:form modelAttribute="caisr" action="RetirerArgent"  method="post" enctype="multipart/form-data">
<table align="center" width="100%">
<tr>
<td>
<div class="form-group">
<f:select class="form-control" path="idCaisse" id="p" items="${cs}" itemValue="idCaisse" itemLabel="solde"></f:select>
<f:errors path="idCaisse" cssClass="errors"></f:errors>
</div>
</td>
<tr>
<td>
<div class="form-group">
    <label for="Ajouter huile">Montant:</label>
    <f:input path="montantRetirer" class="form-control"  />
    <f:errors path="montantRetirer" cssClass="errors"></f:errors>  
  </div>
  
<input type="submit" value="Retirer argent" class="btn btn-primary"/><hr>

</td>
</tr>
</table>
</f:form>





<!--Fin Formulaire J2ee-->
   
	
	  </td>
  </tr>
	  </table>
	  </div></div>
	</div>  
	  <div>
	   </div>

</body>
</html>