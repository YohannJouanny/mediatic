
// Création du module ModuleConnexion
angular.module('ModuleConnexion', ['ngRoute', 'ModuleGlobal']);

// Configuration du module ModuleConnexion
// => Injection du Provider du service $route afin de configurer la route des commandes.
angular.module('ModuleConnexion').config(function($routeProvider){
	$routeProvider.when('/login', {
		templateUrl : './module-connexion/template/connexion.html',
		controller : 'ConnexionController',
		controllerAs : 'loginCtrl'
	});
});