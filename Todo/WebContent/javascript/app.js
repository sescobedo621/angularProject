var app = angular.module("todoApp", []);

app.controller("loginController", function($scope, $http){
	
	
	var getUser = function(){
		var url = "/rest/user/"+ user.email +"/"+ user.password;
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
		$http.get('rest/ping', null, null).then(function successCallback(response) {
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

