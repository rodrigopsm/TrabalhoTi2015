module = angular.module("Disciplina",[]);

module.controller("DisciplinaController",["$scope","$http",DisciplinaController]);

function DisciplinaController($scope,$http){
    $scope.salvar = funcaoSalvar;
    $scope.excluir = funcaoExcluir;
    $scope.iniciar = iniciar;
    
    $scope.disciplinas =[];
    $scope.disciplina = {};
    
    function funcaoSalvar(disciplina){
        $http.post("/disciplinas",disciplina).success(sucesso).error(deuErrado);
        function sucesso(){
            alert("Salvou");
        }
        function deuErrado(){
            alert("deu errado");
        }      
    }
    
    function funcaoExcluir(disciplina){
        $http.delete("/disciplinas",disciplina).success(sucesso).error(deuErrado);
         function sucesso(){
            alert("Salvou");
        }
        function deuErrado(){
            alert("deu errado");
        }      
    }
    
    function carregar(){
        $http.get("/disciplinas").success(onSucess).error(onError);
        function onSuccess(data, status) {
            $scope.disciplinas = data;       
            console.log(data);
        }
        function onError(data, status) {
            alert("Deu erro: " + data);
        }
    }
    
    function iniciar(){
        carregar();
    }


}