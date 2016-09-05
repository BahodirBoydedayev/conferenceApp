app.config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state('app', {
            templateUrl: 'templates/app.html',
            controller: 'appCtrl',
            resolve: {
                currentUser: function (userService) {
                    return userService.currentUser();
                }
            }
        })
        .state('login', {
            url: '/login',
            templateUrl: 'templates/login/login.html',
            controller: 'loginCtrl'
        })
        .state("register", {
            url: '/register',
            templateUrl: 'templates/login/register.html',
            controller: 'registerCtrl',
            resolve: {
                organizations: function (organizationService) {
                    return organizationService.all();
                }
            }
        })
        .state('app.users', {
            url: '/users',
            templateUrl: 'templates/userTmpl.html',
            controller: 'userCtrl'
        })
        .state('app.events', {
            url: '/events',
            templateUrl: 'templates/eventTmpl.html',
            controller: 'eventCtrl'
        })
        .state('app.subEvents', {
            url: '/events/:eventId/subevent/',
            templateUrl: 'templates/subEventTmpl.html',
            controller: 'subEventCtrl'
        })
        .state('app.error404', {
            url: '/error404',
            templateUrl: 'templates/error404.html'
        });
    $urlRouterProvider.otherwise(function ($scope, $location, $state) {
        var token = window.localStorage.getItem('token');
        if (token) {
            $location.path('/users');
        }
        else {
            $location.path('/error404');
        }
    })
})
;
