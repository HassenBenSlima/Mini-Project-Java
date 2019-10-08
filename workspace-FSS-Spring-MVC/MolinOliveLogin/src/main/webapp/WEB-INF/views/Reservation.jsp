<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-iso.css"/>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" />



<script type="text/javascript">
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppRsv?idRsv="+id;
		 alert("Suppression reussite");
	  }
	  
  }

</script>



<script>


$(function(){

	
	
	$('.datepicker').datepicker(
			{
				format: 'dd/mm/yyyy',
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

  $('#client').on('input',function(e){
	  var search=$( this ).val();
	  var str = "";
	  var clientNames=[];
	  var clientCins=[];
	    $( "select option" ).each(function() {
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
	  alert( this.value ); // or $(this).val()
	  $('#client').val(this.value);
  });
  
});


</script>

</head>
<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">

<f:form modelAttribute="reservation" action="saveRsv" 
method="post" enctype="multipart/form-data">

<table class="table">
<tr>
<td><f:hidden path="idRsv"/></td>
<td><f:errors path="idRsv" cssClass="errors"></f:errors>
RESERVATION MOULIN D'OLIVE
</tr>
<tr>
<td>Date de Reservation :</td>


<td>
<div class="col-sm-10">
<div class="input-group">
<div class="input-group-addon">
         <i class="fa fa-calendar">
         </i>
        </div>
<f:input path="dateRsv" class="datepicker"  size="50" length="16"/></div></div></td>

<td><f:errors path="dateRsv"  cssClass="errors" /></td>
</tr>
  
<tr>
<td>Prix Reservation</td>

<td> <div class="input-group">
<div class="input-group-addon">$</div><f:input class="form-control"  path="prixRsv"/><div class="input-group-addon">.00</div></div></td>
<td><f:errors path="prixRsv" cssClass="errors"></f:errors></td>
</tr>

<tr>
<td>Tapez CIN de Client:</td>
<td><input class="" type="text" name="cl" id="client"/>
</td>

<td><input type="text"   name="clientname" id="clientname" disabled/>
</td>
</tr>

<tr>
<td>Clients</td> 
<td><f:select class="form-control" id="clients" path="client.cinClient"  items="${clients}" itemValue="cinClient" itemLabel="nomClient"></f:select></td>
<td><a href="http://localhost:8085/ml/moulinClient/index">Gerer Client</a></td>
<td><f:errors path="client.cinClient" cssClass="errors"></f:errors></td>

</tr>

<tr>
<td>descriptionRsv</td>
<td><f:textarea   path="descriptionRsv" cols="70" class="form-control"/></td>
<td><f:errors path="descriptionRsv" cssClass="errors"></f:errors>
</tr>
 
<tr>
<td>
<c:if test="${reservation.idRsv==null}">
<input class="btn btn-success" type="submit" name="action" value="Save">
</c:if>
<c:if test="${reservation.idRsv!=null}">
<input class="btn btn-success" type="submit" name="action" value="Modifier">
</c:if>
</td>

</tr>
</table>
</f:form>

<table class="table table-bordered">
<tr>
<th>Date</th><th>Client</th>
<th>Prix</th><th>Description</th>
<th colspan="2">M-A-J</th>
</tr>

<c:forEach items="${reservations}" var="r"> 

<tr>
<td>${r.dateRsv}</td>
<td>${r.client.nomClient}</td>
<td>${r.prixRsv}</td>
<td>${r.descriptionRsv}</td>

<td><a href="javascript:confirmation('${r.idRsv}')">Supp</a></td>
<td><a href="editRsv?idRsv=${r.idRsv}">Edit</a></td>
</tr>
</c:forEach>

</table>

</div>
 </div>
  </div>
   </div>
