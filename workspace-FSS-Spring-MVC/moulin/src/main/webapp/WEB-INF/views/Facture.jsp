<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Commande Client</title>

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
				format: 'dd/mm/yyyy',
			});		
	
});	

</script>

<script>

function find(arr, obj) {
    for(var i=0; i<arr.length; i++) {
        if (arr[i].indexOf(obj)> -1) return i;
    }
    return -1;
}
 
jQuery( document ).ready(function( $ ) {
  // Code using $ as usual goes here.
    $("#p").hide();
  $('#client').on('input',function(e){
	  var search=$( this ).val();
	  var str = "";
	  var clientNames=[];
	  var clientCins=[];
	    $( "select#clients option" ).each(function() {
	      str += $( this ).text() + ",";
	      str += $( this ).val() + "-";
	      clientNames.push($( this ).text());
	      clientCins.push($( this ).val());
	    });
	 index=find(clientCins,search);
	 if(index!=-1)
		{
		 console.log(index);
		 $('#clientname').val(clientNames[index]);
		 var idSelector="#clients option[value="+clientCins[index]+"]";
		 $(idSelector).prop('selected', true);
		}else
			{
			 $('#clientname').val("introuvable");
			}
	    });
  

  $('select#clients').on('change', function() {
	  // or $(this).val()
	  $('#client').val(this.value );
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
       <h1> <a href="#"><small>Societé</small>
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
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Commande<span class="caret"></span></a>
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
      <h2 class="bigtext"><span> Gestion <br/>du Moulin d'Olive</span></h2>
       
    </div>
  </div>
 <!--Fin Gestion du molin d'olive-->

  <!--Menu left-->
   
   <!--Menu left-->
   
   <!--Code  J2ee-->
<br><br>

<div align="center" class="lead bg-info">
${error}
</div>

<f:form modelAttribute="fac" action="Savefac" id="myForm"
method="post" enctype="multipart/form-data">

<table   width="100%" class="table table-bordered">
<tr>
<td>
<table  align="center" width="90%">
<tr>
<td><f:hidden path="idVente"/></td>
<td><f:errors path="idVente" cssClass="errors"></f:errors></td>
</tr> 

<tr>
<td></td>
<td><f:select  path="caissef.idCaisse" id="p" items="${Css}" itemValue="idCaisse" itemLabel="solde" class="form-control" ></f:select></td>
<td><f:errors path="caissef.idCaisse" cssClass="errors"/></td>
</tr>
<tr><td><br/></td></tr>

<tr>
<td>Date de Commande :</td>

<td>

<f:input path="dateVente" class="datepicker" id="date" size="25" placeholder="clic ici pour monter l'agenda"/></td>

<td><f:errors path="dateVente"  cssClass="errors" /></td>
</tr>
<tr><td><br/></td></tr>

<tr>
<td>Type de réglement:</td>
<td><f:select path="typeReglement"  class="form-control"  >
<f:option value="Espéce"> Espèce </f:option>
<f:option value="Chéque"> Chéque </f:option>
</f:select>
</td>
<td><f:errors path="typeReglement"  cssClass="errors" /></td>
</tr>

<tr><td><br/></td></tr>

<tr>

<td>Tapez CIN de client:</td>
<td><input  type="text" name="cl" id="client"  class="form-control" placeholder="verifier client"/></td>

<td><input class="form-control" type="text"  size="5"  name="clientname" id="clientname"  disabled />
</td>


</tr>

<tr><td><br/></td></tr>

<tr>
<td>Clients :</td> 
<td><f:select class="form-control" id="clients" path="client.cinClient"  items="${clients}" itemValue="cinClient" itemLabel="nomClient"></f:select></td>
<td><a href="<c:url value="/moulin/moulinClient/index"/>">Gérer les clients</a></td>
<td><f:errors path="client.cinClient" cssClass="errors"></f:errors></td>
</tr>
<tr><td><br/></td></tr>

<tr>
<td>Unité :</td>
<td>Kg<input type="radio"  value="Kg" name="H"/></td>
<td>L <input type="radio"  value="L"  name="H"/></td>
</tr>


</table >

</td>

<td>

<table align="center"  width="90%" >

<tr>
<td>Designation :</td>
<td><f:textarea   path="designation"  rows="8" id="ds" class="form-control" placeholder="designation"/></td>
<td><f:errors path="designation" cssClass="errors"></f:errors></td>
</tr> 
<tr><td><br/></td></tr>
<tr>
<td>Quantité :</td>
<td><f:input   path="quantite"   id="q" class="form-control"/></td>
<td><f:errors path="quantite" cssClass="errors"></f:errors></td>
</tr>
<tr><td><br/></td></tr>
<tr>
<td>Prix totale : en DT</td>
<td><f:input id="pt"   path="montantf"  class="form-control" /></td>
<td><f:errors path="montantf" cssClass="errors"></f:errors></td>
</tr>


</table>


</table>

<table class="table table-bordered">
<tr>
<th>Code du citerne</th><th>Capacité</th>
<th>Prix unitaire(en DT)</th><th>Quantité(en L)</th><th>Qualite d'huile</th>
<th>Quantité acheté</th><th>Prix</th>
</tr>


<c:forEach items="${ct}" var="c" varStatus="id"> 
<tr>
<td>${c.codeStock}</td>
<td>${c.capacite}</td>
<td>${c.prixUT}</td>
<td >${c.quantiteHuile}</td>
<td id="qlit${id.index}" >${c.qualiteHuile}</td>
<td><input id="qte${id.index}" type="text" onChange="calculPrix(${id.index})"/></td>
<td><input id="${id.index}" type="text" disabled/></td>
<td><input type="checkbox" id="check${id.index}" value="${c.codeStock}" onclick='JSCall(${id.index})'/></td>
</tr>
</c:forEach>
</table>

<input class="btn btn-primary" type="button" onclick="myFunction()" name="action" value="Ajouter">
</f:form>
<br><br><br>


<script type="text/javascript">

function myFunction() { 
//	alert('hassen');
	var date =document.getElementById("date").value;
	var ds =document.getElementById("ds").value;
	var q =document.getElementById("q").value;
	var prix =document.getElementById("pt").value;
	
if((prix==0)||(ds=="")||((q==0))||(date=="")){

	alert("Verifier les informations de cette commande !"); 
	
}else{
	
	console.log(prix+"  prix");
	console.log(ds+"  desigantion");	
	console.log(q+"  quantité");
	console.log(date+"  date");
	document.getElementById("myForm").submit();
}

}
</script>



<script type="text/javascript">
var i = 1;
var Designation=[];

function JSCall(x){
	var qte_cmder =document.getElementById("qte"+x).value;
//	alert(qte_cmder);
	
	var uniter =$("input[type='radio'][name='H']:checked").val();
	//alert(uniter+"-unité");
   	    
	  var variable3 = $('#qte'+x).val();

	  var variable = $('#check'+x).val();
	  
	  //var variable2 = $('#qte'+x).val();
	  
	  if(uniter=="L"){
		  var variable2 = $('#qte'+x).val();  
		//  alert(variable2+" L quantité");
	  }else if (uniter=="Kg"){
		  
		  var variable2 = ((1/0.920))*($('#qte'+x).val());  
		  //alert(variable2+" kg quantité");
	  }
	  
	  var typehuile= $('#qlit'+x).text();
	  console.log(typehuile+"-type de citerne");
	  console.log(variable+"-reference de citerne");
	  console.log(variable2+"-quantité acheté");
		 
	  if(qte_cmder=="")
		{
		  console.log("hASSEN");
		return;
		}else{
          var desgn=variable3+" "+uniter+" de la citerne "+ variable +" de type "+typehuile;
          i++;
		  }
          // alert(i);
         // alert(desgn);
        	       
          Designation.push(desgn);
          var Array=[];
          for(var j=0;j<Designation.length;j++){
        	
        	  Array.push ("{"+Designation[j]+"},");
        	  console.log(Array);
          }
          //Array.join()
          document.getElementById("ds").value=Array;
         
	     $.ajax({
	        type: "GET",
	        url: "ajaxController",
	        data: {variable :variable,variable2:variable2}
	       
	        
	   });
	    
	}

</script>


<script type="text/javascript">
function valide(x){
	alert(x);
	var p =document.getElementById("qte"+x).value;
	alert(p);
	var m =document.getElementById("check"+x).value;
	alert(m);
	var v =document.getElementById("check"+x);
}
	</script>

<script type="text/javascript" >

function find(arr, obj) {
    for(var i=0; i<arr.length; i++) {
        if (arr[i].indexOf(obj)> -1) return i;
    }
    return -1;
}

var bl=false;
var prix_tot=0;
var prix=0;
var i=0;
var qtetot=0;
var tabcode=[];
var tabval=[];
var klg=0.920;
function calculPrix(x)
{       
	var uniter =$("input[type='radio'][name='H']:checked").val();
	console.log(uniter);
   	      
   	
	var prix_unit1= parseFloat(document.getElementsByTagName('table')[3].getElementsByTagName('tr')[x+1].cells[2].innerHTML);
	var qte_cit1= parseFloat(document.getElementsByTagName('table')[3].getElementsByTagName('tr')[x+1].cells[3].innerHTML);
	var qte_cmd =parseFloat(document.getElementById("qte"+x).value);
	
	if(uniter=="Kg")
	{
		prix_unit=prix_unit1*klg;
		qte_cit=qte_cit1*klg;
		
	}else if(uniter=="L"){
		prix_unit=prix_unit1;
		qte_cit=qte_cit1;
		
	}else{
		
		alert("s'il vous plaît choisir l'unité d'huile");
		document.getElementById("qte"+x).value="";
		return;
	}
	
	
	console.log("qte"+x);
	
	if(document.getElementById("qte"+x).value==""){
		
		console.log("la quantité demandée est vide");
		
	}else{
	tabcode.push("qte"+x);
	tabval.push(qte_cmd);
	console.log(qte_cmd);
	console.log("++++++++++++++");
	console.log(tabval);
	console.log(tabcode);
	
	}

	
	if(qte_cmd>qte_cit)
	{
		alert("la quantité demandée est supperieure à la quantité trouvable dans la citerne");
		document.getElementById("qte"+x).value="";
		document.getElementById(x).value="";
	}
	else if(document.getElementById("qte"+x).value=="")
	  { bl=true;
		prix_tot=prix_tot-document.getElementById(x).value;
		document.getElementById(x).value="";
		document.getElementById("pt").value=prix_tot;
		
	  
		
		for(var m =0;m<tabcode.length;m++) {
		    
			//alert([i]+"tableau");
			console.log(tabval);
			console.log(tabcode);
				
			}
			
		
		
		//delete array[i];
		
		var r=tabcode.lastIndexOf("qte"+x);
		console.log(r+"last indice");
		
		console.log(tabval[r]);
		var k=tabval[r];
		if (r!=-1){
			console.log(k+"ok");
			
			qtetot=qtetot-k;
			document.getElementById("q").value=qtetot;
			
			}
        
	
	}
	else
	{
		if(i>1)
		{
		  
			var p=document.getElementById(x).value;
			prix_tot=prix_tot-p;
		}
		
	    prix=parseFloat(qte_cmd*prix_unit);
		
	    document.getElementById(x).value=prix;
		prix_tot=prix_tot+prix;
		
		document.getElementById("pt").value=prix_tot;
		
		
		qtetot+=qte_cmd;
		document.getElementById("q").value=qtetot;
	
	}

	i++;
}


</script>



</body>	
</html>