<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>


<script type="text/javascript">
  function confirmation(cin){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppFrnsM?CINFM="+cin;
	  }
  }

</script>
</head>


<body>

<f:form modelAttribute="frm"  action="foRechercher"  method="post"  >
<td>Recherche par Name:</td>
<td><f:input path="nomFourn"/></td>
<td><f:errors path="nomFourn" cssClass="error"></f:errors></td>  
</f:form>

<table class="table13"  >
<tr>
<th>CIN Fournisseur</th><th>Nom Fournisseur</th><th>Prenom  Fournisseur</th><th>tel Fournisseur</th>
<th>adresse Fournisseur</th><th colspan="2">Action</th>
</tr>


<c:if test="${frm.listfrounByname==null}">

<c:forEach items="${epff}" var="pf" >
<tr>	
<td>${pf.cinFourn}</td>
<td>${pf.nomFourn}</td>
<td>${pf.prenomFourn}</td>
<td>${pf.telFourn}</td>
<td>${pf.adrFourn}</td>
<td><a href="javascript:confirmation('${pf.cinFourn}')">Supp</a></td>
<td><a href="editfrns?CINFM=${pf.cinFourn}">Edit</a></td>
</tr>
</c:forEach>
</c:if>


<c:if test="${   empty frm.listFournMain}">


<c:forEach items="${ep.listFournMain}" var="p" >
<tr>	
<td>${p.cinFourn}</td>
<td>${p.nomFourn}</td>
<td>${p.prenomFourn}</td>
<td>${p.telFourn}</td>
<td>${p.adrFourn}</td>

<td><a href="javascript:confirmation('${p.cinFourn}')">Supp</a></td>
<td><a href="editfrns?CINFM=${p.cinFourn}">Edit</a></td>
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
<a href="ALLFO?page=${p}">page ${p}</a>
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

