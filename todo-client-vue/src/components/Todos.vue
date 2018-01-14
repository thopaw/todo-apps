<template>
  <div class="container">
    <h1>Todos</h1>
    <ul class="list-group">
      <li class="list-group-item"
        v-for="item in todos">
        <Todo
          v-bind:todo="item"
          v-bind:key="item.id"/>
      </li>
    </ul>
    <div class="panel panel-primary">
        <div class="panel-body">
            <p>Some text</p>
        </div>
    </div>
  </div>

</template>

<script>
import Todo from './Todo'

export default {
  name: "Todos",
  components: {
    Todo
  },
  data: function ()  {
    return {
      todos: [
        {id: 1, text: "My first Todo", done: false},
        {id: 2, text: "Another Todo", done: false}
      ]
    }
  }
}
</script>

<style scoped>

</style>
