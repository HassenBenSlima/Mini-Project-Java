<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<meta charset="UTF-8">
<title>Recherche Fourniseur Maintenance</title>

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
  function confirmation(cin){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppFrnsM?CINFM="+cin;
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
   
    <div align="center">
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href="<c:url value="/moulin/moulinFrns/indexfm"/>" class="list-group-item ">Ajouter un fournisseur </a>
  <a href="<c:url value="/moulin/moulinFrns/ALLFO"/>" class="list-group-item active">Consulter la liste des fournisseurs</a>
  <a href="<c:url value="/moulin/moulinOlive/ALLMain"/>" class="list-group-item ">Consulter la liste des maintenances</a>
  <a href="<c:url value="/moulin/moulinOlive/indexmta"/>" class="list-group-item ">Ajouter une maintenance</a>
</div></div>
</div>
</div>
       </td>
	  
   
   <td>
   </tr>
   </table>
<!--fIN du menu-->

<!-- rechercher-->
<div align="center">

<f:form modelAttribute="frm"  action="foRechercher" class="form-inline" method="post"  >
<div class="form-group">
<label>Recherche par Nom:</label>
<f:input path="nomFourn" class="form-control" placeholder="Nom fournisseur"/>
<f:errors path="nomFourn" cssClass="error"></f:errors>  
</div>

<div class="form-group">
<input type="submit" value="Rechercher" class="btn btn-primary"/> 
</div>


</f:form>

<!-- Fin recherche -->
<br><br>
<div >
<h4>Fournisseur de maintenance</h4>
</div>
   <table width="74%">
<tr><td>
<table class="table table-bordered" width="75%" >
<tr class="bg-success">
<th>CIN fournisseur</th><th>Nom fournisseur</th><th>Prenom  fournisseur</th><th>Téléphone fournisseur</th>
<th>Adresse fournisseur</th><th colspan="2">Action</th>
</tr>


<c:if test="${frm.listfrounByname==null}">
<c:forEach items="${epff}" var="pf" >
<tr>	
<td>${pf.cinFourn}</td>
<td style="word-break:break-all;">${pf.nomFourn}</td>
<td style="word-break:break-all;">${pf.prenomFourn}</td>
<td style="word-break:break-all;">${pf.telFourn}</td>
<td style="word-break:break-all;">${pf.adrFourn}</td>
<td><a href="javascript:confirmation('${pf.cinFourn}')">Supprimer</a></td>
<td><a href="editfrns?CINFM=${pf.cinFourn}">Modifier</a></td>
</tr>
</c:forEach>
</c:if>


<c:if test="${   empty frm.listFournMain}">


<c:forEach items="${ep.listFournMain}" var="p" >
<tr>	
<td style="word-break:break-all;">${p.cinFourn}</td>
<td style="word-break:break-all;">${p.nomFourn}</td>
<td style="word-break:break-all;">${p.prenomFourn}</td>
<td style="word-break:break-all;">${p.telFourn}</td>
<td style="word-break:break-all;">${p.adrFourn}</td>

<td><a href="javascript:confirmation('${p.cinFourn}')">Supprimer</a></td>
<td><a href="editfrns?CINFM=${p.cinFourn}">Modifier</a></td>
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
<li><span >
<a href="ALLFO?page=${p}">page ${p}</a>
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

