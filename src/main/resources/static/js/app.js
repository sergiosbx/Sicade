'use strict'
var app = angular.module('ngApp', [
    'ui.bootstrap',
    'demo.controllers',
    'demo.services',
    'ui.router',
    'ngTable',
    'toaster'
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
        baseUrl: "/api/curso"
    }
});