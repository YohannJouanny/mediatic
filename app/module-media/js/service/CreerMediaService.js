

angular.module('ModuleMedia').service('CreerMediaService', ['$http', function($http) {
	var self = this;
	
	var url = 'http://10.34.10.140:8080/resource/media.creation';
	
	
	
	
	self.submit = function(titre, auteur, type) {
		var media = {
			titre : titre,
			auteur : auteur,
			type : type
		};
		
		console.log(media);
		
		return $http.post(url, media).then(function(response) {
			return {submited: true, status: response.status};
		},
		function(response) {
			return {submited: false, status: response.status};
		});
	};
	
	
}]);
