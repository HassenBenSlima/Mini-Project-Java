<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<title>Reservation</title>
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

<script type="text/javascript">

$(function(){
	
	$('.datepicker').datepicker(
			{
				format:'dd/mm/yyyy'
			});	
});

</script>

<script type="text/javascript">
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppRsv?idRsv="+id;
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
          Moulin d'olive.</a></h1><br><br />
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
     <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active"> Reservations <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinOlive/indexr"/>">Ajouter une reservation</a></li>
        <li><a href="<c:url value="/moulin/moulinOlive/ALLR"/>">Consulter les reservations</a></li>                        
     
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Commande<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/FactureImp/indexfac"/>">Ajouter une commande</a></li>
        <li><a href=" <c:url value="/moulin/FactureImp/indexfactClient"/>">Factures  du client</a></li>                        
      </ul>
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Achat d'olive<span class="caret"></span></a>
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
   <br>
   <br>
   <div class="body">
   <table align="left">
   <tr>
   
    <td>
       <div class="body">
<div class="body_resize">
   <div align="center">
        <div class="list-group">
  <a href="#" class="list-group-item disabled"><center>Sous menu</center></a>
  <a href="<c:url value="/moulin/moulinOlive/indexr"/>" class="list-group-item ">Ajouter une réservation </a>
  <a href="<c:url value="/moulin/moulinOlive/ALLR"/>" class="list-group-item active">Consulter la liste des réservations</a> 
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
<f:form modelAttribute="frol"  action="folRechercher" class="form-inline"  method="post"  >

<div class="input-group">
<div class="input-group-addon">
         <i class="fa fa-calendar">
         Agenda</i>
        </div>
<f:input path="dateRsv" class="datepicker"  size="50" length="16"  placeholder="Recherche par date"/></div>
<div><f:errors path="dateRsv" cssClass="error"></f:errors></div>  
</f:form>
<br><br>

   <table width="75%">
<tr><td>
<table class="table table-bordered" width="75%" >

<tr class="bg-success" >
<!-- <th>Numero reservation</th> --><th>Prix</th><th>Date reseration</th><th>Description</th>
<th>CIN du client</th><th>Nom du client</th>
<th>Prenom du client</th><th>Téléphone client</th>
<th colspan="2">Action</th>
</tr>

<c:if test="${frol.rsvByDat==null}">
<c:forEach items="${epff}" var="pf" >
<tr>	
<!-- <td>${pf.idRsv}</td> -->
<td>${pf.prixRsv}</td>
<td>${pf.dateRsv}</td>
<td style="word-break:break-all;">${pf.descriptionRsv}</td>
<td>${pf.client.cinClient}</td>
<td>${pf.client.nomClient}</td>
<td>${pf.client.prenomClient}</td>
<td>${pf.client.telClient}</td>
<td><a href="javascript:confirmation('${pf.idRsv}')">Supprimer</a></td>
<td><a href="editRsv?idRsv=${pf.idRsv}">Modifier</a></td>
</tr>
</c:forEach>
</c:if>


<c:if test="${empty frol.listRsv}">


<c:forEach items="${ep.listRsv}" var="pf" >
<tr>	
<!-- <td>${pf.idRsv}</td> -->
<td>${pf.prixRsv}</td>
<td>${pf.dateRsv}</td>
<td style="word-break:break-all;">${pf.descriptionRsv}</td>
<td>${pf.client.cinClient}</td>
<td>${pf.client.nomClient}</td>
<td>${pf.client.prenomClient}</td>
<td>${pf.client.telClient}</td>
<td><a href="javascript:confirmation('${pf.idRsv}')">Supprimer</a></td>
<td><a href="editRsv?idRsv=${pf.idRsv}">Modifer</a></td>
</tr>
</c:forEach>
</c:if>
</table>
</td>
</tr>
</table>

<div align="right" class ="container">
<ul class="pagination">
<c:forEach begin="0" end="${ep.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==ep.nombrePages}">
<li><span >page ${p}</span></li>
</c:when>
<c:otherwise>
<li><span>
<a href="ALLR?page=${p}">page ${p}</a>
</span></li>
</c:otherwise>
</c:choose>
</c:forEach>
</ul>
</div>


<c:if test="${not empty ep.exception }">
<div>
  ${ep.exception}
</div>
</c:if>

</div>
</div>
</div>
</body>
</html>

