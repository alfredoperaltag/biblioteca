dashboard.controller("principalController", function ($scope, $http) {

    $scope.archivo = {};

    $scope.esquema = [
        { original: "videos", nombre: "Videos" },
        { original: "audios", nombre: "Audios" },
        { original: "imagenes", nombre: "Imagenes" },
        { original: "arte", nombre: "Arte" },
        { original: "tesis", nombre: "Tesis" },
        { original: "libros", nombre: "Libros" },
        { original: "publicaciones", nombre: "Publicaciones" },
        { original: "diapositivas", nombre: "Diapositivas" },
        { original: "tareas", nombre: "Tareas" },
        { original: "otrosRecursos", nombre: "Otros Recursos del aula" },
    ];

    $scope.principalLoad = function () {
        for (let i = 0; i < $scope.esquema.length; i++) {
            $scope.archivo.tipo = $scope.esquema[i].original;
            $scope.cantidadDeCadaTipo($scope.archivo.tipo);
        }
    }

    $scope.cantidadDeCadaTipo = function (tipo) {
        $http({
            url: '/archivos/' + tipo, method: 'GET'
        }).then(function (response) {
            console.log(response.data.length);
        }, function (reason) {
            console.log("REASON: " + reason);
        });
    }

});