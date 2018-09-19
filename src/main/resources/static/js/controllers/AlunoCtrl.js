'use strict';
var alunoCtrl = function(NgTableParams, alunoSrv) {
    var vm = this;
    vm.cadastro = {};
    
    vm.tableParams = new NgTableParams({},
        {
            getData: function(params) {
                return alunoSrv.listar(params).then(function(res) {
                    return {nome: res.data};
                });
            }
        }
    );
    
    function listar() {

    }
};

alunoCtrl.$inject = ['NgTableParams', 'AlunoSrv'];

app.controller('AlunoCtrl', alunoCtrl);