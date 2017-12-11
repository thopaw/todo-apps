var Todo = require('./Todo.js')

let items = []
let id = 0

let service = {

  todos : function() {
    return items;
  },

  todo : function(id) {
    console.log("Request Todo ", id)
    var todo = items.filter((item) => item.id === Number(id))[0]
    return todo;
  },
  delete: function(id) {
    let length = items.length
    items = items.filter(item => item.id !== Number(id))
    return length > items.length
  },
  save: function(todo) {
    let newId = id++
    todo.id = newId
    items.push(todo)
    return newId
  },
  update: function(todo) {
    var todoRef = this.todo(todo.id)
    if(todoRef) {
      todoRef.text = todo.text
      todoRef.done = todo.done
    }
  }
}

service.save(new Todo({
  text: "Here is some text"
}))

service.save(new Todo({
  text: "2nd Todo text"
}))

service.save(new Todo({
  text: "3rd Todo - some text",
  done: true
}))

module.exports = service
