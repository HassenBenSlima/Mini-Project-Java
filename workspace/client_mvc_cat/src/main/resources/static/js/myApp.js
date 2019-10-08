var myApp=angular.module('myApp',['ui.router']);


myApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	
	$stateProvider
			.state('home', {
				url: "/home",
				templateUrl: "index.html",
					controller:"IndexController"
								
			})
			.state('list', {
				url: "/listEtudiants",
				templateUrl: "views/listes.html",
				controller: "ListEtudiantController"
			})
			.state('listClient', {
				url: "/listClients",
				templateUrl: "views/listeClients.html",
				controller: "ListClientsController"
			});
			
			}]);













myApp.controller("ListClientsController", function($scope,$http) {
	$scope.pageClients=null;
	$scope.pageCourante=0;
	$scope.size=5;
	$scope.motCle="";	
	$scope.pages=[];
	
	$scope.listClients=function(){
		$http.get("/clients?page="+$scope.pageCourante+"&size="+$scope.size
				+"&motCle="+$scope.motCle)
		 .success(function(data){
			$scope.pageClients=data; 
			$scope.pages=new Array(data.totalPages);

		})
			.error(function(err){
				Console.log(err);
			});
	};
	
	
	$scope.gotoPage=function(p){
		$scope.pageCourante=p;		
		$scope.listClients();

		}
	
});





/*scope c'est un model*/
myApp.controller("ListEtudiantController", function($scope,$http) {
	$scope.pageEtudiants=null;
	$scope.pageCourante=0;
	$scope.size=5;
	$scope.motCle="";	
	$scope.pages=[];
	
	$scope.listEtudiants=function(){
		$http.get("/etudiants?page="+$scope.pageCourante+"&size="+$scope.size
				+"&motCle="+$scope.motCle)
		 .success(function(data){
			$scope.pageEtudiants=data; 
			$scope.pages=new Array(data.totalPages);

		})
			.error(function(err){
				Console.log(err);
			});
	};
	
	
	$scope.gotoPage=function(p){
		$scope.pageCourante=p;		
		$scope.listEtudiants();

		}
	
		
	//$scope.listEtudiants();
	
});

myApp.controller("InscriptionController",function($scope,$http){
	$scope.etudiant={};
	$scope.errors=null;
	$scope.mode={value:"form"}
	$scope.exception={message:null}
	
	$scope.saveEtudiant=function(){
		$http.post("/etudiants",$scope.etudiant)
		.success(function(data){
			if(!data.errors){
			$scope.etudiant=data;
			$scope.errors=null;
			$scope.mode.value="confirm";
			}else{
				$scope.errors=data;
				
			}
			
			}).error(function(data) {
				$scope.exception.message=data.message;
			});
	};
	
});




myApp.controller("IndexController", function($scope,$http) {
	$scope.menu=["Inscription","Listes","Utilisateurs","Logout"];
	
	$scope.selectedMenu=null;
	
	$scope.select=function(m){
		$scope.selectedMenu=m;
	}
	
});






