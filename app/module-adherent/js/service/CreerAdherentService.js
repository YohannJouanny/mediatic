

angular.module('ModuleAdherent').service('CreerAdherentService', ['$http', function($http) {
	var self = this;
	
	var url = 'http://10.34.10.140:8080/resource/adherent.creation';
	
	
	
	
	self.submit = function(adherent) {
		return $http.post(url, adherent).then(function(response) {
			return {submited: true, status: response.status};
		},
		function(response) {
			return {submited: false, status: response.status};
		});
	};
	
	
	
}]);
