<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Reservation</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

<script type="text/javascript">
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppRsv?idRsv="+id;
	 }
	  alert("Suppression reussite");
  }

</script>

</head>
<!-- 
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
 -->



<body>
<div>
<div >
<f:form method="post" action="chargerClient" modelAttribute="rsvcl">
<table>
<tr>
<td>Tapez le Cin de Client: </td>
<td><f:input path="cinClient"/></td>
<td><f:errors path="cinClient" cssClass="error"></f:errors></td>

<td><input type="submit" value="OK"></td>
</tr>
</table>
</f:form>
</div>

<c:if test="${not empty rsvcl.client}"> <!-- quant le compte est not vide -->
<div>
<table>
<tr>
<td>Cin:</td>
<td>${rsvcl.client.cinClient}</td>
</tr>
<tr>
<td>nomClient</td>
<td>${rsvcl.client.nomClient}</td>
</tr> 
<tr>
<td>nomClient</td>
<td>${rsvcl.client.nomClient}</td>
</tr> 
<tr>
<td>prenomClient</td>
<td>${rsvcl.client.prenomClient}</td>
</tr>
<tr>
<td>adrClient</td>
<td>${rsvcl.client.adrClient}</td>
</tr>
<tr>
<td>telClient</td>
<td>${rsvcl.client.telClient}</td>
</tr> 
</table>
</div>

<div>
<table class="table13" >
<tr>
<th>Prix</th><th>date</th><th>description</th><th colspan="2">Action</th>
</tr>

<c:forEach items="${rsvcl.reservations}" var="op" >
<tr>
<td>${op.prixRsv}</td>
<td>${op.dateRsv}</td>
<td>${op.descriptionRsv}</td>
<td><a href="javascript:confirmation('${op.idRsv}')">Supp</a></td>
<td><a href="editRsv?idRsv=${op.idRsv}">Edit</a></td>


</tr>
</c:forEach>
</table>

 <div>
<c:forEach begin="0" end="${rsvcl.nombrePages-1}" var="p"> 

<c:choose>
<c:when test="${p==rsvcl.nombrePages}">
<span class ="current">page ${p}</span>
</c:when>
<c:otherwise>

<span class="autrePage">
<a href="chargerClient?page=${p}&cinClient=${rsvcl.cinClient}">page ${p}</a>
</span>

</c:otherwise>
</c:choose>

</c:forEach>
</div>
</div>
</c:if>
<c:if test="${not empty rsvcl.exception }">
<div>
  ${rsvcl.exception}
</div>

</c:if>

</div>
</body>
</html>