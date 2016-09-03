
angular.module('myApp').controller('eventCtrl', function ($scope, $http, $uibModal, $log, eventService) {

    $scope.events = [];
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
        eventService.list($scope.searchText, $scope.pageSize, $scope.pageNumber).then(function (response) {
            $scope.events = response.data.events;
            $scope.count = response.data.count;
        });
    };

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
