<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Factures Client</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

<script type="text/javascript">
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppBA?idBA="+id;
		 alert("Suppression reussite");
	  }
	 
  }

</script>

</head>

<body>
<div>
<div >
<f:form method="post" action="chargerBon" modelAttribute="factcl">
<table>
<tr>
<td>Tapez le Cin de Fournisseur </td>
<td><f:input path="cinFourn"/></td>
<td><f:errors path="cinFourn" cssClass="error"></f:errors></td>

<td><input type="submit" value="OK"></td>
</tr>
</table>
</f:form>
</div>

<c:if test="${not empty factcl.fro}"> <!-- quant le compte est not vide -->
<div>
<table>
<tr>
<td>Numero de carte identité : </td>
<td>${factcl.fro.cinFourn}</td>
</tr>
<tr>
<td>Nom du Fournisseur</td>
<td>${factcl.fro.nomFourn} : </td>
</tr> 
<tr>
<td>Prenom du Fournisseur : </td>
<td>${factcl.fro.prenomFourn}</td>
</tr>
<tr>
<td>Adresse du Fournisseur</td>
<td>${factcl.fro.adrFourn}</td>
</tr>

</table>
</div>

<div>
<table class="table13" >
<tr>
<th>Type de reglement</th><th>Date</th><th>Montant</th>
<th>Quantité</th><th>description</th><th>Action</th>
</tr>

<c:forEach items="${factcl.listbons}" var="fc" >
<tr>
<td>${fc.idBA}</td>
<td>${fc.dateBA}</td>
<td>${fc.montantAchat}</td>
<td>${fc.maturite}</td>
<td>${fc.quantiteOL}</td>
<td>${fc.regionOlive}</td>
<td>${fc.designation}</td>
<td><a href="javascript:confirmation('${fc.idBA}')">Supp</a></td>
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
<a href="chargerBon?page=${p}&cinFourn=${factcl.cinFourn}">page ${p}</a>
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