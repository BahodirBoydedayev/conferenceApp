angular.module('myApp').run(function ($rootScope) {
    $rootScope.dt1 = new Date("yyyy-MM-dd HH:mm:ss");
    $rootScope.dt2 = new Date("yyyy-MM-dd HH:mm:ss");

    $rootScope.today = function () {
        $rootScope.dt1 = new Date();
        $rootScope.dt2 = new Date();
    };
    $rootScope.today();

    $rootScope.clear = function () {
        $rootScope.dt1 = null;
        $rootScope.dt2 = null;
    };

    $rootScope.inlineOptions = {
        customClass: getDayClass,
        minDate: new Date(),
        showWeeks: true
    };

    $rootScope.dateOptions = {
        //dateDisabled: disabled,
        formatYear: 'yyyy',
        maxDate: new Date(),
        minDate: new Date(),
        startingDay: 1
    };

    $rootScope.toggleMin = function () {
        $rootScope.inlineOptions.minDate = $rootScope.inlineOptions.minDate ? null : new Date();
        $rootScope.dateOptions.minDate = $rootScope.inlineOptions.minDate;
    };

    $rootScope.toggleMin();

    $rootScope.open1 = function () {
        $rootScope.popup1.opened = true;
    };

    $rootScope.open2 = function () {
        $rootScope.popup2.opened = true;
    };

    $rootScope.setDate = function (year, month, day) {
        $rootScope.dt1 = new Date(year, month, day);
        $rootScope.dt2 = new Date(year, month, day);
    };

    $rootScope.formats = ['yyyy-MM-dd', 'small'];
    $rootScope.format = $rootScope.formats[0];
    $rootScope.altInputFormats = ['yyyy!/MM!/yyyy'];

    $rootScope.popup1 = {
        opened: false
    };

    $rootScope.popup2 = {
        opened: false
    };

    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    var afterTomorrow = new Date();
    afterTomorrow.setDate(tomorrow.getDate() + 1);
    $rootScope.events = [
        {
            date: tomorrow,
            status: 'full'
        },
        {
            date: afterTomorrow,
            status: 'partially'
        }];

    function getDayClass(data) {
        var date = data.date,
            mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

            for (var i = 0; i < $rootScope.events.length; i++) {
                var currentDay = new Date($rootScope.events[i].date).setHours(0, 0, 0, 0);

                if (dayToCheck === currentDay) {
                    return $rootScope.events[i].status;
                }
            }
        }
        return '';
    }

    $rootScope.notify = function (type, text) {
        var notify = $.notify('<strong>Loading...</strong>', {
            type: type,
            allow_dismiss: false,
            showProgressbar: true,
            delay: 1000,
            time: 1000
        });

        setTimeout(function () {
            notify.update('message', '<strong>' + text + '</strong>');
        }, 1000);
    };

});