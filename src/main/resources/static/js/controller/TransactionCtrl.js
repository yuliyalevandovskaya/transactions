app.controller('TransCtrl', ['$scope','$location','$route', 'TransService','$rootScope', function ($scope, $location, $route, TransService, $rootScope) {

    $scope.emptyList = false;
    $scope.valid = false;
    $scope.errorLetter = false;
    $scope.transactions = '';
    $scope.statistics = '';
    $scope.test = [];


    $scope.reloadRoute = function () {
        $route.reload();
    };

    $scope.findTransaction = function (type, currency) {

        TransService.findTransaction(type, currency)
            .then(function successCallback(response) {
                $scope.test.push(response.data);

            }, function errorCallback(response) {
                console.log('Error: all transactions');
            });
    };

    TransService.allTransaction()
        .then(function successCallback(response) {
            $scope.transactions = response.data;
            if(response.data.length == 0){
                $scope.emptyList = true;
            }

        }, function errorCallback(response) {
            console.log('Error: all transactions');
        });

    TransService.statTransaction()
        .then(function successCallback(response) {
            $scope.statistics = response.data;
            console.log(response.data);
        }, function errorCallback(response) {
            console.log('Error: all transactions');
        });
}]);
