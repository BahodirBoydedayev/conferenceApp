
angular.module('myApp').controller('userCtrl', function ($scope, $http, $uibModal, $log, userService) {

    $scope.users = [];
    $scope.pageNumber = 1;
    $scope.searchText = '';
    $scope.count = 0;

    var pageSize = window.localStorage.getItem("pageSize");
    if (pageSize) {
        $scope.pageSize = pageSize;
    }
    else {
        $scope.pageSize = 10;
        window.localStorage.setItem("pageSize", $scope.pageSize);
    }

    $scope.initData = function () {
        userService.list($scope.searchText, $scope.pageSize, $scope.pageNumber).then(function (response) {
            $scope.users = response.data.users;
            console.log(($scope.users));
            $scope.count = response.data.count;
        });
    };

    //$scope.deleteUser = function (user) {
    //    var confirm = window.confirm("sure");
    //    if (confirm) {
    //        userService.delete(user.id).then(function () {
    //            $scope.users = $scope.users.filter(function (data) {
    //                return data.id != user.id;
    //            });
    //        });
    //        $scope.notify('success', "deleted...");
    //    }
    //};

    $scope.pageSizeChanged = function () {
        $scope.pageNumber = 1;
        window.localStorage.setItem("pageSize", $scope.pageSize);
        $scope.initData();
    };

    $scope.changedInputText = function () {
        $scope.pageNumber = 1;
        $scope.initData();
    };
});
