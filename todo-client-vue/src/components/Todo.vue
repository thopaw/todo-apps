<template lang="pug">
  div
    span.done(v-if="todo.done")
      | Todo
      = ' '
      span(v-text="todo.id")
      = ': '
      span(v-text="todo.text")
    span.not-done(v-if="!todo.done")
      | Todo
      = ' '
      span(v-text="todo.id")
      = ': '
      span(v-text="todo.text")
</template>

<script>
export default {
  name: 'todo',
  props: {
    todo: {
      default:{},
      type: Object
    }
  }
}
</script>

<style scoped>
.done {
  text-decoration: line-through;
  font-style: italic;
}
.not-done {
  font-weight: bold;
}
</style>
