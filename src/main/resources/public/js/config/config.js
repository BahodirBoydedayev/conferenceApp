
var app = angular.module('myApp', ['ui.router', 'ui.bootstrap'])
    .run(function ($rootScope, $location, $http, $window, $state) {
        $http.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        var token = window.localStorage.getItem('token');
        if (token) {
            $http.defaults.headers.common.Authorization = 'Basic ' + token;
        }
        else {
            $state.go('login');
        }
        $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams, options) {
            var token = window.localStorage.getItem('token');
            if (token == null && toState.name !== 'login' && toState.name !== 'register') {
                window.sessionStorage.setItem('previousPath', fromState);
                event.preventDefault();
                $state.go('login');
            }
        });
    });