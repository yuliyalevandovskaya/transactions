app.service('TransService', function ($http) {

    var self = this;

    self.findTransaction = function (type, currency) {
        return $http({
            method: 'POST',
            url: '/transaction/find',
            data: {
                'type': type,
                'currency': currency
            },
            headers: {'Content-type': 'application/json'}
        });
    };

    self.allTransaction = function () {
        return $http({
            method: 'GET',
            url: '/transaction/all',
            headers: {'Content-type': 'application/json'}
        });
    };

    self.statTransaction = function () {
        return $http({
            method: 'GET',
            url: '/transaction/statistics',
            headers: {'Content-type': 'application/json'}
        });
    };
});