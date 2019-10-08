<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>

<script type="text/javascript">
  function confirmation(code){
	var conf=confirm("Etes vous sure de vouloir supprimer?");
	  if(conf==true){
		 document.location="suppFrnsM?CINFM="+code;
	  }
  }

</script>

</head>
	
<div >
${exception}
</div>

					
<f:form modelAttribute="frnm" action="saveFrnM"  method="post" enctype="multipart/form-data">
 <p>Fournisseur de Maintenance</p>
<table class="table">
<tr>

<tr>
<td>CIN Fournisseur</td>
<td><f:input path="cinFourn"/></td>
<td><f:errors path="cinFourn" cssClass="errors"/></td>
</tr>

<tr>
<td>Nom du Fournisseur</td>
<td><f:input path="nomFourn"/></td>
<td><f:errors path="nomFourn" cssClass="errors"/></td>
</tr>

<tr>
<td>Prenom du Fournisseur</td>
<td><f:input path="prenomFourn"/></td>
<td><f:errors path="prenomFourn" cssClass="errors"/></td>
</tr>  

<tr>
<td>Teliphone du fornisseur</td>
<td><f:input path="telFourn"/></td>
<td><f:errors path="telFourn" cssClass="errors"/></td>
</tr> 
 
<tr>
<td>Adresse du fournisseur</td>
<td><f:input path="adrFourn"/></td>
<td><f:errors path="adrFourn" cssClass="errors"/></td>
</tr> 
<tr>
<td>
<c:if test="${frnm.cinFourn==null}">
<input class="btn btn-success" type="submit" name="action" value="Save">
</c:if>
<c:if test="${frnm.cinFourn!=null}">
<input class="btn btn-success" type="submit" name="action" value="Modifier">
</c:if>
</td>
</tr>

</table>
</f:form>

