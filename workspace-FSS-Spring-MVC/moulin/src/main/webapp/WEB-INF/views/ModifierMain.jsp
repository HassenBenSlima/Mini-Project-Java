<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

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
	 }
  }

</script>

<script>


$(function(){
	
	$('.datepicker').datepicker({
		format: 'dd/mm/yyyy'
	});	
});

function find(arr, obj) {
    for(var i=0; i<arr.length; i++) {
        if (arr[i].indexOf(obj)> -1) return i;
    }
    return -1;
}
 
jQuery( document ).ready(function( $ ) {
  // Code using $ as usual goes here.

  $('#frn').on('input',function(e){
	  var search=$( this ).val();
	  var str = "";
	  var frnNames=[];
	  var frnCins=[];
	    $( "select#frns option" ).each(function() {
	      str += $( this ).text() + ",";
	      str += $( this ).val() + "-";
	      frnNames.push($( this ).text());
	      frnCins.push($( this ).val());
	    });
	 index=find(frnCins,search);
	 if(index!=-1)
		{
		 console.log(index);
		 $('#frnname').val(frnNames[index]);
		 
		 var idSelector="#frns option[value="+frnCins[index]+"]";
		 $(idSelector).prop('selected', true);
		}else
			{
			 $('#frnname').val("introuvable");
			}
	    
	   
	    });
 
  $('select#frns').on('change', function() {
	//  alert( this.value ); // or $(this).val()
	  $('#frn').val(this.value );
	});
});


</script>

</head>


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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Maintenance <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinOlive/indexmta"/>">Ajouter un maintenance</a></li>
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
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href="<c:url value="/moulin/moulinOlive/indexmta"/>" class="list-group-item active">Ajouter une maintenance</a>
  <a href="<c:url value="/moulin/moulinOlive/ALLMain"/>" class="list-group-item ">Consulter la liste des maintenances</a>
</div>
</div>
</td>
		  
   
   <td>
   </tr>
   </table>
   
   <!--Menu left-->
   
   <!--Code  J2ee-->
   
   <table width="75%" align="center">
   <tr>
   <td>
      <h2>Maintenance</h2>

<!--Formulaire J2ee-->


<div align="center" class="lead bg-info">
${error}
</div>


<f:form modelAttribute="maint" action="modifierMain" 
method="post" enctype="multipart/form-data">

<table  >
<tr>
<td><f:hidden path="idMain"/></td>
<td><f:errors path="idMain" cssClass="errors"></f:errors></td>
</tr>

 <tr> 
<td>Solde:</td>
<td><f:select  path="caissem.idCaisse"  items="${css}" itemValue="idCaisse" itemLabel="solde" class="form-control"></f:select></td>
</tr>
<tr>
<td></td>
<td><f:errors path="caissem.idCaisse" cssClass="errors"/></td>
</tr> 
<tr><td><br></td></tr>

<tr>
<td>Date de maintenance:</td>
<td><f:input path="dateMain" class="datepicker" size="25" placeholder="clic ici pour monter l'agenda"/></td>
</tr>
<tr>
<td></td>
<td><f:errors path="dateMain"  cssClass="errors" /></td>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Prix de maintenance:</td>
<td> <div class="input-group">
<div class="input-group-addon">DT</div><f:input class="form-control" size="60" path="prixMain"/><div class="input-group-addon">.00</div></div></td>
</tr>
<tr>
<td></td>
<td><f:errors path="prixMain" cssClass="errors"></f:errors></td>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Tapez CIN de Fournisseur:</td>
<td><input  type="text"  id="frn" class="form-control" placeholder="Verifier fournisseur"/>
</td>

<td><input type="text" name="frnname" id="frnname" class="form-control" disabled/>
</td>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Fournisseurs:</td> 
<td><f:select class="form-control" id="frns" path="fournisseurm.cinFourn"  items="${frnms}" itemValue="cinFourn" itemLabel="nomFourn"></f:select></td>
<td><a href="<c:url value="/moulin/moulinFrns/indexfm"/>">Gérer les fournisseur</a></td>
</tr>
<tr>
<td></td>
<td><f:errors path="fournisseurm.cinFourn" cssClass="errors"/></td>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Description de maintenance:</td>
<td><f:textarea   path="descpanne" cols="70" class="form-control" placeholder="Description"/></td>
</tr>
<tr>
<td></td>
<td><f:errors path="descpanne" cssClass="errors"></f:errors>
</tr>
<tr><td><br></td></tr>
 
<tr>
<td></td>
<td>

<input class="btn btn-primary" type="submit" name="action" value="Modifier">
</td>

</tr>
</table>
</f:form>

${exception1 }

<!-- 
<table class="table table-bordered">
<tr>
<th>Nom Fournisseur</th><th>Phone du fournisseur</th>
<th>Prix Maintenance</th><th>Date</th><th>Description</th>
<th colspan="2">M-A-J</th>
</tr>

<c:forEach items="${maints}" var="mt"> 
<tr>
<td>${mt.fournisseurm.nomFourn}</td>
<td>${mt.fournisseurm.telFourn}</td>
<td>${mt.prixMain}</td>
<td>${mt.dateMain}</td>
<td>${mt.descpanne}</td>
<td><a href="javascript:confirmation('${mt.idMain}')">Supp</a></td>
<td><a href="editMain?idMain=${mt.idMain}">Edit</a></td>
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
</div>
</div>
</body>
</html>
