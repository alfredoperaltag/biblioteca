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
            $scope.archivo.tipo = $scope.esquema[i].original;
            $scope.cantidadDeCadaTipo($scope.archivo.tipo);
        }
    };

    $scope.cantidadDeCadaTipo = function (tipo) {
        $http({
            url: '/archivos/' + tipo, method: 'GET'
        }).then(function (response) {
            //console.log(response.data.length);
            if (tipo === "video") {
                $scope.archivo.videos = response.data.length;
            }
            if (tipo === "audio") {
                $scope.archivo.audios = response.data.length;
            }
            if (tipo === "imagen") {
                $scope.archivo.imagenes = response.data.length;
            }
            if (tipo === "arte") {
                $scope.archivo.arte = response.data.length;
            }
            if (tipo === "tesis") {
                $scope.archivo.tesis = response.data.length;
            }
            if (tipo === "libros") {
                $scope.archivo.libros = response.data.length;
            }
            if (tipo === "publicaciones") {
                $scope.archivo.publicaciones = response.data.length;
            }
            if (tipo === "diapositivas") {
                $scope.archivo.diapositivas = response.data.length;
            }
            if (tipo === "tareas") {
                $scope.archivo.tareas = response.data.length;
            }
            if (tipo === "otrosRecursos") {
                $scope.archivo.otrosRecursos = response.data.length;
            }

        }, function (reason) {
            console.log("REASON: " + reason);
        });
    }

});