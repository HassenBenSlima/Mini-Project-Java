<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<script type="text/javascript">
  function confirmation(code){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppCiterne?code="+code;
	  }
  }

</script>

</head>
	
<div >
${exception}
</div>

<f:form modelAttribute="citerne" action="saveCiterne"  method="post" enctype="multipart/form-data">
 
<table class="table">
<tr>

<tr>
<td>Reference Citerne</td>
<td><f:input path="codeStock"/></td>
<td><f:errors path="codeStock" cssClass="errors"/></td>
</tr>
<tr>
<td>Capacité max</td>
<td><f:input path="capacite"/></td>
<td><f:errors path="capacite" cssClass="errors"/></td>
</tr>

<tr>
<td>Prix Unitaire</td>
<td><f:input path="prixUT"/></td>
<td><f:errors path="prixUT" cssClass="errors"/></td>
</tr>  

<tr>
<td>Quantité de huile</td>
<td><f:textarea path="quantiteHuile"/></td>
<td><f:errors path="quantiteHuile" cssClass="errors"/></td>
</tr>  

<tr>
<td>Qualité de huile</td>
<td><f:input path="qualiteHuile"/></td>
<td><f:errors path="qualiteHuile" cssClass="errors"/></td>
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
<th>Reference du citerne </th><th> Capacite Max</th><th>prixUT</th>
<th>quantiteHuile</th><th>qualiteHuile</th>
</tr>

<c:forEach items="${citernes}" var="c"> 

<tr>
<td>${c.codeStock}</td>
<td>${c.capacite}</td>
<td>${c.prixUT}</td>
<td>${c.quantiteHuile}</td>
<td>${c.qualiteHuile}</td>

<td><a href="javascript:confirmation('${c.codeStock}')">Supp</a></td>
<td><a href="editCiterne?code=${c.codeStock}">Edit</a></td>
</tr>

</c:forEach>
</table>