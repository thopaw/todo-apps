var express = require('express')
var router = express.Router()

var todoService = require('../todo/service.js')
var Todo = require('../todo/Todo.js')

router.use(function timeLog (req, res, next) {
  console.log(req.method+ " - "+ req.originalUrl);
  next();
});


router.route('/todos')

  // Get all todos
  .get(function(req, res) {
    let todos = todoService.todos()
    res.type('application/json')
    res.json(todos)
  })

  //  Post a new Todo
  .post(function(req, res) {
    var todo = new Todo({
      text: req.body.text,
      done: req.body.done
    })
    var newId = todoService.save(todo)
    var loc = req.originalUrl.replace(/\/?$/, '/')+newId
    res
      .status(201)
      .location(loc)
      .send("created - "+loc)
  });

router.route('/todos/:todo_id')

  // Get a specific todo
  .get(function(req, res) {
    let id = req.params.todo_id;
    let todo = todoService.todo(id);
    if(todo) {
      res.type('application/json')
      res.json(todo)
    } else {
      res.status(404).send("Not Found id: " + id);
    }
  })

  // Delete a Todo
  .delete(function(req, res) {
    let id = req.params.todo_id;
    if(todoService.delete(id)) {
      res.send("deleted")
    } else {
      res.status(404).send("Not Found id: " + id);
    }
  })

module.exports = router
