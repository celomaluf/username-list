angular.module('unl').service('unlService', unlService);
unlService.$inject =['$http', 'BACKEND_CFG'];

function unlService ( $http, BACKEND_CFG) {
	var service = this;          

	service.addUsername = function (username, callback) {
		$http.post(BACKEND_CFG.url + 'api/user/addUsername?username=' + username )
			.success(function (response) {
			callback(response);
	    }).error (function (error) {
	    	callback(error);	
	    });
	};
	
	service.getRestrictedWords = function (callback) {
		$http.get(BACKEND_CFG.url + 'api/user/getRestrictedWords')
			.success(function (response) {
			callback(response);
	    }).error (function (error) {
	    	callback(error);	
	    });
	};
	
	service.addRestrictedWord = function (restrictedWord, callback) {
		$http.post(BACKEND_CFG.url + 'api/user/addRestrictedWord?restrictedWord=' + restrictedWord )
			.success(function (response) {
			callback(response);
	    }).error (function (error) {
	    	callback(error);	
	    });
	};

	return service;
}