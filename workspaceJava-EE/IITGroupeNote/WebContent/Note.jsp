<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Note</title>
	<script type="text/javascript">
	function confirmation(id){
		var conf=confirm("Etes vous sure de vouloir supprimer?");
		if(conf)
		{	
			document.location="NoteController?action=supp&id="+id;
			
		} 
	}

	</script>
</head>
<body>
	<h1>Ajout Note </h1>
	<form action="NoteController" method="post">
		<table>
			<tr>
				<td>code Matiére:</td>
				<td>
					<SELECT name="codeM" >
						<option value="0" ></option>
						<c:forEach items="${matiere}" var="m">
						<c:if test="${note.codeM == m.code}">
						<option value="${m.code}" selected>${m.libelle}</option>
					</c:if>
					<c:if test="${note.codeM != m.code}">
					<option value="${m.code}" >${m.libelle}</option>
				</c:if>
			</c:forEach>
		</SELECT>
	</td></tr>
	<tr>
		<td>code étudiant:</td>
		<td>
			<SELECT name="codeEt" >
				<option value="0" ></option>
				<c:forEach items="${etudiant}" var="e">
				<c:if test="${note.codeEt == e.code}">
				<option value="${e.code}" selected>${e.nom} ${e.prenom}</option>
			</c:if>
			<c:if test="${note.codeM != e.code}">
			<option value="${e.code}" >${e.nom} ${e.prenom}</option>
		</c:if>
	</c:forEach>
</SELECT>
</td></tr>
<tr>
	<td>note Tp</td>
	<td><input type="text" name="noteTP" value="${note.noteTP}"></td>
</tr>
<tr>
	<td>note Ds</td>
	<td><input type="text" name="noteDs" value="${note.noteDs}"></td>
</tr>
<tr>
	<td>note Exam</td>
	<td><input type="text" name="noteExam" value="${note.noteExam}"></td>
</tr>
<tr>
	<td>Note Presentielle</td>
	<td><input type="text" name="NotePresentielle" value="${note.NotePresentielle}"></td>
</tr>
<tr>
	<td>compostage</td>
	<td><input type="text" name="compostage" value="${note.compostage}"></td>
</tr>
<tr><td>
	<c:if test="${note==null }"><input type="submit" name="action" value="Valider">
</c:if>
<c:if test="${note!=null }">
<input type="submit" name="action" value="Update">
</td></tr>
</c:if>
</table>
</form>


<table>
	<tr>
		<th>code Matiére:</th><th>code étudiant</th><th>Note Tp</th><th>Note Ds</th>
		<th>Note Exam</th><th>NotePresentielle</th><th>compostage</th>
	</tr>
	<c:forEach items="${note}" var="n">
	<tr>
		<td>${n.codeM}</td>
		<td>${n.codeEt}</td>
		<td>${n.noteTP}</td>
		<td>${n.noteDS}</td>
		<td>${n.noteExam}</td>
		<td>${n.NotePresentielle}</td>
		<td>${n.compostage}</td>
		<td><a href="javascript:confirmation('${n.codeM}')">Supprimer</td>
		<td><a href="NoteController?action=edit&cod=${n.codeM}">Modifier</td>
	</tr>
</c:forEach>


</body>
</html>