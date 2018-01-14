<template lang="pug">
  .container
    h1 Todos!
    ul.list-group
      li.list-group-item(v-for="item in todos")
        Todo(
          v-bind:todo="item"
          v-bind:key="item.id"
        )

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

export default {
  name: "Todos",
  components: {
    Todo
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
