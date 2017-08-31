angular.module('appModule')
.factory('walk1Service', function($http){
 var service = {};
 
 var BASE_URL = 'api/walks/';
 
 // need to get all walks distance and get average walk distance
 service.index = function(){
	 
	 var avgDistWalked = "";
	 
	 
	 
	 return $http({
		 method : "GET",
		 url : BASE_URL
	 })
 }

service.index = function(){
	return $http({
		method : 'GET',
		url : BASE_URL 
	}) 	
	
};

service.updateWalk = function(id, Walk){
	return $http({
		method : 'PUT',
		url : BASE_URL + `${id}`,
		headers : {
	        'Content-Type' : 'application/json',
	      },
	      data : Walk
		})
}


service.create = function(Walk) {
	//return promise
    return $http({
      method : 'POST',
      url : BASE_URL,
      headers : {
        'Content-Type' : 'application/json',
      },
      data : Walk
    })
  };
  
  // delete method
  service.destroy = function(id) {
	    return $http({
	      method : 'DELETE',
	      url : BASE_URL + `${id}`
	    })
	  };
  
  
	return service;
})