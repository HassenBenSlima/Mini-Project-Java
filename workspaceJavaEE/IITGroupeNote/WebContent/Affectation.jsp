<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<c:if test="${groupeEnEdit!=null }">

<script type="text/javascript">
$( document ).ready(function() {
	$('#myModal').modal('toggle')
});
</script>

</c:if>
<section class="content-header">
	<h1>
		Gestion D'affectation de ${groupe.niveau.nom} ${groupe.abreviation}
		<small>Aperçu</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Accueil</a></li>
		<li><a href="GroupeEnseignantController">Gestion D'affectation</a></li>
		<li class="active">${groupe.niveau.nom} ${groupe.nom}</li>
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
                    <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-lg">
                      Ajouter une affectation &nbsp;&nbsp;<i class="fa fa-plus-square-o fa-lg"   data-toggle="tooltip" data-placement="top" title="Affecter une matières et enseignant"></i>
                    </button>

                    <button class="btn btn-default btn-sm" data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button>
                    

                  </div><!-- /. tools -->
                </div><!-- /.box-header class="form-inline" -->
                <div class="box-body pad">
                  <div>
                    <center>
                    <table>
                  <form class="form-inline" action="GroupeEnseignantController" method="post">
                    
                      <tr>
                        <th>
                
                      <input name="rperiode" type="text" class="form-control" id="exampleInputName2" placeholder="Période">
              
              </th><th>    &nbsp;&nbsp;</th><th>
                   
                      <input name="rannee" type="number" min="2000" class="form-control" id="exampleInputEmail2" placeholder="Année" maxlength="4" >
                   
                  </th><th>&nbsp;&nbsp;
                    <button type="submit" name="action" value="Recherche" class="btn btn-default"><i class="fa fa-search fa-lg" aria-hidden="true"></i>Recherche</button>
                  </th>
                  
                  </form>
                  </table>
                  </center>
                   </div>
                   
                   



                </div>
              </div>

<c:forEach items="${groupe.groupeenseignants}" var="gEns">


        <div class="col-md-6">
          <div class="box box-primary">
				<div class="box-header">
          <h3 class="box-title"><i class="fa fa-file-text" aria-hidden="true"></i>&nbsp; ${gEns.matiere.libelle}</h3>

          <div class="pull-right box-tools">
           <a href="GroupeEnseignantController?action=edit&cod=${gEns.id}"  class="btn btn-primary btn-sm"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="Modifier cette affectation"></i></a>
           <a href="GroupeEnseignantController?action=supp&id=${gEns.id}"    class="btn btn-danger btn-sm" data-confirm="Etes-vous certain de vouloir supprimer?" ><i class="fa fa-trash-o fa-lg" aria-hidden="true" data-toggle="tooltip" data-placement="top" title="Supprimer cette affectation"></i></a>
          
					 <button class="btn btn-default btn-sm"  data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button>
					</div>
				</div><!-- /.box-header -->
			<div class="box-body pad">


                    <div class="row">
                          <div class="col-md-12">
                          <div class="col-md-7">

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
                                  <span class="product-description">
                                   Adrésse : ${gEns.enseignant.adresse}
                                  </span>  
                                  <span class="product-description">                                 
                                   Matricule fiscal : ${gEns.enseignant.matriculefiscal}
                                  </span>                                  
                                </div>
                              </li><!-- /.item -->
                            </ul>

                          </div><!-- /.col -->
                          <div class="col-md-5">
                             <canvas class="pull-right"  id="pieChart${gEns.id}" style="height:220px"></canvas>
                             
                              
                        
                     

                          </div><!-- /.col -->
                        </div><!-- /.row -->
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



                <div class="box-footer no-padding">
                  <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">Volume Coure  <span class="pull-right text-red">     ${gEns.matiere.volumeC }H</span></a></li>
                    <li><a href="#">Volume TD <span class="pull-right text-green">    ${gEns.matiere.volumeTd }H</span></a></li>
                    <li><a href="#">Volume TP <span class="pull-right text-yellow">  ${gEns.matiere.volumeTp }H</span></a></li>
                  </ul>
                </div>
                
			</div><!-- /.col -->
		   </div><!-- /.row -->
		</div>

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
						  <option>  </option>
							<c:forEach items="${enseignants}" var="ens">
							   <c:if test="${groupeEnEdit.enseignant.code == ens.code}">
							   <option value="${ens.code}" selected> ${ens.prenom} ${ens.nom}</option>
						       </c:if>

						       <c:if test="${groupeEnEdit.enseignant.code != ens.code}">
						       <option value="${ens.code}" > ${ens.prenom} ${ens.nom}</option>
					           </c:if>
			            	</c:forEach>
		     	        </select>
		            </div>
                </div>

                <div class="form-group ">
					<label class="col-sm-4 control-label" >Matiere</label>
					<div class="col-sm-6">

						<select name="matiere" class="form-control select2" style="width: 100%;">
							<option>  </option>
							<c:forEach items="${matieres}" var="mt">
							   <c:if test="${groupeEnEdit.matiere.code == mt.code}">
							   <option value="${mt.code}" selected>  ${mt.libelle}</option>
						       </c:if>

						       <c:if test="${groupeEnEdit.matiere.code != mt.code}">
						       <option value="${mt.code}" > ${mt.libelle}</option>
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

