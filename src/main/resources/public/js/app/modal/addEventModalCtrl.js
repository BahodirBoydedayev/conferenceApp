app.controller('addEventModalCtrl', function ($scope, event, eventService, $uibModalInstance) {

    $scope.event = event.data;
    console.log(event.data);

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };

    $scope.save = function () {
        eventService.save($scope.event).then(function (response) {
            $uibModalInstance.close(response.data);
        });
    }
});