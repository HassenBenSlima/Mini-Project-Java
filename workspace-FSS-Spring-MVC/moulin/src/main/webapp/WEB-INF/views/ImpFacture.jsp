<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Imprimer Facture</title>    
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/custom-style.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/print.css" media="print" />



<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jspdf.debug.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/pdfFromHTML.js"></script>


</head>
<body>


	
<!--  -->


<div id="pdf2htmldiv">


<div>

 <div class="container" >
     
    
     <table class="table">
	 <tr>        
       <td>
		     <img src="<%=request.getContextPath()%>/resources/images/olive.png" style="padding-bottom:20px;"width="400px"  height="120px"/> 
        
      </td>
      <td>
 <div align="center">      <a  onclick="javascript:window.print();"  > 
             <img alt="Imriper" src="<%=request.getContextPath()%>/resources/images/imprime.png"  width="50%">
        
             </a><br/>
 <strong id="testdiv" >Imprimer</strong></div> 
      
      
      </td>
       <td>         
		
            
               <strong>  Entreprise du Moulin d'Olive</strong>
              <br />
                  <i>Address :</i>  Tunis 
              <br />
                  Route de Madia
              <br />
                  Sfax
              
        </td>
		</tr>
		 </table>

             <table width="100%" class="table">
             <tr>
             <td>
			 
                 <strong id="testdiv" >Email : </strong>  MoulinOlive@Tunisie.com 
             </td>
			 <td>
               <strong>Téléphone : </strong>  +216 -xx- xxx-xxx 
             <br>
              
                 <strong>Fax : </strong>  +216-xxx-xxx 
             
			 </td>
			 <tr>
			 </table>
             <hr/>
         
     <div><center><h1 style="color:#086B7C">Facture   Num:${facs.idVente } </h1></center></div>
    
           <table width="100%" class="table table-striped table-bordered table-hover" >
		 <tr>
		 <td >
		 
         <h4><strong>Information du client : </strong></h4>
     <b>CIN :</b>      <strong>  ${facs.client.cinClient }</strong>
             <br />
        <b>Nom :</b>   <strong>  ${facs.client.nomClient } </strong>
             <br />
            <b>Prenom :</b><strong> ${facs.client.prenomClient }</strong>
             <br />
                <b>Address :</b>${facs.client.adrClient }
             <br />
             <b>Téléphone :</b> ${facs.client.telClient }
              </td>
		 
		 
		 


		 <td>
            
               <h4>  <strong>Detail de paiement : </strong></h4>
           <b>Type de paiement:</b> <b>  ${facs.typeReglement } </b>
              <br />
               <b>Date de vente :</b>  <b>${facs.dateVente }</b>
              <br />




         





		 </td>
		</tr>
		 </table>
 
	 
	 
	 
                            <table class="table table-bordered">
                            <thead>
                                <tr class="info">
                                    <th>Quantité</th>
                                    <th>Designation</th>
                                     <th>Type de reglement</th>
                                     <th>Montant</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                     <td>${facs.quantite }</td>
                                    <td>${facs.designation }</td>
                                    <td>${facs.typeReglement }</td>
                                    <td>${facs.montantf }</td>
                                </tr>
                                 </tbody>
                        </table>
               <div align="right">
             <hr />
               <h5>  Montant Totale : ${facs.montantf } DT </h5>
             <hr />
        </div>     
     <br/>
     
     <table width="80%"><tr><td><h4 style="color:#086B7C">Le réceptionnaire</h4></td>
     
     <td><h4 style="color:#086B7C"> Le fournisseur</h4></td></tr></table>
     </div> 
  </div>


</body>
</html>
