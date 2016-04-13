

angular.module('ModuleMedia').controller('VisuMediaController', [ '$http', '$routeParams', '$rootScope', function($http, $routeParams, $rootScope){
	var myCtrl = this;
	
	$rootScope.title = "Visualisation du media";
	
	myCtrl.media = undefined;
	myCtrl.emprunteurs = undefined;
	myCtrl.showFormAjout = false;
	myCtrl.mediaEmprunter = false
	
	var url = "http://10.34.10.140:8080/resource/media.accession?id="+$routeParams.mediaId;
	
	var initEmprunteurs = function(response){
		
		var itemFromServeur = response.data
		var itemForIHM = {
			id:itemFromServeur.id,
			titre:itemFromServeur.titre,
			auteur:itemFromServeur.auteur,
			type:itemFromServeur.type,
			emprunteur:itemFromServeur.emprunteur
		};
		myCtrl.media = itemForIHM;
		myCtrl.showFormAjout = myCtrl.media.emprunteur!=null;
		myCtrl.calculDateReturn();
		
		
		myCtrl.emprunteurs = [];
		for(var index in response.data.emprunteurs){
				
			var emp = response.data.emprunteurs[index];
				
			myCtrl.emprunteurs.push({
				adherent : emp.adherent,
				depart : new Date(emp.depart),
				retour : new Date(emp.retour),
			});;
		}		
	}
	
	$http.get(url).then(function(response){
		initEmprunteurs(response);
	}, function(){
		// En cas d'erreur
		myCtrl.emprunteurs = -1;
	});
	
	myCtrl.nomPrenom = function(adh){
		if(adh!=null){
			return adh.adherent.nom+" "+adh.adherent.prenom;
		}else{
			return "";
		}
		
	}
	
	myCtrl.modificationMedia = function(){
		
	}
	
	myCtrl.dateToday = new Date();
	myCtrl.dateReturn = new Date();
	
	myCtrl.calculDateReturn = function(){
		var date = myCtrl.dateToday;
		if(myCtrl.media.type=="Livre"){
			myCtrl.dateReturn = new Date(date.getYear() ,date.getMonth() ,date.getDate()+30);
		}else{
			myCtrl.dateReturn = new Date(date.getYear() ,date.getMonth() ,date.getDate()+15);
		}
	}
	
	
	
}]);