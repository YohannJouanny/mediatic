
angular.module('ModuleConnexion')
	.controller('ConnexionController', ['$http','$location', function($http, $location) {
		var ctrl = this;
		
		ctrl.error = {};
		ctrl.error.badLogin = false;
		ctrl.error.serverDown = false;
		
		
		ctrl.login = function() {
			var url = 'http://10.34.10.140:8080/resource/connexion.login';
			
			var logs = {
				login : ctrl.identifier,
				mdp : ctrl.password,
			};

			ctrl.password = '';

			$http.post(url, logs).then(function(response) {
								console.log('success');
								$location.path('/media');
			},
			function(response) {
				console.log('requeste response : error(', response.status, ')');
				
				if (response.status == 403) {
					ctrl.error.badLogin = true;
				}
				else if (response.status == 500 || response.status == 503) {
					ctrl.error.serverDown = true;
				}

			});
		}
		
	}]);


