
app.controller('loginCtrl', function ($http, $scope,authenticationService, $location, $state) {

    window.localStorage.removeItem("token");

    $scope.auth = function (user) {
        var token = btoa(user.username + ':' + user.password);
        $http({
            url: '/auth/',
            method: 'GET',
            headers: {
                'Authorization': 'Basic ' + token
            }
        }).success(function (response) {
            console.log(response);
            $http.defaults.headers.common.Authorization = 'Basic ' + token;
            window.localStorage.setItem("token", token);
            var previousPath = sessionStorage.getItem("previousPath");
            window.localStorage.setItem("pageSize", 10);
            authenticationService.setCurrentUser(response)
                .then(function (user) {
                    $scope.user = user;
                });
            $state.go('app.users');
        }).error(function (error) {
            console.log(error);
            //$scope.notify('danger', $translate.instant('user.incorrect_login'));
        })
    };
});