dashboard.controller("MenuRegistroContenidoController", function ($scope) {
    //$scope.accion = "";

    $scope.verSeccion = function (accion) {
        $scope.accion = accion;
    };

    $scope.Seccion = function (accion) {
        return accion == $scope.accion;
    };

});