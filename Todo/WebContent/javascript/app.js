var app = angular.module("todoApp", []);

app.controller("loginController", function($scope, $http){
	
	
	var getUser = function(){
		var url = "/rest/user/"+ user.email +"/"+ user.password;
		console.log(user);
		$http.get(url).then(function(response){
		$scope.loginUser = response.data;
	});
	var getPing = function(){
		$http({
			method: "GET" ,
			url: "/rest/ping"
			}).then(function(response){
			console.log(response.data);
		}, function(response){
			console.log(response.error);
		})
	}
	}
	
});

