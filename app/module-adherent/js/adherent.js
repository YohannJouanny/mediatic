
// Création du module ModuleAdherent
angular.module('ModuleAdherent', ['ngRoute']);

// Configuration du module ModuleCommande
// => Injection du Provider du service $route afin de configurer la route des commandes.
angular.module('ModuleAdherent').config(function($routeProvider){
	$routeProvider.when('/adherent', {
		templateUrl : './module-adherent/templates/rechercheAdherent.html',
		controller : 'AdherentController',
		controllerAs : 'AdherentCtrl' 
	});
});