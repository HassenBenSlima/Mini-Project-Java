<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<script type="text/javascript">
  function confirmation(code){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppCuve?code="+code;
	  }
  }

</script>
</head>
	
<div >
${exception}
</div>

<f:form modelAttribute="cuve" action="saveCuve"  method="post" enctype="multipart/form-data">
 
<table class="table">


<tr>
<td>Reference Cuve</td>
<td><f:input path="codeStock"/></td>
<td><f:errors path="codeStock" cssClass="errors"/></td>
</tr>

<tr>
<td>Capacité max</td>
<td><f:input path="capacite"/></td>
<td><f:errors path="capacite" cssClass="errors"/></td>
</tr>

<tr>
<td>Quantiter initiale :</td>
<td><f:input path="quantiteactOL"/></td>
<td><f:errors path="quantiteactOL" cssClass="errors"/></td>
</tr>  

<tr>
<td>
<input class="btn btn-success" type="submit" name="action" value="Save">
</td>
<td>
<input class="btn btn-success" type="submit" name="action" value="Modifier">
</td>
</tr>

</table>
</f:form>

<table class="table">
<tr>
<th>Nom de  Cuve </th><th> Capacite Max</th><th>Quantité actuel</th>
</tr>

<c:forEach items="${cuves}" var="v"> 

<tr>
<td>${v.codeStock}</td>
<td>${v.capacite}</td>
<td>${v.quantiteactOL}</td>

<td><a href="javascript:confirmation('${v.codeStock}')">Supp</a></td>
<td><a href="editCuve?code=${v.codeStock}">Edit</a></td>
</tr>

</c:forEach>
</table>