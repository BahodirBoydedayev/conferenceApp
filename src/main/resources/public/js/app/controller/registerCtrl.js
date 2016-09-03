app.controller('registerCtrl', function ($scope, userService, organizations, $state, $timeout) {

    $scope.user = {};
    $scope.organizations = organizations.data;

    $scope.register = function () {
        userService.save($scope.user).then(function (data) {
            $scope.notify('success', "User created");
            $timeout(function () {
                $state.go('login');
            }, 1000)
        })
    }
});