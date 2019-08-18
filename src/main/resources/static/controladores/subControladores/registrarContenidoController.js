dashboard.controller("registrarContenidoController", function ($scope, $http, $routeParams) {
    $scope.tipoContenido = $routeParams.tipoContenido;
    $scope.archivo = {};
    $scope.fecha = Date.now();
    $scope.listaArchivosPorTipo = [];

    $scope.Seccion = function (accion) {
        return accion == $scope.accion;
    };
    $scope.verSeccion = function (accion) {
        $scope.accion = accion;
    };



    $scope.esquema = [
        { original: "videos", nombre: "Videos", formatos: ".mp4" },
        { original: "audios", nombre: "Audios", formatos: ".mp3" },
        { original: "imagenes", nombre: "Imagenes", formatos: ".jpeg, .jpg, .png, .gif" },
        { original: "arte", nombre: "Arte", formatos: ".jpeg, .jpg, .png, .gif" },
        { original: "tesis", nombre: "Tesis", formatos: ".pdf" },
        { original: "libros", nombre: "Libros", formatos: ".pdf" },
        { original: "publicaciones", nombre: "Publicaciones", formatos: ".pdf" },
        { original: "diapositivas", nombre: "Diapositivas", formatos: ".pdf, .doc, .docx, .pptx, .xls, .xlsx" },
        {
            original: "tareas",
            nombre: "Tareas y Soluciones",
            formatos: ".pdf, .doc, .docx, .pptx, .xls, .xlsx, .png, .jpeg, .jpg, .gif"
        },
        {
            original: "otrosrecursos",
            nombre: "Otros recursos del aula",
            formatos: ".pdf, .doc, .docx, .pptx, .xls, .xlsx, .png, .jpeg, .jpg, .gif"
        }
    ];

    $scope.areaConocimiento = [
        { descripcion: "Ciencias Fisico-Matematicas y de las ingenierias" },
        { descripcion: "Ciencias Biologicas, Quimicas y de la Salud" },
        { descripcion: "Humanidades y de las Artes" },
        { descripcion: "Ciencias Sociales" },
        { descripcion: "Matematicas y ciencias experimentales" },
        { descripcion: "Comunicacion" },
        { descripcion: "Ciencias Sociales y Humanidades" }
    ];

    $scope.validar = function () {
        for (var i = 0; i < ($scope.esquema.length + 1); i++) {
            /*if (i >= $scope.esquema.length) {
                $scope.cambiarVista('/menucontenido');
                break;
            }*/
            if ($scope.esquema[i].original === $routeParams.tipoContenido) {
                $scope.archivo.tipo = $scope.esquema[i].nombre;
                $scope.archivo.extenciones = $scope.esquema[i].formatos;
                $scope.listarArchivosPorTipo($scope.archivo.tipo);
                $scope.verSeccion('principal');
                break;
            }
        }
    };

    $scope.listarArchivosPorTipo = function (tipo) {
        console.log("TIPO: " + tipo);
        $http({
            url: '/archivos/' + tipo,
            method: 'GET'
        }).then(function (response) {
            $scope.listarArchivosPorTipo = response.data;
            console.log("Tabla de: " + tipo);
            console.log(response.data);
        }, function (reason) {
            console.log("REASON: " + reason);
            $scope.listarArchivosPorTipo = [];
        })
    }
});