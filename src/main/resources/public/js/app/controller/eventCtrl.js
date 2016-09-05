app.controller('eventCtrl', function ($scope, $http, currentUser, $uibModal, $log, eventService) {

    $scope.events = {};
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
            console.log(response);
            $scope.events = response.data.events;
            $scope.count = response.data.count;
            console.log($scope.count);
            console.log($scope.events);
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

    $scope.addEventModal = function (id) {
        id = id || -1;
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'templates/modal/addEventModal.html',
            controller: 'addEventModalCtrl',
            resolve: {
                event: function (eventService) {
                    return eventService.findOne(id);
                }
            }
        });
        modalInstance.result.then(function (selectedItem) {
            $scope.initData();
        }, function () {
            $log.info('Modal dismissed at: ' + new Date());
        });
    };
});
