<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div >
${exception}
</div>


<f:form modelAttribute="employe" action="saveEmploye"  method="post" enctype="multipart/form-data">

<table>
	
<tr>

<tr>
<td>CIN employe</td>
<td><f:input path="cinEmp"/></td>
<td><f:errors path="cinEmp" cssClass="errors"/></td>
</tr>

<tr>
<td>Nom Employe</td>
<td><f:input path="nomEmp"/></td>
<td><f:errors path="nomEmp" cssClass="errors"/></td>
</tr>

<tr>
<td>Prenom Employe</td>
<td><f:input path="prenomEmp"/></td>
<td><f:errors path="prenomEmp" cssClass="errors"/></td>
</tr>

<tr>
<td>Teliphone employe</td>
<td><f:input path="telEmp"/></td>
<td><f:errors path="telEmp" cssClass="errors"/></td>
</tr>  

<tr>
<td>Adrésse employe</td>
<td><f:textarea path="adrEmp"/></td>
<td><f:errors path="adrEmp" cssClass="errors"/></td>
</tr>  

<tr>
<td>Grade employe</td>
<td><f:select path="grade">
<f:option value="Chef" > Chef</f:option>
<f:option value="Ouvrier">Ouvrier</f:option>
</f:select></td>
<td><f:errors path="grade" cssClass="errors"/></td>
</tr> 
 
<tr>
<td>Poste employe</td>
<td><f:select path="periode">
<f:option value="6->14" > 6->14</f:option>
<f:option value="14->22">14->22</f:option>
<f:option value="22->6">22->6</f:option>
</f:select></td>
<td><f:errors path="periode" cssClass="errors"/></td>
</tr>  

<tr>
<td><input type="submit" name="action" value="Save"></td>
<td><input type="submit" name="action" value="Modifier"></td>
</tr>

</table>
</f:form>

