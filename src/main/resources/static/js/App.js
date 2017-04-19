'use strict';

var app = angular.module('app', ['ngRoute', 'ngResource']);

app.config(function ($routeProvider , $httpProvider) {

    $routeProvider
        .when('/transaction/all', {
            templateUrl: 'views/all_transactions.html',
            controller: 'TransCtrl'
        })
        .when('/transaction/find', {
            templateUrl: 'views/search_transaction.html',
            controller: 'TransCtrl'
        })
        .when('/transaction/stat', {
            templateUrl: 'views/statistics.html',
            controller: 'TransCtrl'
        })
        .otherwise(
            {redirectTo: '/'}
        );

    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});
