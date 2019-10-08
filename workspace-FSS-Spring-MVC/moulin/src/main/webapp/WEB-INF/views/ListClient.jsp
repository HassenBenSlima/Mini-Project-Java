<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
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
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppClient?CIN="+id;
	     alert("suppression reussite");
		 
	  }
	  
	  
  }

</script>



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
    <li class="active"><a href="<c:url value="/moulin/Caisse/indexcaisse"/>">Accueil</a></li>
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
      <h2 class="bigtext"><span> Gestion <br/>du Moulin d'Olive</span><br />
       
    </div>
  </div>
 
   <div class="body"><div class="body_resize">
   
   <!---->
   <br>
   <br>
   <table align="left">
   <tr>
   
    <td>

<div align="center" >
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Bienvenue</a>
  <a href="<c:url value="/moulin/Caisse/indexcaisse"/>" class="list-group-item ">La caisse</a>
  <a href="<c:url value="/moulin/moulinClient/index"/>" class="list-group-item ">Ajouter un client</a>
  <a href="<c:url value="/moulin/moulinClient/ALLClient"/>" class="list-group-item active ">Consulter client par CIN</a>
   <a href="<c:url value="/moulin/moulinClient/ALLnameClient"/>" class="list-group-item">Consulter client par nom</a>
  <a href="<c:url value="/moulin/FactureImp/indexfactClient"/>" class="list-group-item ">Consulter factures du client</a>
  <a href="<c:url value="/moulin/moulinEmployer/indexe"/>" class="list-group-item ">Ajouter un employé</a>
  <a href="<c:url value="/moulin/moulinEmployer/ALLEmp"/>" class="list-group-item ">Consulter la liste des employés</a>
</div>
</div>
       </td>
	  
   
   <td>
   </tr>
   </table>
<!--fIN du menu-->

<!-- rechercher-->
	

<div align="center">
<f:form modelAttribute="emplo"  action="clientRechercher" class="form-inline"  method="post"  >
<div class="form-group">
<label>Recherche par CIN:</label>
<f:input path="cinClient" class="form-control" placeholder="CIN client"/>
<f:errors path="cinClient" cssClass="error"></f:errors>  
</div>
    <div class="form-group">
<input type="submit" value="Rechercher" class="btn btn-primary"/> 
</div>

</f:form>

<c:if test="${ empty ep.exception }">


<br><br><br>
   <table width="80%">
<tr><td>
<table class="table table-bordered" width="75%" >

<tr class="bg-success" >
<th>CIN client</th><th>Nom client</th><th>Prenom client</th>
<th>Adresse client</th><th>Téléphone client</th>
<th colspan="2">Action</th>
</tr>

<c:if test="${not empty ep.clt}"> 

<tr>
	
<td><a href="<c:url value="/moulin/FactureImp/chargerFacture?cinClient=${ep.clt.cinClient}"/>">${ep.clt.cinClient}</a></td>
<td style="word-break:break-all;">${ep.clt.nomClient}</td>
<td>${ep.clt.prenomClient}</td>
<td style="word-break:break-all;">${ep.clt.adrClient}</td>
<td>${ep.clt.telClient}</td>

<td><a href="javascript:confirmation('${ep.clt.cinClient}')">Supprimer</a></td>
<td><a href="editClient?CIN=${ep.clt.cinClient}">Modifier</a></td>
</tr>
</c:if>
 
 <c:if test="${ empty ep.clt}"> 

<c:forEach items="${ep.listClient}" var="p" >
<tr>	
<td ><a href="<c:url value="/moulin/FactureImp/chargerFacture?cinClient=${p.cinClient}"/>">${p.cinClient}</a></td>
<td style="word-break:break-all;">${p.nomClient}</td>
<td>${p.prenomClient}</td>
<td style="word-break:break-all;">${p.adrClient}</td>
<td>${p.telClient}</td>

<td><a href="javascript:confirmation('${p.cinClient}')">Supprimer</a></td>
<td><a href="editClient?CIN=${p.cinClient}">Modifier</a></td>
</tr>


</c:forEach>
</c:if>

</table>
 
 </td>
 </tr>
 </table>
 
 <c:if test="${ empty ep.clt}"> 
 
<div align="right" class ="container">
 <ul class="pagination">
<c:forEach begin="0" end="${ep.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==ep.nombrePages}">
<li><span >page ${p}</span></li>
</c:when>
<c:otherwise>
<li><span >
<a href="ALLClient?page=${p}&cinClient=${ep.cinClient}">page ${p}</a>
</span></li>
</c:otherwise>
</c:choose>
</c:forEach>
</ul>
</div>

</c:if>

</c:if>

<c:if test="${not empty ep.exception }">
<div>
  ${ep.exception}
  <script type="text/javascript">  
  
  alert("Client introuvale");
  
  </script>
</div>
</c:if>

</div>
</div>
</div>
</div>
</body>
</html>

