var unlWebModule = angular.module('unl');

unlWebModule.config(['$routeProvider', function ($routeProvider){
        
	$routeProvider        
        	.when('/username', {
        		controller: 'UNLController',
	            templateUrl: 'webui/view/username/username.html',
	            controllerAs: 'UNLController'
        	})
        	.when('/dictionary', {
        		controller: 'DictionaryOfWordsController',
	            templateUrl: 'webui/view/username/dictionary-of-words.html',
	            controllerAs: 'DictionaryOfWordsController'
        	})
        	
            .otherwise({ redirectTo: '/username' });
    }
]);
