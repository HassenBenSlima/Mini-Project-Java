<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="v"%>

<head>
<title>Maintenance</title>
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
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppMain?idMain="+id;
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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Maintenance <span class="caret"></span></a>
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
   
   <table align="left">
   <tr>
   
    <td>
    <br><br><br>
       <div class="body">
    
        <div align="center">
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href="<c:url value="/moulin/moulinOlive/indexmta"/>" class="list-group-item">Ajouter une maintenance</a>
  <a href="<c:url value="/moulin/moulinOlive/ALLMain"/>" class="list-group-item active">Consulter la liste des maintenances</a>
</div>
</div>
</div>
       </td>
	  
   
   
   <td>
   </tr>
   </table>
<!--fIN du menu-->

<!-- rechercher-->
<div class="row">
<div align="center">
<f:form modelAttribute="mainPF"  action="mainRechercher" class="form-inline" method="post"  >
<div class="form-group">
<label>Recherche par nom:</label>
<f:input path="nameFourn" class="form-control" placeholder="Nom fournisseur"/>
<f:errors path="nameFourn" cssClass="error"></f:errors>
</div>
   <div class="form-group">
<input type="submit" value="Rechercher" class="btn btn-primary"/> 
</div>
</f:form>
<br><br><br>
 <div align="right">  
 
 
   <table width="73%">
<tr><td>

<table class="table table-bordered"  width="75%" >

<tr class="bg-success" >
<!-- <th>Numero maintenance</th> --><th>Description</th><th>Date de maintenance</th><th>Prix de maintenance</th>
<th>Nom fournisseur</th><th>Prenom fournisseur</th>
<th>Téléphone Fournisseur</th><th colspan="2">Action</th>
</tr>


<c:if test="${mainPF.mainByName==null}">

<c:forEach items="${epff}" var="pf" >
<tr>	
<!-- <td>${pf.idMain}</td> -->
<td style="word-break:break-all;">${pf.descpanne}</td>
<td style="word-break:break-all;">${pf.dateMain}</td>
<td >${pf.prixMain}</td>
<td >${pf.fournisseurm.nomFourn}</td>
<td style="word-break:break-all;">${pf.fournisseurm.prenomFourn}</td>
<td style="word-break:break-all;">${pf.fournisseurm.telFourn}</td>


<td><a href="javascript:confirmation('${pf.idMain}')">Supprimer</a></td>
<td><a href="editMain?idMain=${pf.idMain}">Modifier</a></td>
</tr>
</c:forEach>
</c:if>


<c:if test="${   empty mainPF.listmaints}">

<c:forEach items="${ep.listmaints}" var="p" >
<tr>	
<!-- <td>${p.idMain}</td> -->
<td style="word-break:break-all;">${p.descpanne}</td>
<td style="word-break:break-all;">${p.dateMain}</td>
<td >${p.prixMain}</td>
<td> ${p.fournisseurm.nomFourn}</td>
<td style="word-break:break-all;">${p.fournisseurm.prenomFourn}</td>
<td style="word-break:break-all;">${p.fournisseurm.telFourn}</td>


<td><a href="javascript:confirmation('${p.idMain}')">Supprimer</a></td>
<td><a href="editMain?idMain=${p.idMain}">Modifier</a></td>
</tr>
</c:forEach>
</c:if>
</table>
</div>
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
<li><span >
<a href="ALLMain?page=${p}">page ${p}</a>
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
</div></div>
</body>
</html>

