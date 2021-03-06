<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>


<title>Bon Achat</title>

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
		 document.location="suppBA?idBA="+id;
	 }
  }

</script>

<script>

$(function(){

	
	
	$('.datepicker').datepicker(
			{
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
	  // or $(this).val()
	  $('#frn').val(this.value );
	});
  
  
  
 
});


</script>

<body>

<!-- START PAGE SOURCE -->
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
       <h1> <a href="<c:url value="/moulin/Caisse/indexcaisse"/>"><small>Societ�</small>
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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Achat d'olive <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinBonAchat/indexba"/>">Ajouter bon d'achat</a></li>
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
    <div align="center" >
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href="<c:url value="/moulin/moulinBonAchat/indexba"/>" class="list-group-item active">Ajouter un achat </a>
  <a href="<c:url value="/moulin/moulinBonAchat/indexfrnsbonachat"/>" class="list-group-item ">Consulter bons par fournisseur</a>
  <a href="<c:url value="/moulin/moulinFrns/ALLFOL"/>" class="list-group-item">Consulter la liste des fournisseurs</a>
        </div>
     </div>
       </td>
		  
   
   <td>
   </tr>
   </table>
   
   <!--Menu left-->
   
   <!--Code  J2ee-->
   
   <table width="70%" align="center">
   <tr>
   <td>
      <h2>Achat d'olive</h2>

<!--Formulaire J2ee-->




<div align="center" class="lead bg-info">
${error}
</div>
<div align="center" class="lead bg-info">
${error2}
</div>
<div>
${exception }
</div>


<f:form modelAttribute="ba" action="saveBA" id="myForm"
method="post" enctype="multipart/form-data">

	
	
<table width="100%" >

<tr>
<td><f:hidden path="idBA" class="form-control"/></td>
<td><f:errors path="idBA" cssClass="danger"></f:errors></td>
</tr>

 <tr> 
 <td>Solde:</td>
<td>

<f:select  path="caisse.idCaisse"  class="form-control" items="${css}" itemValue="idCaisse" itemLabel="solde"></f:select>
</td>
<td><f:errors path="caisse.idCaisse" cssClass="danger"/>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Date d'achat:</td>
<td><f:input path="dateBA" class="datepicker" id="date" size="25" placeholder="clic ici pour monter l'agenda"/></td>

<td><f:errors path="dateBA"  cssClass="errors" /></td>
</tr>

<tr><td><br></td></tr>

<tr>
<td>Montant d'achat:</td>
<td><f:input path="MontantAchat" class="form-control" id="mt"/></td>

<td><f:errors path="MontantAchat"  cssClass="danger" /></td>
</tr>

<tr><td><br></td></tr>

<tr>
<td>Tapez CIN du fournisseur:<br></td>
<td><input  type="text"  id="frn" placeholder="verifier fournisseur" class="form-control"/>
</td>

<td><input type="text" name="frnname" id="frnname" size="5" disabled class="form-control"/>
</td>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Fournisseurs:</td> 
<td><f:select class="form-control" id="frns" path="fournisseuro.cinFourn"  items="${frns}" itemValue="cinFourn" itemLabel="nomFourn"></f:select></td>
<td><a href="<c:url value="/moulin/moulinFrns/indexfo"/>">G�rer les fournisseurs</a></td>
<td><f:errors path="fournisseuro.cinFourn" cssClass="danger"/></td>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Cuves:</td> 
<td><f:select class="form-control" id="cvs" path="stocko.codeStock"  items="${cv}" itemValue="codeStock" itemLabel="codeStock"></f:select></td>
<td><f:errors path="stocko.codeStock" cssClass="danger"/></td>
</tr>

<tr><td><br></td></tr>

<tr>
<td>Maturit�:</td>
<td><f:select   path="maturite" class="form-control">

<f:option value="Olives vertes" >Olives vertes</f:option>
<f:option value="Olives � couleur tourn�e">Olives � couleur tourn�e</f:option>
<f:option value="Olives noires">Olives noires</f:option>

</f:select></td>
<td><f:errors path="maturite" cssClass="danger"></f:errors>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Quantite d'olive:</td>
<td><f:input   path="quantiteOL"  class="form-control" placeholder="quantit� d'olive"/></td>
<td><f:errors path="quantiteOL" cssClass="danger"></f:errors>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Designation:</td>
<td><f:textarea   path="designation" placeholder="designation" id="ds" class="form-control"/></td>
<td><f:errors path="designation" cssClass="danger"></f:errors>
</tr>
<tr><td><br></td></tr>

<tr>
<td>Region d'olive:</td>
<td><f:input   path="regionOlive"  class="form-control"  id="r" placeholder="region d'olive"/></td>
<td><f:errors path="regionOlive" cssClass="danger" ></f:errors>
</tr> 
<tr><td><br></td></tr>
<tr>
<td></td>
<td>
<input class="btn btn-primary" type="button" onclick="myFunction()" name="action" value="Ajouter">
</td>

</tr>
<tr><td><br></td></tr>

</table>
</f:form>
<script type="text/javascript">
function myFunction() {
//alert("hassen");
var date =document.getElementById("date").value;
//alert(date);
var dsgn =document.getElementById("ds").value;
//alert(dsgn);
var region =document.getElementById("r").value;
//alert(region);
if((date=="")||(dsgn=="")||(region=="")){
	
	alert("Verifier les informations de cet achat!"); 

}else{

	document.getElementById("myForm").submit();
	
}
}


</script>
<!-- 
<table class="table table-bordered">
<tr>
<th>Nom Fournisseur</th><th>Phone du fournisseur</th>
<th>Prix d'achat</th><th>Date</th><th>Description</th>
<th colspan="2">M-A-J</th>
</tr>

<c:forEach items="${bas}" var="b"> 
<tr>
<td>${b.fournisseuro.nomFourn}</td>
<td>${b.fournisseuro.telFourn}</td>
<td>${b.montantAchat}</td>
<td>${b.dateBA}</td>
<td>${b.maturite}</td>
<td>${b.quantiteOL}</td>
<td>${b.regionOlive}</td>
<td><a href="javascript:confirmation('${b.idBA}')">Supp</a></td>
<td><a href="editBA?idBA=${b.idBA}">Edit</a></td>
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