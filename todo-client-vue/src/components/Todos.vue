<template lang="pug">
  .container
    h1 {{ heading }}
    ul.list-group
      li.list-group-item(v-for="item in todos")
        Todo(
          v-bind:todo="item"
          v-bind:key="item.id"
        )

    TodoForm

    button(
      class="btn btn-default"
      v-on:click="inc()"
    ) Test

    |

    span
      |  you clicked
      |
      span(v-text="this.counter")
      |  times

</template>

<script>

import Todo from './Todo'
import TodoForm from './TodoForm'

export default {
  name: 'Todos',
  props: ['heading'],
  components: {
    Todo,TodoForm
  },
  methods: {
    inc: function() {
      this.counter++
    }
  },
  data: () => ({
      counter: 0,
      todos: [
        {id: 1, text: "My first Todo", done: false},
        {id: 2, text: "Another Todo", done: false}
      ]
  })
}
</script>

<style scoped>

</style>
