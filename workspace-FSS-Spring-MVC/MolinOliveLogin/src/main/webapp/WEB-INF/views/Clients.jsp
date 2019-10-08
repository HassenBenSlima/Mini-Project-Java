<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<title>Clients du moulin</title>

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
		 document.location="suppClient?CIN="+id;
	     alert("Suppression reussite");
		 
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
       <h1> <a href="Accueile.html"><small>Societé</small>
          Moulin d'olive.</a></h1><br/><br />
      </div>

      <div class="logo_text"><a href="#">Help</a> | <a href="#">Commande</a> | <a href="#">Deconnection</a></div>
      <div class="clr"></div>
    </div>
	
		  <div>
	  
 <!--Menu-->
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">Accueil</a></li>
    <li class="dropdown">
     <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Reservations <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Ajouter reservation</a></li>
        <li><a href="#">list de reservation</a></li>                        
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Commande<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Ajouter commande</a></li>
        <li><a href="#">Factures Client</a></li>                        
      </ul>
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Bon d'chat <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Ajouter bon d'achat</a></li>
        <li><a href="#">bons d'achats du fournisseur</a></li>  
        <li><a href="#">List des fournisseurs</a></li>  		
      </ul>
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Maintenance <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Ajouter Maintenance</a></li>
        <li><a href="#">List de maitenance</a></li>                        
      <li><a href="#"> Consulté fournisseurs</a></li> 
	  </ul>
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Fournisseurs <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Fournisseur de maintenance</a></li>
        <li><a href="#">Fournisseur olive</a></li>                        
      </ul>
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Stock <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Stock Olive</a></li>
        <li><a href="#">Stock Huile</a></li>                        
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
      <h2 class="bigtext"><span> Gestion <br/>du Moulin <br/>d'Olive</span></h2><br />
       
    </div>
  </div>
 <!--Fin Gestion du molin d'olive-->

  <!--Menu left-->
   
   <table align="left">
   <tr>
   
    <td>
   <br/>
        <div class="list-group">
  <a href="#" class="list-group-item disabled"><center>Sous menu</center></a>
  <a href="http://localhost:8081/ml/moulinClient/index" class="list-group-item active">Ajouter Client </a>
  <a href="#" class="list-group-item ">Consulter Client</a>
  <a href="#" class="list-group-item">Ajouter Employer</a>
  <a href="#" class="list-group-item">Consulter Employer</a>
</div>
       </td>
		  
   
   <td>
   </tr>
   </table>
   
   <!--Menu left-->
   
   <!--Code  J2ee-->
   
   <table width="60%" align="center">
   <tr>
   <td>
      <h2>Ajouter un Client</h2>

<!--Formulaire J2ee-->
  <div class="form-group row">
<div class="col-sm-10">

<f:form modelAttribute="client" action="saveClient"  method="post" enctype="multipart/form-data" >

 
<table width="100%">

<tr>
<td >Cin Client <br/></td>
<td><f:input path="cinClient" class="form-control" placeholder="Cin Client"/><br/></td>
<td><f:errors path="cinClient" cssClass="errors" class="form-control"/><br/></td>
</tr>

<tr>
<td>Nom Client<br/></td>
<td><f:input path="nomClient" class="form-control" placeholder="Nom Client"/><br/></td>
<td><f:errors path="nomClient" cssClass="errors"/><br/></td>
</tr>

<tr>
<td>Prenom client<br/></td>
<td><f:input path="prenomClient" class="form-control" placeholder="Prenom Client"/><br/></td>
<td><f:errors path="prenomClient" cssClass="errors" class="form-control" /><br/></td>
</tr>  

<tr>
<td>Adrésse Client<br/></td>
<td><f:textarea path="adrClient" class="form-control" placeholder="Adresse Client"/><br/></td>
<td><f:errors path="adrClient" cssClass="errors"/><br/></td>
</tr>  

<tr>
<td>Telephone Client<br/></td>
<td><f:input path="telClient" class="form-control" placeholder="Teliphone Client"/><br/></td>
<td><f:errors path="telClient" cssClass="errors" /><br/></td>
</tr>  

<tr>
<td></td>
<td>
<c:if test="${client.cinClient==null}">
<input class="btn btn-success" type="submit"  name="action" value="Save">
</c:if>
<c:if test="${client.cinClient!=null}">
<input class="btn btn-success" type="submit" name="action" value="Modifier">
</c:if>
</td>
</tr>

</table>
</f:form>
</div>
</div>


<!--Fin Formulaire J2ee-->
   
	
	  </td>
  </tr>
	  </table>
	</div>  
	  <div>
	   </div>

</body>