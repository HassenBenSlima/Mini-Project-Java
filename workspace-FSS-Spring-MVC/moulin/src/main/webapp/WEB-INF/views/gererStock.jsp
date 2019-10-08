<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerer Stock</title>

<!--Style Template-->
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" />
   <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
<!--Fin Style-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-iso.css"/>

<!-- Menu -->
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
 <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</head>

<script  type="text/javascript">
function find(arr, obj) {
    for(var i=0; i<arr.length; i++) {
        if (arr[i].indexOf(obj)> -1) return i;
    }
    return -1;
}
 
jQuery( document ).ready(function( $ ) {
  // Code using $ as usual goes here.
    

  $('select#ct').on('change', function() {
	 
	  var search=$( this ).val();
//	  alert(search);
	//  $(search).prop('selected', true);
	  
	  var str = "";
	  var Names=[];
	    $( "select#q option" ).each(function() {
	      str += $( this ).text() + ",";
	      str += $( this ).val() + "-";
			 console.log(str);
	    
	      Names.push($( this ).val());
	    });
	    
	    
	    index=find(Names,search);
		 if(index!=-1)
			{
			 console.log(index);
			 
			 var idSelector="#q option[value="+Names[index]+"]";
			 $(idSelector).prop('selected', true);
			}else
				{
				console.log("erreur");}
		    
		   
		    });

  $('select#vs').on('change', function() {
	 
	  var search=$( this ).val();
//	  alert(search);
	//  $(search).prop('selected', true);
	  
	  var str = "";
	  var Names=[];
	    $( "select#vk option" ).each(function() {
	      str += $( this ).text() + ",";
	      str += $( this ).val() + "-";
			 console.log(str);
	    
	      Names.push($( this ).val());
	    });
	    
	    
	    index=find(Names,search);
		 if(index!=-1)
			{
			 console.log(index);
			 
			 var idSelector="#vk option[value="+Names[index]+"]";
			 $(idSelector).prop('selected', true);
			}else
				{
				console.log("erreur");}
		    
		   
		    });

  $('select#h').on('change', function() {
	 
	  var search=$( this ).val();
//	  alert(search);
	//  $(search).prop('selected', true);
	  
	  var str = "";
	  var Names=[];
	    $( "select#vk option" ).each(function() {
	      str += $( this ).text() + ",";
	      str += $( this ).val() + "-";
			 console.log(str);
	    
	      Names.push($( this ).val());
	    });
	    
	    
	    index=find(Names,search);
		 if(index!=-1)
			{
			 console.log(index);
			 
			 var idSelector="#vk option[value="+Names[index]+"]";
			 $(idSelector).prop('selected', true);
			}else
				{
				console.log("erreur");}
		    
		   
		    });
	    	    
  }); 
</script>



<body >
<!-- START PAGE SOURCE -->
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
       <h1> <a href="<c:url value="/moulin/Caisse/indexcaisse"/>"><small>Societé</small>
          Moulin d'olive.</a></h1><br/><br />
      </div>

      <div class="logo_text"><a href="<c:url value="/moulin/FactureImp/indexfac"/>">Commande</a> | <a href="<c:url value="/j_spring_security_logout" />" >Deconnection</a></div>
      <div class="clr"></div>
    </div>
	
		  <div>
	  
<!--Menu-->
<div class="container">
  <ul class="nav nav-tabs">
    <li class=""><a href="<c:url value="/moulin/Caisse/indexcaisse"/>">Accueil</a></li>
    <li class="dropdown">
     <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Reservations <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinOlive/indexr"/>">Ajouter une reservation</a></li>
        <li><a href="<c:url value="/moulin/moulinOlive/ALLR"/>">Consulter les reservations</a></li>                        
     
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Commande<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/FactureImp/indexfac"/>">Ajouter une commande</a></li>
        <li><a href=" <c:url value="/moulin/FactureImp/indexfactClient"/>">Factures du client</a></li>                        
      </ul>
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Achat d'olive <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinBonAchat/indexba"/>">Ajouter un achat</a></li>
        <li><a href="<c:url value="/moulin/moulinBonAchat/indexfrnsbonachat"/>">Bons d'achats du fournisseur</a></li>  
        <li><a href="<c:url value="/moulin/moulinFrns/ALLFOL"/>">Consulter les fournisseurs</a></li>  		
      </ul>
      
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Maintenance <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinOlive/indexmta"/>">Ajouter une maintenance</a></li>
        <li><a href="<c:url value="/moulin/moulinOlive/ALLMain"/>">Consulter les maintenances</a></li>                        
      <li><a href="<c:url value="/moulin/moulinFrns/ALLFO"/>">Consulter les fournisseurs</a></li> 
	  </ul>
	  
    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Fournisseurs <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinFrns/indexfm"/>">Fournisseur de maintenance</a></li>
        <li><a href="<c:url value="/moulin/moulinFrns/indexfo"/>">Fournisseur d'olive</a></li>                        
      </ul>

    </li>
	<li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="active">Stock <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<c:url value="/moulin/moulinStock/indexv"/>">Stock d'olive</a></li>
        <li><a href="<c:url value="/moulin/moulinStock/indexc"/>">Stock d'huile</a></li>                        
        <li><a href="<c:url value="/moulin/moulinStock/indexhuile"/>">Gerer le stock</a></li>                        
      
      </ul>
    </li>
	<!--<li><a href="#">Menu 2</a></li>-->
  </ul>
