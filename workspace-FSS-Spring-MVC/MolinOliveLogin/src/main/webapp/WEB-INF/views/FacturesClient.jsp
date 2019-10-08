<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<meta charset="UTF-8">
<title>Factures Client</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

<script type="text/javascript">
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppFacture?idfacture="+id;
		 alert("Suppression reussite");
	  }
	 
  }

</script>

</head>

<body>
<div>
<div >
<f:form method="post" action="chargerFacture" modelAttribute="factcl">
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

<c:if test="${not empty factcl.client}"> <!-- quant le compte est not vide -->
<div>
<table>
<tr>
<td>Numero de carte identité : </td>
<td>${factcl.client.cinClient}</td>
</tr>
<tr>
<td>Nom du client</td>
<td>${factcl.client.nomClient} : </td>
</tr> 
<tr>
<td>Prenom du client : </td>
<td>${factcl.client.prenomClient}</td>
</tr>
<tr>
<td>Adresse du client</td>
<td>${factcl.client.adrClient}</td>
</tr>
<tr>
<td><h2>Numero du teliphone: </h2> </td>
<td>${factcl.client.telClient}</td>
</tr> 
</table>
</div>

<div>
<table class="table13" >
<tr>
<th>Type de reglement</th><th>Date</th><th>Montant</th>
<th>Quantité</th><th>description</th><th>Action</th>
</tr>

<c:forEach items="${factcl.factureClient}" var="fc" >
<tr>
<td>${fc.typeReglement}</td>
<td>${fc.dateVente}</td>
<td>${fc.montantf}</td>
<td>${fc.quantite}</td>
<td>${fc.designation}</td>
<td><a href="javascript:confirmation('${fc.idVente}')">Supp</a></td>
</tr>
</c:forEach>
</table>

 <div>
<c:forEach begin="0" end="${factcl.nombrePages-1}" var="p"> 

<c:choose>
<c:when test="${p==factcl.nombrePages}">
<span class ="current">page ${p}</span>
</c:when>
<c:otherwise>

<span class="autrePage">
<a href="chargerFacture?page=${p}&cinClient=${factcl.cinClient}">page ${p}</a>
</span>

</c:otherwise>
</c:choose>

</c:forEach>
</div>
</div>
</c:if>
<c:if test="${not empty factcl.exception }">
<div>
  ${factcl.exception}
</div>

</c:if>

</div>
</body>
</html>