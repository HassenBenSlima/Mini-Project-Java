<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<meta charset="UTF-8">
<title>Recherche Fourniseur Olive</title>

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

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

<script type="text/javascript">
  function confirmation(cin){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppFrnsO?CINFO="+cin;
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
        <li><a href="<c:url value="/moulin/moulinOlive/indexr"/>">Ajouter une reservation</a></li>
        <li><a href="<c:url value="/moulin/moulinOlive/ALLR"/>">Consulter les reservations</a></li>                        
     
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Commande<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/FactureImp/indexfac"/>">Ajouter une commande</a></li>
        <li><a href=" <c:url value="/moulin/FactureImp/indexfactClient"/>">Factures une client</a></li>                        
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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Fournisseurs <span class="caret"></span></a>
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
   
   <table align="left">
   <tr>
   
    <td>
         <div class="body"><div class="body_resize">
   
<div align="center" >
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href="<c:url value="/moulin/moulinBonAchat/indexba"/>" class="list-group-item ">Ajouter un achat </a>
  <a href="<c:url value="/moulin/moulinBonAchat/indexfrnsbonachat"/>" class="list-group-item ">Consulter bons par fournisseur</a>
  <a href="<c:url value="/moulin/moulinFrns/ALLFOL"/>" class="list-group-item active">Consulter la liste des fournisseurs</a>
    <a href="<c:url value="/moulin/moulinFrns/indexfo"/>" class="list-group-item ">Ajouter un fournisseur </a> 
        </div>
     </div></div></div>
  </td>
	  
   
   <td>
   </tr>
   </table>
<!--fIN du menu-->
<!-- rechercher-->

<div align="center">
<f:form modelAttribute="frol"  action="folRechercher" class="form-inline" method="post"  >
<div class="form-group">
<label>Recherche par nom :</label>
<f:input path="nomFourn" class="form-control" placeholder="Nom fournisseur"/>
<f:errors path="nomFourn" cssClass="error"></f:errors>  
</div>
<div class="form-group">
<input type="submit" value="Rechercher" class="btn btn-primary"/> 
</div>
</f:form>
<!-- Fin recherche -->
<br>
<br>
<h4 align="center">Fournisseur d'olive</h4>


   <table width="70%">
<tr><td>
<table class="table table-bordered" width="75%" >
<tr class="bg-success">
<th>CIN fournisseur</th><th>Nom fournisseur</th><th>Prenom  fournisseur</th><th>téléphone fournisseur</th>
<th>Adresse fournisseur</th><th colspan="2">Action</th>
</tr>


<c:if test="${frol.listFournObyname==null}">

<c:forEach items="${epff}" var="pf" >
<tr>	
<td><a href='<c:url value="/moulin/moulinBonAchat/chargerBon?cinFourn=${pf.cinFourn}"></c:url>'>${pf.cinFourn}</a></td>
<td style="word-break:break-all;">${pf.nomFourn}</td>
<td>${pf.prenomFourn}</td>
<td>${pf.telFourn}</td>
<td style="word-break:break-all;">${pf.adrFourn}</td>
<td><a href="javascript:confirmation('${pf.cinFourn}')">Supprimer</a></td>
<td><a href="editfrnsO?CINFO=${pf.cinFourn}">Modifier</a></td>
</tr>
</c:forEach>
</c:if>


<c:if test="${empty frol.listFournOlive}">

<c:forEach items="${ep.listFournOlive}" var="p" >
<tr >	
<td><a href='<c:url value="/moulin/moulinBonAchat/chargerBon?cinFourn=${p.cinFourn}"></c:url>'>${p.cinFourn}</a></td>
<td style="word-break:break-all;" >${p.nomFourn}</td>
<td>${p.prenomFourn}</td>
<td>${p.telFourn}</td>
<td style="word-break:break-all;">${p.adrFourn}</td>

<td><a href="javascript:confirmation('${p.cinFourn}')">Supprimer</a></td>
<td><a href="editfrnsO?CINFO=${p.cinFourn}">Modifier</a></td>
</tr>
</c:forEach>
</c:if>
</table>

</td>
</tr>
</table>
</div>

<div align="right" class ="container">
<ul class="pagination">
<c:forEach begin="0" end="${ep.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==ep.nombrePages}">
<li><span >page ${p}</span></li>
</c:when>
<c:otherwise>
<li><span>
<a href="ALLFOL?page=${p}">page ${p}</a>
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

</body>
</html>

