<%@ include file="head.jsp" %>

		<c:if test="${enseignant!=null }">
		
		<script type="text/javascript">
			$( document ).ready(function() {
			    $('#myModal').modal('toggle')
			});
		</script>

		</c:if>
        <section class="content-header">
          <h1>
            Gestion enseignant
            <small>Aperçu</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
            <li class="active">Gestion enseignant</li>
          </ol>
        </section>
      
     
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
             
     

              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">La liste des enseignants</h3>
                  <div class="pull-right">
                    <a href="javascript:history.back()" class="btn btn-default btn-xs"data-toggle="tooltip" data-placement="top" title="Retour" ><span class="glyphicon glyphicon-circle-arrow-left"></span> Retour</a>
                   
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg">
                      Ajouter un  enseignant &nbsp;&nbsp;<i class="fa fa-user-plus   fa-lg"></i> 
                    </button>
                  </div>
       
  
                </div><!-- /.box-header -->
                <div class="box-body">       
                  <table id="etudiant" class="table table-bordered table-striped table-hover ">
                    <thead>
                      <tr>
                        <th class="col-md-1">#</th>
                        <th>Cin</th>
                        <th>Prénom</th>
                        <th>Nom</th>
                        <th>N°inscription</th>   
                        <th>email</th>
                        <th>téléphone</th>
                        <th class="col-md-1">Action</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th class="col-md-1">#</th>
                        <th>Cin</th>
                        <th>Prénom</th>
                        <th>Nom</th>
                        <th>Matricule Fiscal</th>
                        <th>email</th>
                        <th>téléphone</th>
                        <th class="col-md-1">Action</th>
                      </tr>
                    </tfoot>
                    <tbody>
                    	<c:forEach items="${enseignants}" var="ens">
							<tr>
								<td>${ens.code}</td>
								<td>${ens.cin}</td>
								<td>${ens.prenom}</td>
								<td>${ens.nom}</td>
								<td>${ens.matriculefiscal}</td>
								<td>${ens.email}</td>
								<td>${ens.tel}</td>
							<td class="col-md-1">	
								<a href="javascript:modifier('${ens.code}')"  class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="Modifier cette enseignant"></i></a>
								<a href="EnseignantController?action=supp&id=${ens.code}" data-confirm="Etes-vous certain de vouloir supprimer?" class="btn btn-danger btn-xs"><i class="fa fa-trash-o" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="Supprimer cette enseignant"></i></a>
							</td>
							</tr>
						</c:forEach>

                    </tbody>
                  </table>


            </div><!-- /.col -->
          </div><!-- /.row -->
        </section><!-- /.content -->

   


