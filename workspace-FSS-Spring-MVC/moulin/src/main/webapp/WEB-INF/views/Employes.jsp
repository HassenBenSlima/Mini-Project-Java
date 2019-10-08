<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<head>

<title>Employés du moulin</title>
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

function limitText(x,limitNum){
if(x.value.length>limitNum){

x.value=x.value.substring(0,limitNum);
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

   <!--Gestion du molin d'olive-->

</div>
    <div class="headert_text_resize">
     
      <div class="clr"></div>
      <h2 class="bigtext"><span> Gestion <br/>du Moulin d'Olive</span></h2><br />
       
    </div>
  </div>
 <!--Fin Gestion du molin d'olive-->
      <div class="body"><div class="body_resize">

  <!--Menu left-->
   
   <table align="left">
   <tr>
   
    <td>
   <br/>
<div align="center" >
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Bienvenue</a>
  <a href="<c:url value="/moulin/Caisse/indexcaisse"/>" class="list-group-item ">La caisse</a>
  <a href="<c:url value="/moulin/moulinClient/index"/>" class="list-group-item ">Ajouter un client</a>
  <a href="<c:url value="/moulin/moulinClient/ALLClient"/>" class="list-group-item  ">Consulter la liste des clients</a>
  <a href="<c:url value="/moulin/moulinEmployer/indexe"/>" class="list-group-item active">Ajouter un employé</a>
  <a href="<c:url value="/moulin/moulinEmployer/ALLEmp"/>" class="list-group-item">Consulter la liste des employés</a>
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
      <h2>Employé</h2>

<!--Formulaire J2ee-->
<div align="center" class="lead bg-info">
${error}
</div>

<f:form modelAttribute="employe" action="saveEmploye"  method="post" enctype="multipart/form-data">

<table width="90%">
	
<tr>

<tr>
<td>CIN d'employé:</td>
<td><f:input path="cinEmp" class="form-control" type="number" placeholder="CIN employe" onkeydown="limitText(this,8)"/></td>
</tr>
<tr>
<td></td>
<td><f:errors path="cinEmp" cssClass="errors"/></td>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Nom d'employé:</td>
<td><f:input path="nomEmp" class="form-control" placeholder="Nom employe"/></td>
</tr>
<tr>
<td></td>
<td><f:errors path="nomEmp" cssClass="errors"/></td>
</tr>

<tr><td><br></td></tr>

<tr>
<td>Prénom d'employé:</td>
<td><f:input path="prenomEmp" class="form-control" placeholder="Prenom employe" /></td>
</tr>
<tr>
<td></td>
<td><f:errors path="prenomEmp" cssClass="errors"/></td>
</tr>

<tr><td><br></td></tr>

<tr>
<td>Téléphone d'employé:</td>
<td><f:input path="telEmp" class="form-control" type="number" placeholder="Téléphone employe"/></td>
</tr>
<tr>
<td></td>

<td><f:errors path="telEmp" cssClass="errors"/></td>
</tr>  

<tr><td><br></td></tr>

<tr>
<td>Grade d'employé:</td>
<td><f:select path="grade" class="form-control">
<f:option value="Chef" > Chef</f:option>
<f:option value="Ouvrier">Ouvrier</f:option>
</f:select></td>

</tr>
<tr>
<td></td>
<td><f:errors path="grade" cssClass="errors"/></td>
</tr> 

<tr><td><br></td></tr>
 
<tr>
<td>Poste d'employé:</td>
<td><f:select path="periode" class="form-control" >
<f:option value="6->14" > 6->14 </f:option>
<f:option value="14->22">14->22 </f:option>
<f:option value="22->6"> 22->6 </f:option>
</f:select></td>
</tr>
<tr>
<td></td>

<td><f:errors path="periode" cssClass="errors"/></td>
</tr>  
<tr><td><br></td></tr>

<tr>
<td>Adresse d'employé:</td>
<td><f:textarea path="adrEmp" class="form-control" placeholder="Adresse employe"/></td>
</tr>
<tr>
<td></td>
<td><f:errors path="adrEmp" cssClass="errors"/></td>
</tr>  
<tr><td><br></td></tr>

<tr>
<td></td>
<td>
<c:if test="${employe.cinEmp==null}">
<input type="submit" name="action" value="Ajouter" class="btn btn-primary"/>
</c:if>
<c:if test="${employe.cinEmp!=null}">

<input type="submit" name="action" value="Modifier"  class="btn btn-primary" />
</c:if>

</td>

</tr>

</table>
</f:form>





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