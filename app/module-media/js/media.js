<<<<<<< HEAD
=======

>>>>>>> 57190df... Ajout de la page création média + correction de la page connexion
// Création du module ModuleMedia
angular.module('ModuleMedia', ['ngRoute']);

// Configuration du module ModuleMedia
// => Injection du Provider du service $route afin de configurer la route des commandes.
angular.module('ModuleMedia').config(function($routeProvider){
	$routeProvider.when('/media', {
		templateUrl : './module-media/templates/rechercheMedia.html',
		controller : 'MediaController',
		controllerAs : 'medCtrl'
	});
<<<<<<< HEAD
	
//	$routeProvider.when('/visuMedia', {
//		templateUrl : './module-media/templates/visualisationMedia.html',
//		controller : 'VisuMediaController',
//		controllerAs : 'visuMedCtrl'
//	});
	
=======
>>>>>>> 57190df... Ajout de la page création média + correction de la page connexion
	$routeProvider.when('/media/creation', {
		templateUrl : './module-media/templates/creationMedia.html',
		controller : 'CreerMediaController',
		controllerAs : 'newMediaCtrl'
<<<<<<< HEAD
	});
=======
	});
});
>>>>>>> 57190df... Ajout de la page création média + correction de la page connexion
