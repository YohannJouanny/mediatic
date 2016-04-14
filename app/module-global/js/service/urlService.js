

angular.module('ModuleGlobal').factory('urlService', [function() {
	
	var server = 'http://10.34.10.140:8090';
	
	return {
		getLoginUrl: function() {
			return server + '/resource/connexion.login';
		},
	
		getRechercheMedia: function() {
			return server + '/resource/media.recherche';
		},
	
		getAccessionMedia: function() {
			return server + '/resource/media.accession';
		},
	
		getAjoutEmpruntUrl: function() {
			return server + '/resource/emprunt.ajout';
		}
	};
	
	
	
}]);

