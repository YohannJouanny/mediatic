
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
});