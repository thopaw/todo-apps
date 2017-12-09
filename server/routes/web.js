var express = require('express')
var router = express.Router()

var todoService = require('../todo/service.js')

router.use(function timeLog (req, res, next) {
  console.log("Handling Request - ", req.path)
  console.log("params ", req.params)

  next()
})

router.get('/', function (req, res) {
  res.render('index',{
    'title': 'Todo App - NodeJS',
    'heading': 'Nodo Application with NodeJS'
  });
});

router.get('/todos', function (req, res) {
  res.render('todos',{
    'title': 'Todo App - NodeJS',
    'heading': 'Nodo Application with NodeJS',
    'todos': todoService.todos()
  });
});

router.get('/todos/:todo_id', function (req, res) {
  var todo_id = req.params.todo_id
  var todo = todoService.todo(todo_id)
  res.render('todo',{
    'title': 'Todo App - NodeJS',
    'heading': 'Todo - ID '+todo.id,
    'todo': todo
  });
});

module.exports = router
