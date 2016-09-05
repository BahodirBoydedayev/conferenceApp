app.controller('subEventCtrl', function ($scope, subEventService, $stateParams, $uibModal, $log) {

    $scope.subEvents = [];
    $scope.pageNumber = 1;
    $scope.searchText = '';
    $scope.count = 0;
    $scope.subEvent = [];

    var pageSize = window.localStorage.getItem("pageSize");
    if (pageSize) {
        $scope.pageSize = pageSize;
    }
    else {
        $scope.pageSize = 10;
        window.localStorage.setItem("pageSize", $scope.pageSize);
    }

    $scope.initData = function () {
        subEventService.list($scope.searchText, $scope.pageSize, $scope.pageNumber, $stateParams.eventId).then(function (response) {
            $scope.subEvents = response.data.subEvents;
            $scope.count = response.data.count;
            console.log(response.data.subEvents[0].event.name);
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
