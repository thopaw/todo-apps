var express = require('express')
var router = express.Router()

var todoService = require('../todo/service.js')
var Todo = require('../todo/Todo.js')

// Extract Todo, when ID is in path
router.param("todo_id", function(req, res, next, todo_id) {
  console.log("Param - Todo ID - "+todo_id)
  let todo = todoService.todo(todo_id)
  if(!todo) {
    console.log("No todo found with id " + todo_id)
    return res.status(404).json({
      id: todo_id,
      message: "todo not found"
    })
  }
  req.todo = todo
  return next()
})


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
    res.type('application/json')
    res.json(req.todo)
  })

  .put(function(req, res){
    req.todo.text = req.body.text
    req.todo.done = req.body.done
    todo.todoService.update(req.todo)
    res.status(200).send("Updated")
  })

  // Delete a Todo
  .delete(function(req, res) {
    if(todoService.delete(req.todo.id)) {
      res.send("deleted")
    } else {
      res.status(404).send("Not Found id: " + id);
    }
  })

module.exports = router
