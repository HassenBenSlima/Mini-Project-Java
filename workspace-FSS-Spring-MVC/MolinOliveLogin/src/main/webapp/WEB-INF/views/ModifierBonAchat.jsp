<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-iso.css"/>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
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

</head>
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">

<f:form modelAttribute="ba" action="modifierBA" 
method="post" enctype="multipart/form-data">

	
	
<table width="150%" heigth="100px">

<tr>
<td><f:hidden path="idBA" class="form-control"/></td>
<td><f:errors path="idBA" cssClass="errors"></f:errors>
</tr>
<tr>
<td>Montant Achat</td>
<td><f:input path="MontantAchat" class="form-control"/><br></td>

<td><f:errors path="MontantAchat"  cssClass="errors" /><br></td>
</tr>

<tr>
<td>Tapez CIN de Fournisseur:<br></td>
<td><input  type="text"  id="frn" class="form-control"/><br>
</td>

<td><input type="text" name="frnname" id="frnname" disabled class="form-control"/><br>
</td>
</tr>

<tr>
<td>Fournisseurs<br></td> 
<td><f:select class="form-control" id="frns" path="fournisseuro.cinFourn"  items="${frns}" itemValue="cinFourn" itemLabel="nomFourn"></f:select><br></td>
<td><a href="http://localhost:8082/ml/moulinOlive/indexfo">Gerer Fournisseur</a><br></td>
<td><f:errors path="fournisseuro.cinFourn" cssClass="errors"/></td>
</tr>

<tr>
<td>Cuve<br></td> 
<td><f:select class="form-control" id="cvs" path="stocko.codeStock"  items="${cv}" itemValue="codeStock" itemLabel="codeStock"></f:select><br></td>
<td><f:errors path="stocko.codeStock" cssClass="errors"/></td>
</tr>

 <tr> 
<td><f:select  path="caisse.idCaisse"  items="${css}" itemValue="idCaisse" itemLabel="solde"></f:select></td>
<td><f:errors path="caisse.idCaisse" cssClass="errors"/></td>
</tr>
<tr>
<td>Maturite</td>
<td><f:input   path="maturite" class="form-control"/></td>
<td><f:errors path="maturite" cssClass="errors"></f:errors>
</tr>
<tr>
<td>Quantite Olive</td>
<td><f:input   path="quantiteOL"  class="form-control"/></td>
<td><f:errors path="quantiteOL" cssClass="errors"></f:errors>
</tr>
<tr>
<td>Designation</td>
<td><f:textarea   path="designation"  class="form-control"/></td>
<td><f:errors path="designation" cssClass="errors"></f:errors>
</tr>
<tr>
<td>Region Olive</td>
<td><f:input   path="regionOlive"  class="form-control"/></td>
<td><f:errors path="regionOlive" cssClass="errors"></f:errors>
</tr> 
<tr>
<td>
<c:if test="${empty ba.idBA}">
<input class="btn btn-success" type="submit" name="action" value="Ajouter">
</c:if>
</td>
<td>
<c:if test="${not empty ba.idBA}">
<input class="btn btn-success" type="submit" name="action" value="Modifier">
</c:if>
</td>

</tr>
</table>
</f:form>

</div>
 </div>
  </div>
   </div>
