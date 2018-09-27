'use strict'
var app = angular.module('ngApp', [
    'ui.bootstrap',
    'demo.controllers',
    'demo.services',
    'ui.router',
    'ngTable',
    'toaster',
    'uiSwitch',
    'ngMask'
]);

app.config(function($stateProvider, $urlRouterProvider) {
    //$urlRouterProvider.when('/dashboard', '/dashboard/overview');
    $urlRouterProvider.otherwise('/login');

    $stateProvider
        .state('base', {
            abstract: true,
            url: '',
            templateUrl: 'views/base.html'
        })
        .state('login', {
            url: '/login',
            templateUrl: 'views/pages/login.html',
            controller: 'LoginCtrl'
        })
        .state('dashboard', {
            url: '/dashboard',
            parent: 'base',
            templateUrl: 'views/pages/dashboard.html',
            controller: 'DashboardCtrl'
        })
        .state('curso', {
            url: '/curso',
            parent: 'base',
            templateUrl: 'views/pages/curso.html',
            controller: 'CursoCtrl',
            controllerAs: 'vm'
        })
        .state('aluno', {
            url: '/aluno',
            parent: 'base',
            templateUrl: 'views/pages/aluno.html',
            controller: 'AlunoCtrl',
            controllerAs: 'vm'
        })
        .state('integracao', {
            url: '/integracao',
            parent: 'base',
            templateUrl: 'views/pages/integracao.html',
            controller: 'IntegracaoCtrl'
        });
});

app.constant("CONSTANTS", {
    aluno: {
        baseUrl: "/api/aluno"
    },
    curso: {
        baseUrl: "/api/curso",
        areasDeConhecimento: {
            lista: [
                { cod: 'CIENCIAS_EXATAS_TERRA', descricao: 'Ciências Exatas e da Terra' },
                { cod: 'CIENCIAS_BIOLOGICAS', descricao: 'Ciências Biológicas' },
                { cod: 'ENGENHARIA_TECNOLOGIA', descricao: 'Engenharia / Tecnologia' },
                { cod: 'CIENCIAS_SAUDE', descricao: 'Ciências da Saúde' },
                { cod: 'CIENCIAS_AGRARIAS', descricao: 'Ciências Agrárias' },
                { cod: 'CIENCIAS_SOCIAIS', descricao: 'Ciências Sociais' },
                { cod: 'CIENCIAS_HUMANAS', descricao: 'Ciências Humanas' },
                { cod: 'CIENCIAS_LINGUISTICA', descricao: 'Lingüística' },
                { cod: 'LETRAS_ARTES', descricao: 'Letras e Artes' }
            ],
            get: function(cod) {
                return this.lista.filter(function(l) { return l.cod === cod })[0];
            }
        }
    }
});

app.directive('jqdatepicker', function ($filter) {
    return {
        restrict: 'A',
        require: 'ngModel',
         link: function (scope, element, attrs, ngModelCtrl) {
            element.datepicker({
                dateFormat: 'dd/mm/yy',
                onSelect: function (date) {   
                    var ar=date.split("/");
                    date=new Date(ar[2]+"-"+ar[1]+"-"+ar[0]);
                    ngModelCtrl.$setViewValue(date.getTime());            
                    scope.$apply();
                }
            });
            ngModelCtrl.$formatters.unshift(function(v) {
            return $filter('date')(v,'dd/MM/yyyy'); 
            });

        }
    };
});