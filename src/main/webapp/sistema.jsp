<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shortener</title>

<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js">
	
</script>

<script type="text/javascript">
	var app = angular.module('myapp', []);

	app.controller('myappcontroller', function($scope, $http) {
		$scope.urls = []

		$scope.urlform = {
				idUrl:'',
				alias:'',
				urlNormal:'',
				urlCurta:''
			};

		getUrlList();

		function getUrlList() {
			$http({
				method : 'GET',
				url : 'listUrls'
			}).then(function successCallback(response) {
				$scope.urls = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}

		$scope.processUrl = function() {
			let m = '';
			let u = '';
			let id = $scope.urlform.idUrl;
			if(id==""){
				m = 'POST';
				u = 'url';
			} else {
				m = 'PUT';
				u ='updateUrl';
			}
			$http({
				method : m,
				url : u,
				data : angular.toJson($scope.urlform),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getUrlList(), clearForm()).success(function(data) {
				$scope.urls = data
			});
		}
		$scope.editUrl = function(url) {
			$scope.urlform.idUrl = url.idUrl;
			$scope.urlform.alias = url.alias;
			$scope.urlform.urlNormal = url.urlNormal;
			$scope.urlform.urlCurta = url.urlCurta;
		}
		$scope.deleteUser = function(user) {
			$http({
				method : 'DELETE',
				url : 'deleteuser',
				data : angular.toJson(user),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getUrlList()).success(function(data) {
				$scope.urls = data
			});;
		}
		
		

		function clearForm() {
			//$scope.urlform = "";
			$scope.urlform.idUrl = '';
			$scope.urlform.alias = '';
			$scope.urlform.urlNormal = '';
			$scope.urlform.urlCurta = '';
		}
		
	});
</script>

	<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-app="myapp" ng-controller="myappcontroller">
 
 <h3>Url Shortener</h3>
   <form ng-submit="processUserDetails()">
    <div class="table-responsive">
      <table class="table table-bordered" style="width: 600px">
        <tr>
          <td>Url</td>
          <td><input type="text" id="urlNormal" ng-model="urlform.urlNormal" size="30" /></td>
        </tr>
       
       <tr>
          <td colspan="2"><input type="submit"
            class="btn btn-primary btn-sm" ng-click="processUrl()"
            value="Create / Update Url" /></td>
       </tr>
     </table>
   </div>
 </form>
 
 <h3>Url list</h3>
   <div class="table-responsive">
     <table class="table table-bordered" style="width: 600px">
       <tr>
         <th>Normal Url</th>
         <th>Short Url</th>
         <th>Actions</th>
      </tr>

      <tr ng-repeat="u in urls">
        <td><span ng-bind="u.urlNormal"></span></td>
        <td><span ng-bind="u.urlCurta"></span></td>
        <td><a ng-click="editUrl(u)" class="btn btn-primary btn-sm">Edit</a>
           | <a ng-click="deleteUser(u)" class="btn btn-danger btn-sm">Delete</a></td>
      </tr>
    </table>
  </div>
</body>
</html>