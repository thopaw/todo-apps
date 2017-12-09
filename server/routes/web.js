var express = require('express')
var router = express.Router()

var todoService = require('../todo/service.js')

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

router.route('/todos/:todo_id')

  // Gets the form of an Todo
  .get(function (req, res) {
    var todo_id = req.params.todo_id
    var todo = todoService.todo(todo_id)
    res.render('todo',{
      'title': 'Todo App - NodeJS',
      'heading': 'Todo - ID '+todo.id,
      'todo': todo
    });
  })

  // Edits a Todo
  .post(function(req, res) {
    var todo_id = req.params.todo_id
    var todo = todoService.todo(todo_id)
    console.log("Body", req.body)
    todo.text = req.body.text
    todo.done = req.body.done === "on"
    todoService.update(todo)
    res.redirect("/todos")
  })

module.exports = router
