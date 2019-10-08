<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body align="center">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<table width="100%" border="1" height="500px">
<tr>
<td >

<!-- ajouter dans la citerne -->
<f:form modelAttribute="citrne" action="AjouterHuile"  method="post" enctype="multipart/form-data">

<label for="Citernes">Choisir citernes</label> 
<f:select class="form-control" path="codeStock"  items="${Lcs}" itemValue="codeStock" itemLabel="codeStock"></f:select>
<f:errors path="codeStock" cssClass="errors"></f:errors>

<div class="form-group">
    <label for="Ajouter huile">Ajouter huile</label>
    <f:input path="quantiterAjtHuile" class="form-control"  placeholder="Tapez Qunatoté"/>
    <f:errors path="quantiterAjtHuile" cssClass="errors"></f:errors>  
  </div><br>

<input type="submit" value="Ajouter Huile"/>  

</f:form>
</td>
<td>
<!-- Retier olive dans  -->
<table>
<tr>
<f:form modelAttribute="cuv" action="RetirerOlive"  method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="Citernes">Choisir Cuve</label> 
<f:select class="form-control" path="codeStock"  items="${Lcuves}" itemValue="codeStock" itemLabel="codeStock"></f:select>
<f:errors path="codeStock" cssClass="errors"></f:errors><br>
</div>
<div class="form-group">
    <label for="Ajouter huile">Retirer Olive</label>
    <f:input path="quantiterRtrOlive" class="form-control"  placeholder="Tapez Qunatoté"/>
    <f:errors path="quantiterRtrOlive" cssClass="errors"></f:errors>  
  </div><br>
  
<input type="submit" value="Retirer Olive"/> <br> <br> <hr><br> <br> <br> <br> 
  
</f:form>
</tr>

<tr>

<!-- vider Cuve  -->

<f:form modelAttribute="cuves" action="viderCuve"  method="post" enctype="multipart/form-data">

<label for="Cuves">Choisir Cuve</label> 
<f:select class="form-control" path="codeStock"  items="${Lcuves}" itemValue="codeStock" itemLabel="codeStock"></f:select>
<f:errors path="codeStock" cssClass="errors"></f:errors><input type="submit" value="Vider Cuve"/>  
  
</f:form>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>