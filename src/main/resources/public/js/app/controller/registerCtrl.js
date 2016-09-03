app.controller('registerCtrl', function ($scope, userService, organizations, $state, $timeout) {

    console.log(organizations);
    $scope.user.organizations = organizations;
    $scope.register = function () {
        userService.save($scope.user).then(function (data) {
            $scope.notify('success', "User created");
            $timeout(function () {
                $state.go('login');
            }, 1000)
        })
    }
});