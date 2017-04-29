angular.module('unl').controller('UNLController', UNLController);

UNLController.$inject = ['$scope', 'unlService'];
function UNLController($scope, unlService) {
    var app = this;
    
    $scope.warningMessage = '';
    $scope.successMessage = '';
    $scope.username = '';
    $scope.result = [];
    $scope.isDisabled = false;
    
    app.clearVariables = function () {
    	$scope.warningMessage='';
    	$scope.successMessage ='';
    	$scope.result.possibleUsernames='';
    };
    
    app.manageResponse = function (response) {
		if ( !$scope.result.validUsername ) {
			$scope.warningMessage = 'Username has already been taken, please choose another one.'
			return;
		}
		if ( !$scope.result.validRestrictedWord ) {
			$scope.warningMessage = 'You can not use restricted words in the Username, please choose another one.'
			return;
		}
		$scope.successMessage = 'Username was successfully registered.';
		$scope.username = '';
	    $scope.form.$setPristine(true)

    };
    
    $scope.addUsername = function () {
    	$scope.isDisabled = true;
    	app.clearVariables();
    	unlService.addUsername( $scope.username, function (response) { 
    		$scope.result = response.result;
    		$scope.isDisabled = false;
    		app.manageResponse(response);
    	}, function (error) {
    		console.log(error)
    	});
    };
}