<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
<title>Commande Client</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-iso.css"/>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/hashtable.js"></script>


<script>

function find(arr, obj) {
    for(var i=0; i<arr.length; i++) {
        if (arr[i].indexOf(obj)> -1) return i;
    }
    return -1;
}
 
jQuery( document ).ready(function( $ ) {
  // Code using $ as usual goes here.

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
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">
 	

<f:form modelAttribute="fac" action="Savefac" 
method="post" enctype="multipart/form-data">

<table class="table">
<tr>
<td><f:hidden path="idVente"/></td>
<td><f:errors path="idVente" cssClass="errors"></f:errors></td>
</tr> 

<tr>
<td>Caisse :</td>
<td><f:select  path="caissef.idCaisse"  items="${Css}" itemValue="idCaisse" itemLabel="solde"></f:select></td>
<td><f:errors path="caissef.idCaisse" cssClass="errors"/></td>
</tr>

<tr>
<td>Type de reglement:</td>
<td><f:select path="typeReglement"  class="form-control"  >
<f:option value="Espéce"> Espéce </f:option>
<f:option value="Chéque"> Chéque </f:option>
</f:select>
</td>
<td><f:errors path="typeReglement"  cssClass="errors" /></td>
</tr>


<tr>
<td>Tapez CIN de Client:</td>
<td><input  type="text" name="cl" id="client"  class="form-control"/>
</td>

<td><input type="text"   name="clientname" id="clientname" class="form-control" disabled />
</td>
</tr>

<tr>
<td>Clients</td> 
<td><f:select class="form-control" id="clients" path="client.cinClient"  items="${clients}" itemValue="cinClient" itemLabel="nomClient"></f:select></td>
<td><a href="http://localhost:8081/ml/moulinClient/index">Gerer Client</a></td>
<td><f:errors path="client.cinClient" cssClass="errors"></f:errors></td>
</tr>
<tr>
<td>Designation :</td>
<td><f:textarea   path="designation"  id="ds" class="form-control" /></td>
<td><f:errors path="designation" ></f:errors></td>
</tr> 

<tr>
<td>quantite</td>
<td><f:input   path="quantite"   id="q" class="form-control"/></td>
<td><f:errors path="quantite" cssClass="errors"></f:errors></td>
</tr>

<tr>
<td>Prix totale :</td>
<td><f:input id="pt"   path="montantf"  class="form-control" />DT</td>
<td><f:errors path="montantf" cssClass="errors"></f:errors></td>
</tr>

<tr>
<td>Unité :</td>
<td>Kg<input type="radio"  value="KL" name="H"/></td>
<td>L <input type="radio"  value="L"  name="H"/></td>
</tr>
</table>
<input class="btn btn-success" type="submit"  name="action" value="Ajouter">
<input class="btn btn-success" type="submit"  name="action" value="Modifier">
</f:form>


<table class="table table-bordered">
<tr>
<th>Code du citerne</th><th>Capacité</th>
<th>Prix Unitaire</th><th>quantité</th><th>qualite de huile</th>
<th>quantité acheté</th><th>Prix</th>
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
<script type="text/javascript">
var i = 1;
var Designation=[];

function JSCall(x){
     
	  var variable = $('#check'+x).val();
	  var variable2 = $('#qte'+x).val();
	  
	  
	  var typehuile= $('#qlit'+x).text();
		alert(typehuile);
		alert(variable);
		alert(variable2);
		 
		  
          var desgn="--"+variable2+" L de la citerne "+ variable +" de type "+typehuile+"--";
  		  
          i++; 
         // alert(desgn);
        	       
          Designation.push(desgn);
          var Array=[];
          for(var j=0;j<Designation.length;j++){
        	
        	  Array.push ("{"+Designation[j]+"}"+"</br>");
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
   	alert(uniter);
   	      
   	
	var prix_unit1= parseFloat(document.getElementsByTagName('table')[1].getElementsByTagName('tr')[x+1].cells[2].innerHTML);
	var qte_cit1= parseFloat(document.getElementsByTagName('table')[1].getElementsByTagName('tr')[x+1].cells[3].innerHTML);
	var qte_cmd =parseFloat(document.getElementById("qte"+x).value);
	
	if(uniter=="KL")
	{
		prix_unit=prix_unit1*klg;
		qte_cit=qte_cit1*klg;
		
	}else if(uniter=="L"){
		prix_unit=prix_unit1;
		qte_cit=qte_cit1;
		
	}else{
		
		alert("s'il vous plaît choisir l'unité de huile");
		document.getElementById("qte"+x).value="";
		return;
	}
	
	
	alert("qte"+x);
	
	if(document.getElementById("qte"+x).value==""){
		
		console.log("la quantié demandé est vide");
		
	}else{
	tabcode.push("qte"+x);
	tabval.push(qte_cmd);
	alert(qte_cmd);
	console.log("++++++++++++++");
	console.log(tabval);
	console.log(tabcode);
	
	}

	
	if(qte_cmd>qte_cit)
	{
		alert("la quantié demandé est supperieur de la quantité citerne");
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
		alert(r+"last indice");
		
		alert(tabval[r]);
		var k=tabval[r];
		if (r!=-1){
			alert(k+"ok");
			
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


</div>
</div>
</div>
 </div>
