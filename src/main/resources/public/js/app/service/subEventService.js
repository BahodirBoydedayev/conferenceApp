app.service('subEventService', function ($http) {
    this.list = function (text, size, page, eventId) {
        return $http.get('api/subEvents', {
            params: {
                text: text || '',
                page: page || 0,
                size: size || 10,
                eventId: eventId
            }
        })
    };

    this.delete = function (id) {
        return $http.delete('api/subEvents/' + id);
    };
});
