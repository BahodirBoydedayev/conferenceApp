app.service('eventService', function ($http) {
    this.list = function (text, size, page) {
        return $http.get('api/events', {
            params: {
                text: text,
                size: size,
                page: page
            }
        });
    };

    this.delete = function (id) {
        return $http.delete('api/events' + id);
    };

    this.edit = function (user) {
        return $http.put('api/events', user);
    };

    this.save = function (event) {
        return $http.post('api/events', event);
    };

    this.findOne = function (id) {
        return $http.get('api/events/' + id);
    }
});
