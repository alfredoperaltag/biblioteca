let index = angular.module("biblioteca", ["ngRoute"], function ($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|file|javascript):/);
});
index.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider
        .when("/login", {
            templateUrl: "/vistas/index/login.html"
        }).when("/registro", {
            templateUrl: "/vistas/index/registro.html"
        }).when("/recuperacion", {
            templateUrl: "/vistas/index/recuperacion.html"
        }).otherwise({
            templateUrl: "/vistas/index/login.html"
        });
}]);