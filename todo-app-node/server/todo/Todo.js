module.exports = function(values) {

  var todo = {}

  todo.id = values.id
  todo.text = values.text
  todo.done = values.done;

  return todo
}
