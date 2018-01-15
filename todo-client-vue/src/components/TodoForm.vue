<template lang="pug">
div.todo-form
  h1(v-text="this.heading")
  form
    .form-group
      label(for=text) Todo
      input.form-control(type=text name=text placeholder="Text of todo")
    .form-check
      input.form-check-input(type="checkbox" name="done")
      label.form-check-label(for="done") Done
    .text-right
      button.btn(class="btn-default") Clear
      button.btn(class="btn-primary") Save

</template>

<script>
export default {
  name: "TodoForm",
  props: ['todo'],
  data: () => ({
    heading: "Create new Todo"
  })
}
</script>

<style scoped>

div.todo-form {
  border: 1px solid #EEE;
  padding:1em;
  margin-bottom: 1em;
}

h1 {
  font-size: x-large
}
.btn {
  margin-left: 0.5em;
}
</style>
