

angular.module('ModuleGlobal').service('LoginService', ['$http', '$location', function($http, $location) {
	var self = this;
	
	var connected = true;
	
	
	
	self.isConnected = function() {
		return connected;
	};
	
	
	self.connect = function(identifier, password) {
		var url = 'http://10.34.10.140:8080/resource/connexion.login';
		
		var logs = {
			login : identifier,
			mdp : password,
		};
		
		
		return $http.post(url, logs).then(function(response) {
			connected = true;
			return {connected: true, status: response.status};
		},
		function(response) {
			return {connected: false, status: response.status};
		});
	};
	
	
	self.disconnect = function() {
		connected = false;
	};
	
	
}]);

