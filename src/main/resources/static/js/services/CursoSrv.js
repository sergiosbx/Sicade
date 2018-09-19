'use strict';

var cursoSrv = function($http, CONSTANTS) {
    var CONSTANTE_CURSO = CONSTANTS.curso;

    return {
        inserir: function(params) {
            return $http.post(CONSTANTE_CURSO.baseUrl, params);
        },
        listar: function(params) {
            return $http.get(CONSTANTE_CURSO.baseUrl, params);
        }
    }
};

cursoSrv.$inject = ['$http', 'CONSTANTS'];

app.service('CursoSrv', cursoSrv);