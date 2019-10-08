<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<title>Citerne</title>
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
  function confirmation(code){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppCiterne?code="+code;
	  }
  }

</script>

</head>
	
<div >
${exception}
</div>

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

   <!--Gestion du molin d'olive-->

</div>
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
    
   
<div align="center">
        <div class="list-group">
  <a href="#" class="list-group-item disabled"><center>Sous menu</center></a>
  <a href="<c:url value="/moulin/moulinStock/indexc"/>" class="list-group-item active ">Ajouter une citerne</a>
  <a href="<c:url value="/moulin/moulinStock/ALLCiterne"/>" class="list-group-item ">Consulter la liste des citernes</a>
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
      <h2>Citerne</h2>

<!--Formulaire J2ee-->
<div align="center" class="lead bg-info">
${error}
</div>

<f:form modelAttribute="citerne" action="saveCiterne"  method="post" enctype="multipart/form-data">
 
<table width="80%">
<tr>

<tr>
<td>Reference de la citerne:</td>
<td><f:input path="codeStock" class="form-control"  placeholder="Reference citerne"/></td>
</tr>
<tr><td></td>
<td><f:errors path="codeStock" cssClass="errors"/></td>
</tr>

<tr><td><br></td></tr>

<tr>
<td>Capacité de la citerne(en L):</td>
<td><f:input path="capacite" class="form-control" /></td>
<td><f:errors path="capacite" cssClass="errors"/></td>
</tr>

<tr><td><br></td></tr>

<tr>
<td>Prix unitaire(en DT):</td>
<td><f:input path="prixUT" class="form-control"  /></td>
<td><f:errors path="prixUT" cssClass="errors"/></td>
</tr>  

<tr><td><br></td></tr>

<tr>
<td>Qualité d'huile:</td>
<td><f:select path="qualiteHuile" class="form-control">
<f:option value="Huile d'olive verte">Huile d'olive verte</f:option>
<f:option value="Huile d'olive organique">Huile d'olive organique</f:option>
<f:option value="huile d'olive aromatique">huile d'olive aromatique</f:option>
</f:select></td>
<td><f:errors path="qualiteHuile" cssClass="errors"/></td>
</tr>  

<tr><td><br></td></tr>

<tr>
<td>Quantité d'huile (en L):</td>
<td><f:input path="quantiteHuile" class="form-control"/></td>
<td><f:errors path="quantiteHuile" cssClass="errors"/></td>
</tr>  

<tr><td><br></td></tr>

<tr>
<td></td>
<td>
<c:if test="${citerne.codeStock==null }">
<input class="btn btn-primary" type="submit" name="action" value="Ajouter">
</c:if>
<c:if test="${citerne.codeStock!=null }">
<input class="btn btn-primary" type="submit" name="action" value="Modifier">
</c:if>
</td>
</tr>

</table>
</f:form>
<!-- 
<table class="table">
<tr>
<th>Reference du citerne </th><th> Capacite Max</th><th>prixUT</th>
<th>quantiteHuile</th><th>qualiteHuile</th><th colspan="2">Action</th>
</tr>

<c:forEach items="${citernes}" var="c"> 

<tr>
<td>${c.codeStock}</td>
<td>${c.capacite}</td>
<td>${c.prixUT}</td>
<td>${c.quantiteHuile}</td>
<td>${c.qualiteHuile}</td>

<td><a href="javascript:confirmation('${c.codeStock}')">Supprimer</a></td>
<td><a href="editCiterne?code=${c.codeStock}">Modifier</a></td>
</tr>

</c:forEach>
</table>
 -->


<!--Fin Formulaire J2ee-->
   
	
	  </td>
  </tr>
	  </table>
	</div>  
	  <div>
	   </div>
</div></div>
</body>
</html>