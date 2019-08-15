dashboard.controller("principalController", function ($scope, $http) {

    $scope.archivo = {};

    $scope.esquema = [
        { original: "video", nombre: "Videos" },
        { original: "audio", nombre: "Audios" },
        { original: "imagen", nombre: "Imagenes" },
        { original: "arte", nombre: "Arte" },
        { original: "tesis", nombre: "Tesis" },
        { original: "libros", nombre: "Libros" },
        { original: "publicaciones", nombre: "Publicaciones" },
        { original: "diapositivas", nombre: "Diapositivas" },
        { original: "tareas", nombre: "Tareas" },
        { original: "otrosRecursos", nombre: "Otros Recursos del aula" },
    ];

    $scope.principalLoad = function () {
        for (var i = 0; i < $scope.esquema.length; i++) {
            $scope.cantidadDeCadaTipo($scope.esquema[i].original);
        }
    };

    $scope.cantidadDeCadaTipo = function (tipo) {
        $http({
            url: '/archivos/' + tipo, method: 'GET'
        }).then(function (response) {
            switch (tipo) {
                case 'video':$scope.archivo.videos = response.data.length;
                    break;
                case 'audio':$scope.archivo.audios = response.data.length;
                    break;
                case 'imagen':$scope.archivo.imagenes = response.data.length;
                    break;
                case 'arte': $scope.archivo.arte = response.data.length;
                    break;
                case 'tesis':$scope.archivo.tesis = response.data.length;
                    break;
                case 'libros':$scope.archivo.libros = response.data.length;
                    break;
                case 'publicaciones':$scope.archivo.publicaciones = response.data.length;
                    break;
                case 'diapositivas':$scope.archivo.diapositivas = response.data.length;
                    break;
                case 'tareas':$scope.archivo.tareas = response.data.length;
                    break;
                case 'otrosRecursos':$scope.archivo.otrosRecursos = response.data.length;
                    break;
            }
        }, function (reason) {
            console.log("REASON: " + reason);
        });
    }

});