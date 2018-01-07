<h1>NgTodo : <span class="todo-count-label"><em>{{vm.countTodos()}}</em></span></h1>

<form ng-hide="vm.selected">
    <input type="text" ng-model="todo.task" placeholder="New Task" />
    <input type="submit" value="Add Todo" ng-click="vm.addTodo(todo); todo = {};" />
</form>

<table ng-hide="vm.selected">
    <thead>
        <tr>
            <th>Task</th>
            <th>Mark</th>
            <th>Completed</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="todo in vm.todos">
            <td ng-click="vm.displayTodo(todo)">{{todo.task}}</td>
            <td>
                <input type="checkbox" ng-model="todo.completed" />
            </td>
            <td>{{todo.completed}}</td>
        </tr>
    </tbody>
</table>

<div ng-show="vm.selected && !vm.editTodo">
    <div>Id : {{vm.selected.id}}</div>
    <div>Task : {{vm.selected.task}}</div>
    <div>Desc : {{vm.selected.description}}</div>
    <div>Comp : {{vm.selected.completed}}</div>
    <button ng-click="vm.setEditTodo()">Edit</button>
    
    <button ng-click="vm.displayTable()">Go Back</button>
</div>


<form ng-show="vm.editTodo">
    Task : <input type="text" ng-model="vm.editTodo.task" placeholder="Task" /><br />
    Desc : <input type="text" ng-model="vm.editTodo.description" placeholder="Description" /><br />
    Completed : <input type="checkbox" ng-model="vm.editTodo.completed" /><br />
    <input type="submit" value="Cancel" ng-click="vm.editTodo = null" /><br />
    <input type="submit" value="Save" ng-click="vm.updateTodo(vm.editTodo)" />
</form>
```


[3:12] 
 ```angular.module('appModule')
.component('todoList', {
    templateUrl : 'app/appModule/todoList/todoList.component.html',
    controller : function() {
        var vm = this;
        
        vm.selected = null;
        
        vm.editTodo = null;

        vm.todos = [
            {
              id : 1,
              task : 'Go round mums',
              description : '',
              completed : true
            },
            {
              id : 2,
              task : 'Get Liz back',
              description : '',
              completed : false
            },
            {
              id : 3,
              task : 'Sort life out',
              description : '',
              completed :  false
            }
          ];
        
        vm.updateTodo = function(edittedTodo) {
                vm.todos.forEach(function(todo, idx, array) {
                    if (todo.id === edittedTodo.id) {
                        array.splice(idx, 1, edittedTodo);
                    }
                });
                vm.selected = vm.editTodo; 
                vm.editTodo = null;
        }
        
        vm.setEditTodo = function() {
                vm.editTodo = angular.copy(vm.selected);
        }
        
        vm.displayTable = function() {
            vm.selected = null;
        }
        
        vm.displayTodo = function(todo) {
                vm.selected = todo;
        }
        
        var generateId = function() {
            return vm.todos[vm.todos.length-1].id + 1;
        }
        
        vm.countTodos = function() {
            return vm.todos.length;
        }
        
        vm.addTodo = function(todo) {
            console.log(todo);
            var todo = angular.copy(todo);
            todo.id = generateId();
            todo.description = '';
            todo.completed = false;
            
            vm.todos.push(todo);
        }
        
    },
    controllerAs : 'vm'
});```