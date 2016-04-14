// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleAdherent').controller('VisuAdherentController', ['$http','$routeParams','$location', '$rootScope', 'AdherentService', function( $http, $routeParams, $location, $rootScope, AdherentService) {
	var myCtrl = this;

	$rootScope.title = "Visualisation d\'un adherent";
	myCtrl.adherent = undefined;
	
	var url = "http://10.34.10.140:8080/resource/adherent.accession?id="+$routeParams.adherentId;
	

	var initAdherent = function(response){
		
		var itemFromServeur = response.data
		var itemForIHM = {
			id:itemFromServeur.id,
			nom:itemFromServeur.nom,
			prenom:itemFromServeur.prenom,
			date_naissance: new Date(itemFromServeur.date_naissance),
			cotisation_correcte:itemFromServeur.cotisation_correcte,
			email:itemFromServeur.email,
			adresse:{},
			age:itemFromServeur.age,
			emprunt:[],
			cotisation:{},
			nombre_media:itemFromServeur.nombre_media,			
		};
		
		
		for (index in itemFromServeur.emprunt){
			itemForIHM.emprunt.push(
				{media:
					{
						id: itemFromServeur.emprunt[index].media.id,
						titre: itemFromServeur.emprunt[index].media.titre
					},
						depart: itemFromServeur.emprunt[index].depart,
						retour: itemFromServeur.emprunt[index].retour
				}
			)
		} 
				
		if(itemFromServeur.adresse != undefined){
			itemForIHM.adresse = {
				ligne1: itemFromServeur.adresse.ligne1,
				ligne2: itemFromServeur.adresse.ligne2,
				codepostal: itemFromServeur.adresse.codepostal,
				ville: itemFromServeur.adresse.ville	
			};
		}
				
		if(itemFromServeur.cotisation != undefined){
			itemForIHM.cotisation = {
				debut:  new Date(itemFromServeur.cotisation.debut),
				fin:  new Date(itemFromServeur.cotisation.fin),
				montant: itemFromServeur.cotisation.montant
			};
		}

		myCtrl.adherent = itemForIHM;
		console.log(myCtrl.adherent);
	}
	
	$http.get(url).then(function(response){
		initAdherent(response);
	}, function(){
		// En cas d'erreur
		myCtrl.emprunteurs = -1;
	});
	
	
	myCtrl.submitAdherent = function() {
	
			var url = 'http://10.34.10.140:8080/resource/media.modification';	
		
			$http.post(url, myCtrl.adherent).then(function(response) {			
					
			},function(response) {
		
			});
	}
	
	
	
	
	
	
	

	
	
	
	
	

	
	
}]);




	