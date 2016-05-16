var app = angular.module("todoApp", []);

app.controller("loginController", function($scope, $http){
	var self = this;
	
	this.getUser = function(){
		// console.log($scope.email);
		// console.log($scope.password);
		var url = "rest/user/"+ $scope.email +"/"+ $scope.password;
		console.log(url);
		$http.get(url, null, null).then(function successCallback(response){
			console.log("in successCallback: ");
			console.log(response);
			if(response.status === 200){
				self.user = response.data;
				//console.log(user.email);
			}
		}, function errorCallback(response){
			console.log('in errorCallback: ');
			console.log(response);
		})
		};
	 this.getPing = function(){
	 // 	console.log("in getPing");
		// var xhr =  new XMLHttpRequest();
		// xhr.open('GET','rest/ping');
		// xhr.onreadystatechange = function(){
		// 	if(xhr.readyState == 4 && xhr.status < 400){
		// 		console.log(xhr.responseText);
		// 	}
		// };
		// xhr.send(null);
		$http.get('rest/user/shelbyescobedo@gmail.com/banana', null, null).then(function successCallback(response) {
            console.log("in successCallback: ");
            console.log(response);
            if(response.status === 200){
            	console.log(response.data);
            }
            
		}, function errorCallback(response){
			console.log("in error call back ");
			console.log(response);
		});

	};
	});

