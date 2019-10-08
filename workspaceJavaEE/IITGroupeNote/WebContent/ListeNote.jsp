<%@ include file="head.jsp" %>





<section class="content-header">
	<h1>
		Affichage des Notes 
		<small>Aperçu</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
		<li class="active">Affichage des Notes </li>
	</ol>
</section>

<section class="content">
	<div class="row">
		<div class="col-md-12">

              <div class="box">
                <div class="box-header">
                <h3 class="box-title"><i class="fa fa-search fa-lg" aria-hidden="true"></i>&nbsp;Filtrage </h3>
                  <!-- tools box -->
                  <div class="pull-right box-tools">


                    <button class="btn btn-default btn-sm" data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button>
                    

                  </div><!-- /. tools -->
                </div><!-- /.box-header class="form-inline" -->
                <div class="box-body pad">
                <center>
                <div>
                     <form class="form-inline" action="NoteController" method="post">
			
			    	
			    	<select name="codeGroupe" class="form-control Groupe " style="width: 30%;">
			    	 <option disabled selected>Groupe</option>
	                  	<c:forEach items="${sGroups}" var="g">
					
						<option value="${g.code}" >${g.nom} ${g.niveau.nom}</option>
						
						</c:forEach>
                    </select>
			     
			   
                      <input name="rperiode" type="text" class="form-control" id="exampleInputName2" placeholder="Période">
                      <input name="rannee" type="number" min="2000" class="form-control" id="exampleInputEmail2" placeholder="Année" maxlength="4" >
                    <button type="submit" name="action" value="Recherche" class="btn btn-default"><i class="fa fa-search fa-lg" aria-hidden="true"></i>Recherche</button>

                  </form>
                   </div>
                   </center>



                </div>
              </div>

<c:forEach items="${groups}" var="groupe">

     <div class="col-md-6">
          <div class="box box-primary">
		  <div class="box-header">
          <h3 class="box-title">${groupe.niveau.nom}  ${groupe.nom}  </h3>
         <div class="pull-right box-tools">
			<button class="btn btn-default btn-sm"  data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button>
		 </div>
	    </div>
<div class="box-body pad">
<c:forEach items="${groupe.groupeenseignants}" var="gEns">


			

       
       <div>         
       <label> <i class="fa fa-file-text" aria-hidden="true"></i>&nbsp; ${gEns.matiere.libelle}</label>
         <button type="button" class="btn btn-default btn-xs pull-right"  data-toggle="modal" data-target="#myModal${gEns.id}">
             <span class="glyphicon glyphicon-search"></span> Voir la lise des notes 
         </button> 
      </div>
            





                <div class="box-footer">
                  <div class="row">
                    <div class="col-sm-4 border-right">
                      <div class="description-block">
                        <h5 class="description-header">${gEns.annee}</h5>
                        <span class="description-text">ANNÉE</span>
                      </div><!-- /.description-block -->
                    </div><!-- /.col -->
                    <div class="col-sm-4 border-right">
                      <div class="description-block">
                        <h5 class="description-header">${gEns.dateAffectation}</h5>
                        <span class="description-text">DATE AFFECTATION</span>
                      </div><!-- /.description-block -->
                    </div><!-- /.col -->
                    <div class="col-sm-4 border-right">
                      <div class="description-block">
                        <h5 class="description-header">${gEns.semestre}</h5>
                        <span class="description-text">PÉRIODE</span>
                      </div><!-- /.description-block -->
                    </div><!-- /.col -->
                  </div><!-- /.row -->
                </div>

                        <div class="row">
                          <div class="col-md-12 ">
                      
                  
                          <div class="col-md-8">

                            <ul class="products-list product-list-in-box">
                              <li class="item">
                                <div class="product-img">
                                  <img src="logo/enseignant.png" alt="Product Image">               
                                </div>
                                <div class="product-info">
                                 <a href="javascript::;" class="product-title">${gEns.enseignant.prenom} ${gEns.enseignant.nom} </a>
                                  
                                  <span class="product-description">
                                   EMail: ${gEns.enseignant.email}
                                  </span>
                                  
                                   <span class="product-description">
                                   Téléphone: ${gEns.enseignant.tel}
                                   </span>
                                
                                                              
                                </div>
                              </li><!-- /.item -->
                            </ul>

                          </div><!-- /.col -->
                          <div class="col-md-4">
                             <canvas class="pull-right"  id="pieChart${gEns.id}" style="height:190px"></canvas>
                              <script type="text/javascript">
						        var pieChartCanvas = $("#pieChart${gEns.id}").get(0).getContext("2d");
						        var pieChart = new Chart(pieChartCanvas);
						        var PieData = [
						          {
						            value: ${gEns.matiere.volumeC},
						            color: "#f56954",
						            highlight: "#f56954",
						            label: "Volume Coure"
						          },
						          {
						            value: ${gEns.matiere.volumeTd},
						            color: "#00a65a",
						            highlight: "#00a65a",
						            label: "Volume TD"
						          },
						          {
						            value: ${gEns.matiere.volumeTp},
						            color: "#f39c12",
						            highlight: "#f39c12",
						            label: "Volume TP"
						          }
						        ];
						        var pieOptions = {
						          segmentShowStroke: true,
						          segmentStrokeColor: "#fff",
						          segmentStrokeWidth: 2,
						          percentageInnerCutout: 50, 
						          animationSteps: 100,
						          animationEasing: "easeOutBounce",
						          animateRotate: true,
						          animateScale: false,
						          responsive: true,
						          maintainAspectRatio: true,
						           };
						        pieChart.Doughnut(PieData, pieOptions);
						
						    </script>
                              
                        
                     

                          </div><!-- /.col -->
                        </div><!-- /.row -->
                         </div>

