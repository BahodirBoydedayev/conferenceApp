angular.module('myApp').controller('appCtrl', function ($http, currentUser, $scope, $state, $location) {

    $scope.currentUser = currentUser.data;
    console.log($scope.currentUser);
    $scope.logout = function () {
        window.localStorage.removeItem('token');
        $location.path('/login');
    };
});