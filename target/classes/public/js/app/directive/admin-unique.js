/**
 * Created by bakhodir on 7/20/16.
 */
angular.module('myApp').directive('ensureUniqueAdmin', function ($http) {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, c) {
            scope.$watch(attrs.ngModel, function (n) {
                if (!n) return;
                $http({
                    method: 'POST',
                    url: 'api/admin/admins/findByLogin',
                    data: {
                        field: attrs.ensureUniqueAdmin,
                        value: n
                    }
                }).then(function successCallback(response) {
                    c.$setValidity('unique', !response.data);
                }, function errorCallback(error) {
                    c.$setValidity('unique', false);
                })
            })
        }
    }
});
