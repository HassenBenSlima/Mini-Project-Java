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


${facs.idVente }
${facs.typeReglement }
${facs.dateVente }
${facs.montantf }
${facs.designation }
<!--  -->
<div id="pdf2htmldiv">
<div>
 <div class="container" >
     
        <div class="row">
         <div class="col-lg-12 col-md-12 col-sm-12">
           <div class="table-responsive">
    
     <table class="table table-striped table-bordered table-hover">
	 <tr>        
       <td>
		     <img src="../resources/images/olive.png" style="padding-bottom:20px;"width="400px"  height="120px"/> 
        
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
    </div>
    </div>
    </div> 
     
	        <hr />
        
        <div class="row">
         <div class="col-lg-12 col-md-12 col-sm-12">
           <div class="table-responsive">
     
             <table width="100%" class="table table-striped table-bordered table-hover" >
             <tr>
             <td>
			 
                 <strong id="testdiv" >Email : </strong>  MoulinOlive@Tunisie.com 
             </td>
			 <td>
               <strong>Call : </strong>  +216 -xx- xxx-xxx 
             <br>
              
                 <strong>Fax : </strong>  +2016-xxx- xxx 
             
			 </td>
			 <tr>
			 </table>
             </div>
             </div>
             </div>
             <hr/>
         
     
    <div class="row">
         <div class="col-lg-12 col-md-12 col-sm-12">
           <div class="table-responsive">
       
           <table width="100%" class="table table-striped table-bordered table-hover" >
		 <tr>
		 <td >
		 
         <h4>  Client Information</h4>
           <strong>  Jhon Deo Chuixae</strong>
             <br />
                  <b>Address :</b> 145/908 , New York Lane,
              <br />
                 United States.
             <br />
             <b>Call :</b> +90-908-567-0987
              <br />
             <b>E-mail :</b> info@clientdomain.com
		 </td>
		 
		 <td>
            
               <h4>  <strong>Payment Details </strong></h4>
            <b>Bill Amount :  990 USD </b>
              <br />
               Bill Date :  01th August 2014
              <br />
               <b>Payment Status :  Paid </b>
               <br />
               Delivery Date :  10th August 2014
              <br />
               Purchase Date :  30th July 2014
         
		 </td>
		</tr>
		 </table>
     </div>
	</div>
	</div> 
	 
	 
	 
     <div class="row">
         <div class="col-lg-12 col-md-12 col-sm-12">
           <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>S. No.</th>
                                    <th>Perticulars</th>
                                    <th>Quantity.</th>
                                    <th>Unit Price</th>
                                     <th>Sub Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>${facs.designation }</td>
                                    <td>1</td>
                                    <td>300 USD</td>
                                    <td>300 USD</td>
                                </tr>
                                 </tbody>
                        </table>
               </div>
             <hr />
             <div class="ttl-amts">
               <h5>  Total Amount : 900 USD </h5>
             </div>
             <hr />
              <div class="ttl-amts">
                  <h5>  Tax : 90 USD ( by 10 % on bill ) </h5>
             </div>
             <hr />
              <div class="ttl-amts">
                  <h4> <strong>Bill Amount : 990 USD</strong> </h4>
             </div>
         </div>
     </div>
      <div class="row">
         <div class="col-lg-12 col-md-12 col-sm-12">
            <strong> Important: </strong>
             <ol>
                  <li>
                    This is an electronic generated invoice so doesn't require any signature.

                 </li>
                 <li>
                     Please read all terms and polices on  www.yourdomaon.com for returns, replacement and other issues.

                 </li>
             </ol>
			 
	</div>
			 	
             <hr />
             <a class="btn btn-info" onclick="javascript:window.print();"  >Imprimer</a>
             &nbsp;&nbsp;&nbsp;
              <a href="javascript:pdfToHTML()" class="btn btn-success btn-lg" >Telecharger Pdf</a>
              
             </div>
        
		 
             
			 
		
			 
         </div>
      
 </div>
</div>


</body>
</html>
