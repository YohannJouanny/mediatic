// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleAdherent').controller('AdherentController', ['$http','$location', '$rootScope', 'AdherentService', function( $http, $location, $rootScope, AdherentService) {
	var myCtrl = this;

	$rootScope.title = "Recherche d\'un adherent";

	myCtrl.adherents = undefined;
	
	myCtrl.totalItems = undefined;
	myCtrl.currentPage = 0;
	myCtrl.maxSize = 5;
	
	
	AdherentService.getList({page:0}).then(function(response) {
		// En cas de succes
		myCtrl.adherents = response;
	}, function(){
		// En cas d'erreur
		myCtrl.adherents = -1;
	});
	
	myCtrl.hasErrorAdherents = function(){
		return ! (	myCtrl.adherents===undefined 
					|| ( _.isArray(myCtrl.adherents) 
							&& myCtrl.adherents.length>0
					)
				); 
	}
	
	
	myCtrl.recherche = function(){
		var recherche = {
			id : myCtrl.id,
			texte : myCtrl.NomEtPrenom,
			page : 0
		}
		

	AdherentService.getList(recherche).then(function(response){
			// En cas de succes
			myCtrl.adherents = response;
			myCtrl.initPagination();
			
		}, function(){
			// En cas d'erreur
			myCtrl.adherents = -1;
		})
	}
	
	
	
	myCtrl.initPagination = function(){
		// recuperation des nbrPage et le nombre d'item pour faire la pagination
		var urlTaille = "http://10.34.10.140:8080/resource/adherent.recherche.taille";
		
		var rech = {
			id : myCtrl.id,
			texte : myCtrl.NomEtPrenom
		}
		console.log(myCtrl.id);
		$http.get(urlTaille, {params:rech}).then(
			function(response){
			 // success callback
			 myCtrl.totalItems = response.data.items;
			 myCtrl.nbrPages = response.data.pages;
		   }, 
		   function(response){
			 // failure call back
			 alert('Mon serveur est HS !!!');
		   }
		);
	}
	
	myCtrl.initPagination();
	
	myCtrl.pagination = function(myPage){
		// creation de rech qui prend comme parametre les donnes de l'url id, text, page
		var rech = {
			id : myCtrl.id,
			texte : myCtrl.NomEtPrenom,
			page : myPage
		}
		AdherentService.getList(rech).then(function(response){
			// En cas de succes
			myCtrl.adherents = response;
		}, function(){
			// En cas d'erreur
			myCtrl.adherents = -1;
		})	
	}
	
	//lien click sur la ligne pour afficher la visu adherent
	myCtrl.showAdherent = function(adherent){
		$location.path("/visuAdherent/"+adherent.id);
	}
	
	
	
	
	
}]);




	