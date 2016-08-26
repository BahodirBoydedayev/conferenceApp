/**
 * Created by bakhodir on 6/18/16.
 */
angular.module('myApp').controller('settingController', function ($scope, $http, $state, authenticationService, admin, $location, $timeout) {

    $scope.admin = admin.data;
    $scope.changeUserSettings = function (admin) {
        if ((admin.currentPassword && admin.newPassword) ||
            (!admin.currentPassword && !admin.newPassword)) {
            if (admin.newPassword) admin.passcode = admin.newPassword;
            $http.put("api/admin/admins/" + admin.id, admin).then(function (response) {
                $scope.admin = response.data;
                $scope.notify('success', $.instant('user.data_success_changed'));
                $timeout(function () {
                    $state.go('login');
                    //$location.path('/login')
                }, 2000);
            });
        }
        else {
            $scope.notify('danger', "danger");
        }
    };
});