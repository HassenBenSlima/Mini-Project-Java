<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

</head>


<body>	


<f:form modelAttribute="emplo"  action="clientRechercher"  method="post"  >
<td>Recherche par Cin:</td>
<td><f:input path="cinClient"/></td>
<td><f:errors path="cinClient" cssClass="error"></f:errors></td>  
<input type="submit" value="Rechercher"/> 
</f:form>
<c:if test="${ empty ep.exception }">

<table class="table" >

<tr>
<th>CIN Client</th><th>Nom Client</th><th>Prenom Client</th>
<th>Adresse Client</th><th>Teliphone Client</th>
<th colspan="2">Action</th>
</tr>

<c:if test="${not empty ep.clt}"> 

<tr>
	
<td>${ep.clt.cinClient}</td>
<td>${ep.clt.nomClient}</td>
<td>${ep.clt.prenomClient}</td>
<td>${ep.clt.adrClient}</td>
<td>${ep.clt.telClient}</td>

<td><a href="suppClient?CIN=${ep.clt.cinClient}">Supp</a></td>
<td><a href="editClient?CIN=${ep.clt.cinClient}">Edit</a></td>
</tr>
</c:if>
 
 <c:if test="${ empty ep.clt}"> 

<c:forEach items="${ep.listClient}" var="p" >
<tr>	
<td>${p.cinClient}</td>
<td>${p.nomClient}</td>
<td>${p.prenomClient}</td>
<td>${p.adrClient}</td>
<td>${p.telClient}</td>

<td><a href="suppClient?CIN=${p.cinClient}">Supp</a></td>
<td><a href="editClient?CIN=${p.cinClient}">Edit</a></td>
</tr>


</c:forEach>
</c:if>

</table>
 
 <c:if test="${ empty ep.clt}"> 
 
 <div>
<c:forEach begin="0" end="${ep.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==ep.nombrePages}">
<span class ="current">page ${p}</span>
</c:when>
<c:otherwise>
<span class="autrePage">
<a href="ALLClient?page=${p}&cinClient=${ep.cinClient}">page ${p}</a>
</span>
</c:otherwise>
</c:choose>
</c:forEach>
</div>
</c:if>
</c:if>

<c:if test="${not empty ep.exception }">
<div>
  ${ep.exception}
  <script type="text/javascript">  
  
  alert("Client introuvale");
  
  </script>
</div>
</c:if>




</body>
</html>

