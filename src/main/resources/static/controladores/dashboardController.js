var dashboard = angular.module("bibliotecaDashboardApp", ["ngRoute", "ngTagsInput"], function ($compileProvider) {
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

dashboard.config(function (tagsInputConfigProvider) {
    tagsInputConfigProvider
        .setDefaults('tagsInput', {
            placeholder: 'Agregar etiquetas',
            minLength: 2,
            addOnEnter: true,
            addOnSpace: false,
            addOnComa: true,
            // removeTagSymbol:"-",
            replaceSpacesWithDashes: false,
            maxTags: 100
        })
});