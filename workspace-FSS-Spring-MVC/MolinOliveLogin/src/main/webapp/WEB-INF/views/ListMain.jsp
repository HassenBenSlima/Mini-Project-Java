<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

<script type="text/javascript">
  function confirmation(cin){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppMain?CINFO="+idMain;
	  }
  }

</script>



</head>


<body>

<f:form modelAttribute="mainPF"  action="mainRechercher"  method="post"  >
<td>Recherche par Name:</td>
<td><f:input path="nameFourn"/></td>
<td><f:errors path="nameFourn" cssClass="error"></f:errors></td>  
</f:form>

<table class="table13"  >
<tr>
<th>Numero du maintenance</th><th>Description</th><th>Date de maintenance</th><th>Prix de Maintenance</th>
<th>Nom Fournisseur</th><th>Prenom Fournisseur</th>
<th>Teliphone Fournisseur</th><th colspan="2">Action</th>
</tr>


<c:if test="${mainPF.mainByName==null}">

<c:forEach items="${epff}" var="pf" >
<tr>	
<td>${pf.idMain}</td>
<td>${pf.descpanne}</td>
<td>${pf.dateMain}</td>
<td>${pf.prixMain}</td>
<td>${pf.fournisseurm.nomFourn}</td>
<td>${pf.fournisseurm.prenomFourn}</td>
<td>${pf.fournisseurm.telFourn}</td>


<td><a href="javascript:confirmation('${pf.idMain}')">Supp</a></td>
<td><a href="editMain?idMain=${pf.idMain}">Edit</a></td>
</tr>
</c:forEach>
</c:if>


<c:if test="${   empty mainPF.listmaints}">

<c:forEach items="${ep.listmaints}" var="p" >
<tr>	
<td>${p.idMain}</td>
<td>${p.descpanne}</td>
<td>${p.dateMain}</td>
<td>${p.prixMain}</td>
<td>${p.fournisseurm.nomFourn}</td>
<td>${p.fournisseurm.prenomFourn}</td>
<td>${p.fournisseurm.telFourn}</td>


<td><a href="javascript:confirmation('${pf.idMain}')">Supp</a></td>
<td><a href="editMain?idMain=${pf.idMain}">Edit</a></td>
</tr>
</c:forEach>
</c:if>
</table>
<div>
<c:forEach begin="0" end="${ep.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==ep.nombrePages}">
<span class ="current">page ${p}</span>
</c:when>
<c:otherwise>
<span class="autrePage">
<a href="ALLMain?page=${p}">page ${p}</a>
</span>
</c:otherwise>
</c:choose>
</c:forEach>
</div>


<c:if test="${not empty ep.exception }">
<div>
  ${ep.exception}
</div>
</c:if>




</body>
</html>

