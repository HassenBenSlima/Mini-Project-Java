<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Citerne</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

<script type="text/javascript">
  function confirmation(code){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppCuve?code="+code;
	  }
  }

</script>

</head>
<body>	

<div >
${exception}
</div>

<f:form modelAttribute="cuver"  action="cuveRechercher"  method="post"  >
<td>Recherche par Reference:</td>
<td><f:input path="codeStock"/></td>
<td><f:errors path="codeStock" cssClass="error"></f:errors></td>  
<input type="submit" value="Rechercher"/> 
</f:form>
<table class="table" >

<tr>
<th>Code Citerne</th><th>capacite</th>
<th>quantite actuelle</th><th colspan="2">Action</th>
</tr>


<c:if test="${ empty cuver.rechCuveByName}"> 

<c:forEach items="${cv}" var="cc" >

<tr>
<td>${cc.codeStock}</td>
<td>${cc.capacite}</td>
<td>${cc.quantiteactOL}</td>


<td><a href="javascript:confirmation('${cc.codeStock}')">Supp</a></td>
<td><a href="editCiterne?code=${cc.codeStock}">Edit</a></td>
</tr>
</c:forEach>
</c:if>
 
<c:if test="${ empty cuver.listcuve}"> 

<c:forEach items="${cve.listcuve}" var="cc" >
<tr>
<td>${cc.codeStock}</td>
<td>${cc.capacite}</td>
<td>${cc.quantiteactOL}</td>
<td><a href="javascript:confirmation('${cc.codeStock}')">Supp</a></td>
<td><a href="editCuve?code=${cc.codeStock}">Edit</a></td>
</tr>
</c:forEach>
</c:if>

</table>
<c:if test="${ empty cuver.rechCuveByName}"> 

<div>
<c:forEach begin="0" end="${cve.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==citern.nombrePages}">
<span class ="current">page ${p}</span>
</c:when>
<c:otherwise>
<span class="autrePage">
<a href="ALLCuve?page=${p}&codeStock=${cve.codeStock}">page ${p}</a>
</span>
</c:otherwise>
</c:choose>
</c:forEach>
</div>
</c:if>

<c:if test="${not empty cuver.exception }">
<div>
  ${cuver.exception}
</div>

</c:if>

</body>
</html>