<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>

</head>


<body>	


<f:form modelAttribute="emplo"  action="emplRechercher"  method="post"  >
<td>Recherche par Cin:</td>
<td><f:input path="cinEmp"/></td>
<td><f:errors path="cinEmp" cssClass="error"></f:errors></td>  
<input type="submit" value="Rechercher"/> 
</f:form>
<c:if test="${ empty ep.exception }">

<table class="table" >
<tr>
<th>CIN employe</th><th>nom employe</th><th>Prenom employe</th><th>tel employe</th>
<th>adresse employe</th><th>grade employe</th><th>periode employe</th>
<th colspan="2">Action</th>
</tr>

<c:if test="${not empty ep.employ}"> 


<tr>
<td>${ep.employ.cinEmp}</td>
<td>${ep.employ.nomEmp}</td>
<td>${ep.employ.prenomEmp}</td>
<td>${ep.employ.telEmp}</td>
<td>${ep.employ.adrEmp}</td>
<td>${ep.employ.grade}</td>
<td>${ep.employ.periode}</td>
<td><a href="suppEmploye?cinEmp=${ep.employ.cinEmp}">Supp</a></td>
<td><a href="editEmploye?cinEmp=${ep.employ.cinEmp}">Edit</a></td>
</tr>
</c:if>
 




<c:if test="${  empty ep.employ}"> 


<c:forEach items="${ep.empll}" var="p" >

<tr>
<td>${p.cinEmp}</td>
<td>${p.nomEmp}</td>
<td>${p.prenomEmp}</td>
<td>${p.telEmp}</td>
<td>${p.adrEmp}</td>
<td>${p.grade}</td>
<td>${p.periode}</td>
<td><a href="suppEmploye?cinEmp=${p.cinEmp}">Supp</a></td>
<td><a href="editEmploye?cinEmp=${p.cinEmp}">Edit</a></td>
</tr>


</c:forEach>
</c:if>

</table>
<c:if test="${  empty ep.employ}"> 

 <div>
<c:forEach begin="0" end="${ep.nombrePages}" var="p"> 
<c:choose>
<c:when test="${p==ep.nombrePages}">
<span class ="current">page ${p}</span>
</c:when>
<c:otherwise>
<span class="autrePage">
<a href="ALLEmp?page=${p}&cinEmp=${ep.cinEmp}">page ${p}</a>
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
alert("Employer introuvale");
</script>

</div>
</c:if>



</body>
</html>