</div>
<!--Fin Menu-->

   <!--Gestion du molin d'olive-->

</div >
    <div class="headert_text_resize">
     
      <div class="clr"></div>
      <h2 class="bigtext"><span> Gestion <br/>du Moulin d'Olive</span></h2>
       
    </div>
  </div>
 <!--Fin Gestion du molin d'olive-->
      <div class="body"><div class="body_resize">

  <!--Menu left-->
   
   <table align="left">
   <tr>
   
    <td>
   <br/>
   <div align="center">
        <div class="list-group">
  <a href="#" class="list-group-item disabled">Sous menu</a>
  <a href=" <c:url value="/moulin/moulinStock/indexhuile" />" class="list-group-item active">Gérer le stock </a>
  <a href="<c:url value="/moulin/moulinStock/ALLCiterne" />" class="list-group-item ">Consulter la liste des citernes</a>
  <a href=" <c:url value="/moulin/moulinStock/ALLCuve" />" class="list-group-item">Consulter la liste des cuves</a>
</div>
</div>
       </td>
		  
  
   <td>
   </tr>
   </table>
   
   <!--Menu left-->
   
   <!--Code  J2ee-->
   
   <table width="70%" align="center">
   <tr>
   <td>
   <div align="center">
      <h2>Gérer le stock</h2>
   </div>
<!--Formulaire J2ee-->
<div align="center" class="lead bg-info">
${error}
</div>
<table width="90%"  class="table table-bordered" height="500px">
<tr>
<td >

<div class="alert alert-success" align="center">Ajouter Huile</div>
<br><br><br><br>
<!-- Affiche citerne -->

<f:form modelAttribute="cc" action="#"  method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="Quantité actuel">Quantité actuelle</label> 
<f:select class="form-control" path="citernes" disabled="true"  id="q" items="${Lcs}" itemValue="codeStock" itemLabel="quantiteHuile"></f:select>
<f:errors path="codeStock" cssClass="errors"></f:errors>
</div>
</f:form>

<!-- ajouter dans la citerne -->
<f:form modelAttribute="citrne" action="AjouterHuile"  method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="Citernes" align="left">Choisir citernes</label> 
<f:select class="form-control" path="codeStock"  id="ct" items="${Lcs}" itemValue="codeStock" itemLabel="codeStock"></f:select>
<f:errors path="codeStock" cssClass="errors"></f:errors>
</div>
<div class="form-group">
    <label for="Ajouter huile" >Quantité d'huile</label>
    <f:input path="quantiterAjtHuile" class="form-control"  placeholder="Tapez Qunatoté"/>
    <f:errors path="quantiterAjtHuile" cssClass="errors"></f:errors>  
  </div><br>

<input type="submit" value="Ajouter Huile" class="btn btn-primary"/>  

</f:form>
</td>
<td>

<div class="alert alert-success" align="center" >Retiter Olive</div>


<!-- Retier olive  -->
<table>
<tr>
<!-- Affiche cuve -->

<f:form modelAttribute="vv" action="#"   method="post" enctype="multipart/form-data">
<div class="form-group">

<label for="Quantité actuel OLive">Quantité actuelle</label> 
<f:select class="form-control" path="cuve" id="vk"  disabled="true"  items="${Lcuves}" itemValue="codeStock" itemLabel="quantiteactOL"></f:select>

<f:errors path="codeStock" cssClass="errors"></f:errors>
</div>
</f:form>
<hr/>
<f:form modelAttribute="cuv" action="RetirerOlive"  method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="Citernes">Choisir Cuve</label> 
<f:select class="form-control" path="codeStock" id="vs" items="${Lcuves}" itemValue="codeStock" itemLabel="codeStock"></f:select>
<f:errors path="codeStock" cssClass="errors"></f:errors><br>
</div>
<div class="form-group">
    <label for="Ajouter huile">Quantité d'olive</label>
    <f:input path="quantiterRtrOlive" class="form-control"  placeholder="Tapez Qunatoté"/>
    <f:errors path="quantiterRtrOlive" cssClass="errors"></f:errors>  
  </div>
  
<input type="submit" value="Retirer Olive" class="btn btn-primary"/><hr>
</f:form>
</tr>

<tr>

<!-- vider Cuve  -->
<div class="alert alert-success" align="center">Vider Cuve</div>

<f:form modelAttribute="cuves" action="viderCuve"  method="post" enctype="multipart/form-data">

<label for="Cuves">Choisir Cuve</label> 
<f:select class="form-control" path="codeStock" id="h" items="${Lcuves}" itemValue="codeStock" itemLabel="codeStock"></f:select>
<f:errors path="codeStock" cssClass="errors"></f:errors><br>
<input type="submit" value="Vider Cuve" class="btn btn-primary"/>  
  
</f:form>
</tr>
</table>
</td>
</tr>
</table>
<br><br><br><br><br>







<!--Fin Formulaire J2ee-->
   
	
	  </td>
  </tr>
	  </table>
	</div>  
	  <div>
	   </div>








</div></div>





</body>
</html>