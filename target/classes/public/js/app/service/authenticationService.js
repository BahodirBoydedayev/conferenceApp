
angular.module('myApp')
    .factory('authenticationService', function ($q, $http) {
        var service = {
            _user: null,
            setCurrentUser: function (user) {
                if (user) {
                    service._user = user;
                    return service.setCurrentUser();
                }
                else {
                    var d = $q.defer();
                    return d.promise;
                }
            },
            currentUser: function () {
                var d = $q.defer();
                d.resolve(service._user);
                return d.promise;
            }
        };
        return service;
    });
