

<%@ include file="head.jsp" %>

<c:if test="${groupe!=null }">

<script type="text/javascript">
$( document ).ready(function() {
	$('#myModal').modal('toggle')
});
</script>

</c:if>
<section class="content-header">
	<h1>
		Gestion D'affectation 
		<small>Aperçu</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
		<li class="active">Gestion D'affectation</li>
	</ol>
</section>


<section class="content">
	<div class="row">
		<div class="col-xs-12">



			<div class="box">
				<div class="box-header">
					<h3 class="box-title">La liste des Groupes</h3>
					<div class="pull-right">
						<a href="javascript:history.back()" class="btn btn-default btn-xs"data-toggle="tooltip" data-placement="top" title="Retour" ><span class="glyphicon glyphicon-circle-arrow-left"></span> Retour</a>

					
					</div>
				</div><!-- /.box-header -->



				<div class="box-body">       
					<table id="groups" class="table table-bordered table-striped table-hover ">
						<thead>
							<tr>
								<th class="col-md-1">#</th>
									<th>Niveau</th>
									<th>Libellé</th>
									<th>Abréviation</th>
									<th>Nombre d'étudiants</th>
								<th class="col-md-1">Action</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th class="col-md-1">#</th>
									<th>Niveau</th>
									<th>Libellé</th>
									<th>Abréviation</th>
									<th>Nombre d'étudiants</th>
								<th class="col-md-1">Action</th>
							</tr>
						</tfoot>
						<tbody>  
							<c:forEach items="${groups}" var="g">
								<tr>
									<td>${g.code}</td>
									<td>${g.niveau.nom}</td>
									<td>${g.nom}</td>
									<td>${g.abreviation}  </td>
									<td align="right"><span class="label label-default">${g.nbEtudiant}</span></td>
									<td class="col-md-1">	
									   	<a href="GroupeEnseignantController?action=aff&id=${g.code}"  class="btn btn-primary btn-xs"><i class="fa fa-plus-square-o fa-lg"   data-toggle="tooltip" data-placement="top" title="Affecter les matières et les enseignants"></i></a>
									</td>
								</tr>
							</c:forEach>	
					    </tbody>
				</table>


			</div><!-- /.col -->
		</div><!-- /.row -->
	</section><!-- /.content -->
			</div>
		</div>




<script type="text/javascript" language="javascript">

var table = $('#groups').DataTable( {
	"order": [[ 0, "desc" ]],
    
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

<%@ include file="body.html" %>


