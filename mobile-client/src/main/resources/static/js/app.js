angular.module('sso', [ 'ngRoute', 'ngResource' ]).config(
		function($routeProvider) {

			$routeProvider.otherwise('/');
			$routeProvider.when('/', {
				templateUrl : 'home.html',
				controller : 'home'
			}).when('/dashboard', {
				templateUrl : 'dashboard.html',
				controller : 'dashboard'
			}).when('/user', {
                templateUrl : 'user.html',
                controller : 'user'
            }).when('/logined', {
                templateUrl : 'logined.html',
                controller : 'logined'
            });

		}).controller('navigation', function($scope, $http, $window, $route) {
			$scope.tab = function(route) {
				return $route.current && route === $route.current.controller;
			};
			if (!$scope.user) {
				$http.get('/dashboard/user').success(function(data) {
					$scope.user = data;
					$scope.authenticated = true;
					$window.location.href = '#/logined';
				}).error(function() {
					$scope.authenticated = false;
				});
			}
			$scope.logout = function() {
				$http.post('/dashboard/logout', {}).success(function() {
					delete $scope.user;
					$scope.authenticated = false;
					// Force reload of home page to reset all state after logout
					$window.location.hash = '';
				});
		};
}).controller('home', function($scope, $window) {
}).controller('logined', function($scope, $window) {
}).controller('dashboard', function($scope, $http) {
    $http.get('/dashboard/item/all').success(function(data) {
		$scope.items = data;
	}).error(function(data, status) {
        alert('get data error!');
    });

}).controller('user', function($scope, $http) {
    $scope.userdetail = {
        // profileImg:'',
        email:'',
        nickName:'',
        gender:'',
        dob:'',
        phoneNum:'',
        aboutMe:''
    };
    var useremail = "";
    $http.get('/dashboard/user').success(function(data) {
    	$scope.user = data;
    	useremail = data.name;
    });
    $http.get('/dashboard/userdetail').success(function(detail) {
		$scope.userdetail = detail;
	});

    $scope.updateUserInfo = function(detail) {
    	var yes = confirm('update user detail ?');
    	if(yes){
    		detail.email = useremail;
            $http.post('/dashboard/updateUserdetail', detail).success(function(data) {
                if(data != null){
                    alert(data.status);
                }
            });
		}

    };
});

// jquery code,
// hidden hamburger manu
$('.nav a').on('click', function(){
    $('.btn-navbar').click(); //bootstrap 2.x
    $('.navbar-toggle').click() //bootstrap 3.x by Richard
});
// user detail info
// update user detail