<!--///////////////////////////////////////////////////////////////-->
                      <div class="modal fade  bs-example-modal-lg" id="myModal${gEns.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel${gEns.id}">
                        <div class="modal-dialog" role="document">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="myModalLabel${gEns.id}"><i class="fa fa-list-ul" aria-hidden="true"></i>&nbsp;Lite des notes ${gEns.matiere.libelle} </h4>
                            </div>

                            <div class="modal-body">

                           
                                <table id="note${gEns.matiere.code}${groupe.code}${gEns.id}" class="table table-bordered table-striped table-hover ">
                                	<thead >
                                	  <tr>
                                        <th>Prénom&nbsp;Nom</th>
                                        <th>Note Présentielle</th>
                                        <th>Note TP</th>
                                        <th>Note DS</th>
                                        <th>Note Examen</th>
                                      </tr>
                                	</thead>
                                	<tfoot>
                                	  <tr>
                                        <th>Prénom&nbsp;Nom</th>
                                        <th>Note Présentielle</th>
                                        <th>Note TP</th>
                                        <th>Note DS</th>
                                        <th>Note Examen</th>
                                      </tr>
                                	</tfoot>
                                	<tbody>
		                              <c:forEach items="${gEns.matiere.notes}" var="note">
		                              <c:forEach items="${groupe.etudiants}" var="et">
		                                <c:if test="${et.code ==note.etudiant.code }">
		                                <tr>
		                                	<td>
		                                  ${note.etudiant.prenom}&nbsp;${note.etudiant.nom}
		                                 </td>
		                                 <td>
		                                   <span class="label label-default">${note.notepresentielle}</span>
		                                </td>
		                                 <td>
		                                   <span class="label label-default">${note.notetp}</span>
		                                   </td>
		                                 <td>
		                                   <span class="label label-default">${note.noteds}</span>
		                                   </td>
		                                 <td>
		                                   <span class="label label-default">${note.noteexam}</span>
		                                   </td>
		                                 
		                                 </tr>
		                                </c:if>  
		                              </c:forEach>  
		                              </c:forEach> 
                                	</tbody>
                                </table>
                                
<script type="text/javascript" language="javascript">

       var table = $('#note${gEns.matiere.code}${groupe.code}${gEns.id}').DataTable( {
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
                                 
                                  
                                
                                  
                                  
                                  
                                
                                  
                                  
                                
                              

                               
                                 
                                   
                                  
                               
                          

                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                        </div>
                      </div>
                    </div>
                  </div>



<!--///////////////////////////////////////////////////////////////-->
            
                


<hr>
</c:forEach>
			</div>
		   </div>
		</div>
</c:forEach>
             

		</div>
    </div>
</section><!-- /.content -->

















	<div id="myModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">

		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">
						

				<c:if test="${groupeEnEdit==null }">
				<i class="fa fa-plus-square-o" aria-hidden="true"></i> Ajouter une affectation
				</c:if>

				<c:if test="${groupeEnEdit!=null }">
				<i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modifier une affectation
				</c:if>


			</h4>    
		</div>

		<div class="modal-body">

			<form  class="form-horizontal" action="GroupeEnseignantController" method="post" >


  



                <div class="form-group ">
					<label class="col-sm-4 control-label" >Enseignant</label>
					<div class="col-sm-6">

						<select name="enseignant" class="form-control select2" style="width: 100%;">
							<option value="0" ></option>
							<c:forEach items="${enseignants}" var="ens">
							   <c:if test="${groupeEnEdit.enseignant.code == ens.code}">
							   <option value="${ens.code}" selected><span class="label label-default">${ens.code}</span> ${ens.prenom} ${ens.nom}</option>
						       </c:if>

						       <c:if test="${groupeEnEdit.enseignant.code != ens.code}">
						       <option value="${ens.code}" ><span class="label label-default">${ens.code}</span> ${ens.prenom} ${ens.nom}</option>
					           </c:if>
			            	</c:forEach>
		     	        </select>
		            </div>
                </div>

                <div class="form-group ">
					<label class="col-sm-4 control-label" >Matiere</label>
					<div class="col-sm-6">

						<select name="matiere" class="form-control select2" style="width: 100%;">
							<option value="0" ></option>
							<c:forEach items="${matieres}" var="mt">
							   <c:if test="${groupeEnEdit.matiere.code == mt.code}">
							   <option value="${mt.code}" selected><span class="label label-default">${mt.code}</span>  ${mt.libelle}</option>
						       </c:if>

						       <c:if test="${groupeEnEdit.matiere.code != mt.code}">
						       <option value="${mt.code}" ><span class="label label-default">${mt.code}</span>  ${mt.libelle}</option>
					           </c:if>
			            	</c:forEach>
		     	        </select>
		            </div>
                </div>


                





             	<div class="form-group ">
					<label class="col-sm-4 control-label" >Semestre</label>
					<div class="col-sm-6">		
						<input name="semestre" value="${groupeEnEdit.semestre}" class="form-control" type="text"   placeholder="EX :Semestre 1" required> 
					</div>
				</div>

                
          </div>

				<div class="modal-footer">
					<button type="reset" class="btn btn-danger  pull-left" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove "></span>Annuler
					</button>


					<c:if test="${groupeEnEdit ==null }">
					<button type="submit" name="action" value="Enregistrer" class="btn btn-primary">
						<i class="fa fa-floppy-o" aria-hidden="true"></i>
						Enregistrer
					</button>
				</c:if>

				<c:if test="${groupeEnEdit !=null }">
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




</script>        



<%@ include file="body.html" %>

