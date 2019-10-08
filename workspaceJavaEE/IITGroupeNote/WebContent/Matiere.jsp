<%@ include file="head.jsp" %>

		<c:if test="${matiere!=null }">
		
		<script type="text/javascript">
			$( document ).ready(function() {
			    $('#myModal').modal('toggle')
			});
		</script>

		</c:if>
        <section class="content-header">
          <h1>
            Gestion matiére
            <small>Aperçu</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
            <li class="active">Gestion des matiéres</li>
          </ol>
        </section>
    
     
     
     
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
             
     

              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">La liste des matiéres</h3>
                  <div class="pull-right">
                    <a href="javascript:history.back()" class="btn btn-default btn-xs"data-toggle="tooltip" data-placement="top" title="Retour" ><span class="glyphicon glyphicon-circle-arrow-left"></span> Retour</a>
                   
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg">
                      Ajouter un  matiére &nbsp;&nbsp;<i class="fa fa-book" aria-hidden="true"></i> 
                    </button>
                  </div>
       
  
                </div><!-- /.box-header -->
                <div class="box-body">       
                  <table id="matiere" class="table table-bordered table-striped table-hover ">
                    <thead>
                      <tr>
                        <th class="col-md-1">#</th>
                        <th>libelle</th>
                        <th>Volume Coure</th>
                        <th>Volume TD</th>
                        <th>Volume TP </th>
                        <th>Coefficient</th>
                        <th>Credit</th>
                        <th class="col-md-1">Action</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th class="col-md-1">#</th>
                        <th>libelle</th>
                        <th>Volume Coure</th>
                        <th>Volume TD</th>
                        <th>Volume TP</th>
                        <th>Coefficient</th>
                        <th>Credit</th>
                        <th class="col-md-1">Action</th>
                      </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${matieres}" var="m">
						<tr>
								<td>${m.code}</td>
								<td>${m.libelle}</td>
								<td>${m.volumeC}</td>
								<td>${m.volumeTd}</td>
								<td>${m.volumeTp}</td>
								<td>${m.coefficient}</td>
								<td>${m.credit}</td>
								<td class="col-md-1">	
									<a href="javascript:modifier('${m.code}')"  class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="Modifier cette matiére"></i></a>
									<a href="MatiereController?action=supp&id=${ens.code}" data-confirm="Etes-vous certain de vouloir supprimer?" class="btn btn-danger btn-xs"><i class="fa fa-trash-o" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="Supprimer cette matiére"></i></a>
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

           <c:if test="${matiere==null }">
           <i class="fa fa-book" aria-hidden="true"></i>&nbsp;&nbsp;Ajouter Matiére 
			
			
			</c:if>

			<c:if test="${matiere!=null }">
			
			
			<i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modifier Matiére 
			
			
			</c:if>
         
         
         </h4>    
       </div>
       <div class="modal-body">
       

















			<form  class="form-horizontal" action="MatiereController" method="post" >
            
			 
			  <div class="form-group ">
			    <label class="col-sm-4 control-label" > Libelle </label>
			    <div class="col-sm-6">		
			      <input name="libelle" value="${matiere.libelle}"  class="form-control" type="text"  placeholder="Libelle " required>
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" > Volume Coure </label>
			    <div class="col-sm-6">		
			      <input name="volumeC" value="${matiere.volumeC}"  class="form-control" type="text"  placeholder="Volume Coure" required>
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" > Volume TD </label>
			    <div class="col-sm-6">		
			      <input name="volumeTd" value="${matiere.volumeTd}" class="form-control" type="text"  placeholder="Volume TD" required>
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" > Volume TP </label>
			    <div class="col-sm-6">		
			      <input name="volumeTp" value="${matiere.volumeTp}" class="form-control" type="text"  placeholder="Volume TP" required>
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Coefficient</label>
			    <div class="col-sm-6">		
			      <input name="coefficient" value="${matiere.coefficient}" class="form-control" type="text"  placeholder="Coefficient" required>
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>

			  <div class="form-group ">
			    <label class="col-sm-4 control-label" >Credit</label>
			    <div class="col-sm-6">		
			      <input  name="credit" value="${matiere.credit}" class="form-control" type="text"  placeholder="Credit" required>
			      <div class="help-block with-errors"></div>
			    </div>
			  </div>

		       <div class="modal-footer">
		         <button type="reset" class="btn btn-danger  pull-left" data-dismiss="modal">
		         	<span class="glyphicon glyphicon-remove "></span>Annuler
		         </button>
		        

		            <c:if test="${matiere ==null }">
					<button type="submit" name="action" value="Enregistrer" class="btn btn-primary">
					<i class="fa fa-floppy-o" aria-hidden="true"></i>
					Enregistrer
					</button>
					
					</c:if>

					<c:if test="${matiere !=null }">
					
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
</div>

<script type="text/javascript" language="javascript">

       var table = $('#matiere').DataTable( {
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
	
		document.location="MatiereController?action=edit&cod="+id;
	
	
	
}
</script>





        
<%@ include file="body.html" %>