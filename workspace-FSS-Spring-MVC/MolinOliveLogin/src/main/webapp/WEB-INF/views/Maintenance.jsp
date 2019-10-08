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
		 document.location="suppMain?idMain="+id;
	 }
  }

</script>

<script>


$(function(){
	
	$('.datepicker').datepicker();	
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
	    $( "select option" ).each(function() {
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
	  alert( this.value ); // or $(this).val()
	  $('#frn').val(this.value );
	});
});


</script>

</head>
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">

<f:form modelAttribute="maint" action="saveMain" 
method="post" enctype="multipart/form-data">

<table class="table">
<tr>
<td><f:hidden path="idMain"/></td>
<td><f:errors path="idMain" cssClass="errors"></f:errors>
</tr>
<tr>
<td>Date de Maintenance :</td>
<td><f:input path="dateMain" class="datepicker" /></td>
<td><f:errors path="dateMain"  cssClass="errors" /></td>
</tr>

<tr>
<td>Prix Maintenance</td>

<td> <div class="input-group">
<div class="input-group-addon">$</div><f:input class="form-control"  path="prixMain"/><div class="input-group-addon">.00</div></div></td>
<td><f:errors path="prixMain" cssClass="errors"></f:errors></td>
</tr>

<tr>
<td>Tapez CIN de Fournisseur:</td>
<td><input  type="text"  id="frn"/>
</td>

<td><input type="text" name="frnname" id="frnname" disabled/>
</td>
</tr>

<tr>
<td>Fournisseurs</td> 
<td><f:select class="form-control" id="frns" path="fournisseurm.cinFourn"  items="${frnms}" itemValue="cinFourn" itemLabel="nomFourn"></f:select></td>
<td><a href="http://localhost:8081/ml/moulinOlive/indexfm">Gerer Fournisseur</a></td>
<td><f:errors path="fournisseurm.cinFourn" cssClass="errors"/></td>
</tr>
 <tr> 
<td><f:select  path="caissem.idCaisse"  items="${css}" itemValue="idCaisse" itemLabel="solde"></f:select></td>
<td><f:errors path="caissem.idCaisse" cssClass="errors"/></td>
</tr> 
<tr>
<td>description Maintenance</td>
<td><f:textarea   path="descpanne" cols="70" class="form-control"/></td>
<td><f:errors path="descpanne" cssClass="errors"></f:errors>
</tr>
 
<tr>
<td>
<c:if test="${maint.idMain==null}">
<input class="btn btn-success" type="submit" name="action" value="Save">
</c:if>
<c:if test="${maint.idMain!=null}">
<input class="btn btn-success" type="submit" name="action" value="Modifier">
</c:if>
</td>

</tr>
</table>
</f:form>

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

</div>
 </div>
  </div>
   </div>
