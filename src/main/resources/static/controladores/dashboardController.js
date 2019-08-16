var dashboard = angular.module("bibliotecaDashboardApp", ["ngRoute"], function ($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|file|javascript):/);
});

dashboard.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    $routeProvider
        .when("/", {
            templateUrl: "/vistas/dashboard/principal.html",
            controller: "principalController"
        }).when("/menucontenido", {
            templateUrl: "/vistas/dashboard/MenuRegistroContenido.html",
            controller: "MenuRegistroContenidoController"
        }).when("/registrocontenido/:tipoContenido", {
            templateUrl: "/vistas/dashboard/registroContenido.html",
            controller: "registrarContenidoController"
        }).otherwise({
            redirectTo: "/"
        });
}]);

dashboard.controller("dashboardController", function ($scope, $location) {
    $scope.cambiarVista = function (ruta) {
        $location.path(ruta);
    };
});