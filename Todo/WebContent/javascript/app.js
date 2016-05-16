var app = angular.module("todoApp", []);

app.controller("loginController", function($scope, $http){
	var self = this;
	self.login = false;
	
	self.getUser = function(){


		var url = "rest/user/"+ $scope.email +"/"+ $scope.password;
		console.log(url);
		$http.get(url, null, null).then(function successCallback(response){
			console.log("in successCallback: ");
			console.log(response);
			if(response.status === 200){
				self.user = response.data;
				//console.log(user.email);
				self.login = true;
			}
		}, function errorCallback(response){
			console.log('in errorCallback: ');
			console.log(response);
		})
		};
	 
	 self.getPing = function(){
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

