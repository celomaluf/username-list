angular.module('unl').controller('DictionaryOfWordsController', DictionaryOfWordsController);
DictionaryOfWordsController.$inject = ['$scope', 'unlService'];

function DictionaryOfWordsController($scope, unlService) {
    var app = this;
    
    $scope.warningMessage = '';
    $scope.successMessage = '';
    $scope.restrictedWord = '';
    $scope.restrictedWords = {};
    
    $scope.isDisabled = false;
    
    app.getRestrictedWords = function () {
    	unlService.getRestrictedWords( function (response) {
    		$scope.restrictedWords = response.result;
    	}, function ( error) {
    		console.log(error);
    	});
    };
    
    app.clearVariables = function () {
    	$scope.warningMessage='';
    	$scope.successMessage ='';
    };
    
    app.manageResponse = function (response) {	
    	if (response.result.length == $scope.restrictedWords.length) {
			$scope.warningMessage = 'Restricted Word is already registered.';
			return;
		}
    	$scope.restrictedWords = response.result;
		$scope.successMessage = 'Restricted Word was successfully registered.';
		$scope.restrictedWord = '';
	    $scope.form.$setPristine(true)
    };
    
    $scope.addRestrictedWord = function () {
    	$scope.isDisabled = true;
    	app.clearVariables();
    	unlService.addRestrictedWord( $scope.restrictedWord, function (response) { 
    		$scope.isDisabled = false;
    		app.manageResponse(response);
    	});
    };
    
    app.getRestrictedWords();
}