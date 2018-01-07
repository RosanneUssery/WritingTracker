angular.module('appModule')
	.component('wordCount', {
		templateUrl : 'app/appModule/wordCounter/word.component.html',
		controller : function (wordService) {
			var vm = this;
			
			vm.selected = null;
			
			vm.editStory = null;
			
			vm.story = []
			
			var reload = function() {
				wordService.index()
				.then(function(response) {
					vm.story = response.data;
				}) 
				.catch(console.error)

			}
			reload();
			
			vm.addStory = function(story) {
				wordService.create(story)
				.then(function(response){
					reload()
				})
				.catch(console.error)
			}
			
			vm.destoyStory = function(story) {
				wordService.destroy(story)
				.then(function(response){
					reload()
				})
				.catch(console.error)
			}
			
			vm.updateStory = function(story) {
				wordService.update(story)
				.then(function(response){
					reload()
				})
				.catch(console.error)
			}
			
			vm.setEditStory= function() {
	                vm.editStory = vm.selected;
	        }
	        
	        vm.displayTable = function() {
	            vm.selected = null;
	        }
	        
	        vm.displayStory= function(story) {
	                vm.selected = story;
	        }
			
		},
		controllerAs : "vm"
	})