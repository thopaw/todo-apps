<template lang="pug">
.panel(class="panel-primary")
  .panel-heading
      h1 Change
        span.heading(v-text="todo.text")
  .panel-body
    div.form
      .form-group
        label(for=text) Todo #
          span(v-text="todo.id")
        input.form-control(type=text name=text placeholder="Text of todo" v-model="todo.text")
      .form-check
        input.form-check-input(type="checkbox" name="done" v-model="todo.done")
        label.form-check-label(for="done") Done
      .text-right
        button.btn(class="btn-default" v-on:click="cancel()") Cancel
        button.btn(class="btn-primary" v-on:click="save()") Save

</template>

<script>
export default {
  name: 'TodoForm',
  created() {
    alert("Created")
    this._todo = JSON.parse(JSON.stringify(this.todo))
  },
  props: {
    todo: {

    },
    heading: {
      default: 'New Todo',
      type: String
    }
  },
  methods: {
    cancel() {
      this.$emit('cancel')
    },
    save() {
      this.$emit('save', this.todo)
    }
  },
  data: () => ({
    _todo: {}
  })
}
</script>

<style scoped>
span.heading {
  margin-left:0.2em;
  letter-spacing: -2px;
  text-shadow: 2px 2px #AAA;
}
span.heading::before {
  content:"\"";
}
span.heading::after {
  content:"\"";
}
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
