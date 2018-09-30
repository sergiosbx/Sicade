'use strict'
var app = angular.module('ngApp', [
    'ui.bootstrap',
    'ui.router',
    'ngTable',
    'toaster',
    'uiSwitch',
    'ngMask',
    'angularCharts'
]);

app.config(function($stateProvider, $urlRouterProvider) {
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
            controller: 'DashboardCtrl',
            controllerAs: 'vm'
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
            controller: 'IntegracaoCtrl',
            controllerAs: 'vm'
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
    },
    integracao: {
        baseUrl: "/api/integracao"
    },
    resultado: {
        baseUrl: "/api/resultado"
    },
});