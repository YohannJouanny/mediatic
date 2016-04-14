
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('MediaController', [ '$http', '$sce', '$location','$rootScope', function($http, $sce, $location, $rootScope){
	var myCtrl = this;
	
	$rootScope.title = "Recherche d'un media";
	
	myCtrl.medias = undefined;
	
	var url = "http://10.34.10.140:8080/resource/media.recherche"
	
	myCtrl.initMedia = function(response){
		myCtrl.medias = [];
		for(var index in response.data){
			var itemFromServeur = response.data[index];
			var itemForIHM = {
				id:itemFromServeur.id,
				titre:itemFromServeur.titre,
				auteur:itemFromServeur.auteur,
				type:itemFromServeur.type,
				emprunteur:itemFromServeur.emprunteur,
				retour: new Date(itemFromServeur.retour)
			};
			myCtrl.medias.push(itemForIHM);
		}
	}
	
	
	$http.get(url, {params : {page:0}}).then(function(response){
		myCtrl.initMedia(response);
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
	
	myCtrl.recherche = function(){
		var rech = {
			titre : myCtrl.titre,
			auteur : myCtrl.auteur,
			type : myCtrl.type,
			page : 0
		}
					
		$http.get(url, {params : rech}).then(function(response){
			myCtrl.initMedia(response);
			myCtrl.initPagination();
		})
	}
	
	myCtrl.totalItems = undefined;
	myCtrl.currentPage = 0;
	myCtrl.maxSize = 5;
	
	myCtrl.initPagination = function(){
		var urlTaille = "http://10.34.10.140:8080/resource/media.recherche.taille"
		
		var rech = {
			titre : myCtrl.titre,
			auteur : myCtrl.auteur,
			type : myCtrl.type,
		}
		
		$http.get(urlTaille, {params : rech}).then(function(response){
			myCtrl.totalItems = response.data.items;
		})
		
	}
	
	myCtrl.initPagination();
	
	myCtrl.pagination = function(myPage){
		var rech = {
			titre : myCtrl.titre,
			auteur : myCtrl.auteur,
			type : myCtrl.type,
			page : myPage
		}
		
		$http.get(url, {params : rech}).then(function(response){
			myCtrl.initMedia(response);
		})
	}
	


}]);