app.service("organizationService", function ($http) {

    this.all = function () {
        return $http.get('public/organizations');
    }
});
