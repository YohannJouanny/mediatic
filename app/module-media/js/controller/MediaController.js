
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('MediaController', [ 'MediaService', '$sce', '$rootScope', function(MediaService, $sce, $rootScope){
	var myCtrl = this;
	
	$rootScope.title = 'Recherche d\'un média';
	myCtrl.medias = undefined;
	
	
	MediaService.getList().then(function(response) {
		// En cas de succes
		myCtrl.medias = response;
	}, function(){
		// En cas d'erreur
		myCtrl.medias = -1;
	});
	
	myCtrl.nomPrenom = function(adh){
		if(adh!=null){
			return adh.nom+" "+adh.prenom;
		}else{
			return "";
		}
		
	}
	
	myCtrl.disponibiliter = function(media){
		if(media.retour == null){
			return "Disponible"
		}else{
			return "Emprunté par "+ myCtrl.nomPrenom(media.emprunteur) +"jusqu'au "+media.retour;
		}
	}
	
	myCtrl.icons = function(type){
		if(type=="Livre"){
			return $sce.trustAsHtml('<span class="fa fa-book" />');
		}else if(type=="CD"){
			return $sce.trustAsHtml('<span class="fa fa-music" />');
		}else{
			return $sce.trustAsHtml('<span class="fa fa-film" />');
		}
	}
	
}]);