<div id="myModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">

  <div class="modal-dialog modal-lg">
    <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
         <h4 class="modal-title">

           <c:if test="${enseignant==null }">
           <i class="fa fa-user-plus   fa-lg"></i>&nbsp;&nbsp;Ajouter Enseignant 
		   </c:if>

			<c:if test="${enseignant!=null }">
			<i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modifier Enseignant 
			</c:if>
         
         
         </h4>    
       </div>
       <div class="modal-body">
       
















			<form  class="form-horizontal" action="EnseignantController" method="post" >
            
			 
			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Numéro CIN</label>
			    <div class="col-sm-6">		
			      <input name="cin" value="${enseignant.cin}" class="form-control" type="text" pattern="[0-9]{8}"   placeholder="Numéro CIN" required>
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Nom</label>
			    <div class="col-sm-6">

			      <input name="nom" value="${enseignant.nom}" class="form-control" type="text"  placeholder="Nom" required>
			    <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label"for="inputPassword3" >Prénom</label>
			    <div class="col-sm-6">		
			      <input  name="prenom" value="${enseignant.prenom}" id="inputPassword3" class="form-control" type="text"  placeholder="Prénom" required>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >EMail</label>
			    <div class="col-sm-6">
			      <input name="email" value="${enseignant.email}" class="form-control" type="email"  placeholder="EMail" required>
			    <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Adrésse</label>
			    <div class="col-sm-6">			
			      <input name="adresse" value="${enseignant.adresse}" class="form-control" type="text"  placeholder="Adrésse" >
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Matricule fiscal</label>
			    <div class="col-sm-6">

			      <input name="matriculefiscal" value="${enseignant.matriculefiscal}" class="form-control" type="text"  placeholder="Numéro d'inscription" data-error="Numéro d'inscription et obligatoare" required>
			     <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Téléphone</label>
			    <div class="col-sm-6">
			      <input name="tel" value="${enseignant.tel}" class="form-control" type="tel"  placeholder="Téléphone">
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>
			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Responsableb</label>
			    <div class="col-sm-6">
			      <label class="checkbox-inline" for="checkboxes-0">
                  <input type="checkbox" name="responsableb" id="checkboxes-0" value="resp"  <c:if test="${enseignant.responsableb==1}" > <c:out value="checked"></c:out> </c:if>>
                  </label>
			    </div>
			  </div>
  
       </div>
       <div class="modal-footer">
         <button type="reset" class="btn btn-danger  pull-left" data-dismiss="modal">
         	<span class="glyphicon glyphicon-remove "></span>Annuler
         </button>
        

            <c:if test="${enseignant ==null }">
			<button type="submit" name="action" value="Enregistrer" class="btn btn-primary">
			<i class="fa fa-floppy-o" aria-hidden="true"></i>
			Enregistrer
			</button>
			
			</c:if>

			<c:if test="${enseignant !=null }">
			
			<button type="submit" name="action" value="Modifier" class="btn btn-primary">
			<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
			Modifier
			</button>
			
			</c:if>
       </div>

</form>

    </div>
  </div>
</div>


<script type="text/javascript" language="javascript">

       var table = $('#etudiant').DataTable( {
    "order": [[ 0, "desc" ]],
    //"scrollX": false,
    "language": 
    {
    "sProcessing":     "Traitement en cours...",
    "sSearch":         "Rechercher&nbsp;:",
    "sLengthMenu":     "Afficher _MENU_ &eacute;l&eacute;ments",
    "sInfo":           "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
    "sInfoEmpty":      "Affichage de l'&eacute;lement 0 &agrave; 0 sur 0 &eacute;l&eacute;ments",
    "sInfoFiltered":   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
    "sInfoPostFix":    "",
    "sLoadingRecords": "Chargement en cours...",
    "sZeroRecords":    "Aucun &eacute;l&eacute;ment &agrave; afficher",
    "sEmptyTable":     "Aucune donn&eacute;e disponible dans le tableau",
    "oPaginate": {
        "sFirst":      "Premier",
        "sPrevious":   "Pr&eacute;c&eacute;dent",
        "sNext":       "Suivant",
        "sLast":       "Dernier" },
    "oAria": {
        "sSortAscending":  ": activer pour trier la colonne par ordre croissant",
        "sSortDescending": ": activer pour trier la colonne par ordre d&eacute;croissant" }
     },
       
    } );


</script>

<script type="text/javascript">


$(function() {
	$('a[data-confirm]').click(function(ev) {
		var href = $(this).attr('href');
		
		if (!$('#dataConfirmModal').length) {
			$('body').append('<div id="dataConfirmModal" class="modal" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h3 id="dataConfirmLabel">Merci de confirmer</h3></div><div class="modal-body"></div><div class="modal-footer"><button class="btn" data-dismiss="modal" aria-hidden="true">Non</button><a class="btn btn-danger" id="dataConfirmOK">Oui</a></div></div></div></div>');
		}
		$('#dataConfirmModal').find('.modal-body').text($(this).attr('data-confirm'));
		$('#dataConfirmOK').attr('href', href);
		$('#dataConfirmModal').modal({show:true});
		
		return false;
	});
});


function modifier(id){
	
		document.location="EnseignantController?action=edit&cod="+id;
	
	
	
}
</script>





        
<%@ include file="body.html" %>