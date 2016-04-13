
// Création du module ModuleApp avec les dépendances :
//  - ng-route : pour gérer des URL différentes
//  - ModuleGlobal : pour avoir les filtres

angular.module('ModuleApp', ['ngRoute', 'ModuleGlobal', 'ModuleConnexion', 'ModuleMedia', 'ui.bootstrap']);

// Configuration du module ModuleApp
// => Injection du Provider du service $route afin de le configurer.
angular.module('ModuleApp').config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo : '/login'
		})
});