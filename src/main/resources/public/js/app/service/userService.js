app.service('userService', function ($http) {
    this.list = function (text, size, page) {
        return $http.get('api/users', {
            params: {
                text: text || '',
                page: page || 0,
                size: size || 10
            }
        })
    };

    this.delete = function (id) {
        return $http.delete('api/users/' + id);
    };

    this.currentUser = function () {
        return $http.get('api/users/currentUser');
    };
    this.save = function (user) {
        return $http.post('auth/register', user);
    }
});
