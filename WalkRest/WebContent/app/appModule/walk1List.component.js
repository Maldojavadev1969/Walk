angular.module('appModule')
	.component('walk1List',{
		templateUrl : 'app/appModule/walk1List.component.html',
		controller : function(walk1Service){
			var vm = this
			
			vm.walks = [];
			
			var loadData = function(){
				walk1Service.index()
				.then(function(response){
					//console.log(response.data)
					vm.walks = response.data;
				})
			}
			
			//create data immeadiately when data gets loaded
			loadData();
			
			
			//get average distance of all walks	
			
			
			var getAvgDistance = function(){
			
				walk1Service.index()
				.then(function(response){
					//console.log(response.data)
					var arrayOfWalks = [];
					arrayOfWalks = response.data;
				
					var totalDist = 0;
					//for (var i = 0, len = arrayOfWalks.length; i < len; i++) {

					for (var i = 0; i < arrayOfWalks.length; i++) {
						  //console.log("Distance: " + arrayOfWalks[i].distance);
						  totalDist += arrayOfWalks[i].distance;
						  console.log(totalDist);
						}
					console.log(arrayOfWalks.length);
					var avgDistance = totalDist/arrayOfWalks.length;

					vm.getAvgDist = avgDistance;
					
					loadData();

					})
				
			}
			
			getAvgDistance();
			
	
			vm.hideWalk = false;
			
			vm.hidesWalks = function(){
				vm.hideWalk = true;
			}
			
			vm.showsWalks = function(){
				vm.hideWalk = false;
			}
			
			vm.updateWalk = function(id, walk){
				walk1Service.updateWalk(id, walk)
				.then(function(response){
					loadData();
				})
				.catch(function(){
	    			console.log("cant access database")
	    		})
			}
			

			vm.createWalk1 = function(Walk){
	    		walk1Service.create(Walk)
	    		.then(function(response){
	    			loadData();
	    		})
	    		.catch(function(){
	    			console.log("cant access database")
	    		})
	    }
			
			
			//delete function:
			vm.deleteWalk1 = function(id){
				walk1Service.destroy(id).then(function(){
					loadData();

				})
			}
			
		},
	  
		
		controllerAs : "vm"
	})