var unl = angular.module('unl');

/* 
 * @WEB_URL
 */

unl.constant('BACKEND_CFG',  {
	url: 'http://localhost:8080/unl/',
    setupHttp: function(http) {
        http.defaults.useXDomain = true;
        http.defaults.withCredentials = true;
    }
});

