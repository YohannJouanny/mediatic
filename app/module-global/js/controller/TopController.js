

angular.module('ModuleGlobal')
	.controller('TopController', ['LoginService', function(LoginService) {
		var ctrl = this;
		
		
		ctrl.error = {};
		ctrl.error.badLogin = false;
		ctrl.error.serverDown = false;
		
		
		ctrl.isConnected = function() {
			return LoginService.isConnected();
		};
		
		
		
		ctrl.connect = function() {
			LoginService.connect(ctrl.identifier, ctrl.password).then(function(response) {
				if(response.connected) {
					console.log('success');
					
					if (!ctrl.remenberMe) {
						ctrl.identifier = '';
						ctrl.password = '';
					}
					
					$location.path('/media');
				}
				else {
					console.log('requeste response : error(', response.status, ')');
					
					if (response.status == 403) {
						ctrl.error.badLogin = true;
					}
					else if (response.status == 500 || response.status == 503) {
						ctrl.error.serverDown = true;
					}
					
					ctrl.identifier = '';
					ctrl.password = '';
				}
			});
			
			
		};
		
		
		ctrl.disconnect = function() {
			LoginService.disconnect();
		};
		
		
	}]);

