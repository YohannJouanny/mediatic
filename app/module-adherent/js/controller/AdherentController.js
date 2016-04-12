// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleAdherent').controller('AdherentController', ['$location', '$rootScope', 'AdherentService', function( $location, $rootScope, AdherentService) {
	var myCtrl = this;
	

	myCtrl.adherents = undefined;
	
	AdherentService.getList().then(function(response) {
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
	
	
	
	
}]);