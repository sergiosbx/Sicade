'use strict';
var cursoCtrl = function(NgTableParams, cursoSrv, toaster) {
    var vm = this;
    limparCadastro();

    vm.inserir = inserir;

    vm.tableParams = new NgTableParams({ count: 1 },
        {
            counts: [],
            getData: function(params) {
                return cursoSrv.listar(params).then(function(res) {
                    params.total(res.data.data.length);
                    return res.data.data;//TODO fazer limit offset no banco
                });
            }
        }
    );

    function inserir(cadastro) {
        cursoSrv.inserir(cadastro).then(function(res) {
            vm.tableParams.page(1);
            vm.tableParams.reload();
            limparCadastro();
        }, function(res) {
            toaster.pop('error', "Erro", res.data.erro);
        });
    }

    function limparCadastro() {
        vm.cadastro = {};
    }
};

cursoCtrl.$inject = ['NgTableParams', 'CursoSrv', 'toaster'];

app.controller('CursoCtrl', cursoCtrl);