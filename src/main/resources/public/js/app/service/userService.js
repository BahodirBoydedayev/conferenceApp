app.service('userService', function ($http) {
    this.list = function (text, size, page) {
        return $http.get('api/admin/users', {
            params: {
                text: text,
                size: size,
                page: page
            }
        });
    };

    this.delete = function (id) {
        return $http.delete('api/admin/users/' + id);
    };

    this.edit = function (user) {
        return $http.put('api/admin/users', user);
    };
    this.currentUser = function () {
        return $http.get('api/admin/users/currentUser');
    }
});
