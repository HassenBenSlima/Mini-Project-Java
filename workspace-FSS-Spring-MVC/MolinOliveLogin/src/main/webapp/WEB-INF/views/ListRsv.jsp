<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-iso.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/datepicker.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" />


<script type="text/javascript">

$(function(){
	
	$('.datepicker').datepicker();	
});

</script>

<script type="text/javascript">
  function confirmation(id){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppRsv?idRsv="+id;
	  }
  }

</script>



</head>


<body>

<f:form modelAttribute="frol"  action="folRechercher"  method="post"  >

<div class="input-group">
<div class="input-group-addon">
         <i class="fa fa-calendar">
         Agenda</i>
        </div>
<f:input path="dateRsv" class="datepicker"  size="50" length="16"/></div>
<div><f:errors path="dateRsv" cssClass="error"></f:errors></div>  
</f:form>

<table class="table13"  >
<tr>
<th>ID rsv</th><th>prix rsv</th><th>date rsv</th><th>date rsv</th>
<th>description</th><th>cinClient</th>
<th>nomClient</th><th>prenomClient</th>
<th>telClient</th>
<th colspan="2">Action</th>
</tr>

<c:if test="${frol.rsvByDat==null}">
<c:forEach items="${epff}" var="pf" >
<tr>	
<td>${pf.idRsv}</td>
<td>${pf.prixRsv}</td>
<td>${pf.dateRsv}</td>
<td>${pf.descriptionRsv}</td>
<td>${pf.client.cinClient}</td>
<td>${pf.client.nomClient}</td>
<td>${pf.client.prenomClient}</td>
<td>${pf.client.telClient}</td>
<td><a href="javascript:confirmation('${pf.idRsv}')">Supp</a></td>
<td><a href="editRsv?idRsv=${pf.idRsv}">Edit</a></td>
</tr>
</c:forEach>
</c:if>


<c:if test="${empty frol.listRsv}">


<c:forEach items="${ep.listRsv}" var="pf" >
<tr>	
<td>${pf.idRsv}</td>
<td>${pf.prixRsv}</td>
<td>${pf.dateRsv}</td>
<td>${pf.descriptionRsv}</td>
<td>${pf.client.cinClient}</td>
<td>${pf.client.nomClient}</td>
<td>${pf.client.prenomClient}</td>
<td>${pf.client.telClient}</td>
<td><a href="javascript:confirmation('${pf.idRsv}')">Supp</a></td>
<td><a href="editRsv?idRsv=${pf.idRsv}">Edit</a></td>
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
<a href="ALLR?page=${p}">page ${p}</a>
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

