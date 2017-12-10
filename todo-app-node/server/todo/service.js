var Todo = require('./Todo.js')

let items = [
  new Todo({
      id: 1,
      text: "Here is some text",
      done: false
  }),
  new Todo({
    id: 2,
    text: "2nd Todo text",
    done: true
  }),
  new Todo({
    id: 3,
    text: "3rd Todo - some text",
    done: false
  })
]

module.exports = {

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
    let ids = items.map(it => it.id)
    let newId = Math.max(...ids) + 1
    todo.id = newId
    items.push(todo)
    return newId
  },
  update: function(todo) {
    var todoRef = this.todo(todo.id)
    todoRef.text = todo.text
    todoRef.done = todo.done
  }
}
