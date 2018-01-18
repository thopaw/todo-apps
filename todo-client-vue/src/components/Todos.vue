<template lang="pug">
  .container
    h1 {{ heading }}
    .row
      .col-sm-6
        ul.list-group
          a.list-group-item(
            v-for="item in todos"
            v-on:click="show(item.id)"
            v-bind:class="{ active : isActive(item.id)}"
          )
            Todo(
              v-bind:todo="item"
            )
      .col-sm-6(v-if="showTodoForm()")
        TodoForm(
          v-bind:todo="selectedTodo()"
          v-on:cancel="cancel"
          v-on:save="save"
        )
    .row
      .col-sm-6
        button.btn(class="btn-info") New Todo

    .test
      button(
        class="btn btn-default"
        v-on:click="inc()"
      ) Test
      span
        = ' '
        | you clicked
        = ' '
        span(v-text="this.counter")
        = ' '
        | times
</template>

<script>

import Todo from './Todo'
import TodoForm from './TodoForm'

export default {
  name: 'Todos',
  props: ['heading'],
  components: {
    Todo, TodoForm
  },
  methods: {
    inc() {
      this.counter++
    },
    show(index) {
      this.todoIndex = -1;
      this.todoIndex = index
    },
    selectedTodo() {
      return this.todos.find(t => t.id === this.todoIndex)
    },
    isActive(id) {
      var active = id && this.selectedTodo() && this.selectedTodo().id === id
      return active
    },
    showTodoForm() {
      return this.selectedTodo() !== undefined
    },
    cancel(event) {
      this.todoIndex=-1
    },
    save(event) {
      alert("save - " + event.text)
    }
  },
  data:() => ({
      counter: 0,
      todoIndex: -1,
      todos: [
        {id: 1, text: "My first Todo", done: false},
        {id: 2, text: "Another Todo", done: true}
      ]
  })
}
</script>

<style scoped>
.test {
  border: 1px solid #CCC;
  margin-top: 1em;
  padding:1em;
}

</style>
