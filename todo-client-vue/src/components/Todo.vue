<template>
  <div>
    Todo <span v-text="todo.id">id</span>: {{ todo.text }}
  </div>
</template>

<script>
export default {
  name: 'todo',
  props: ['todo']
}
</script>

<style scoped>

</style>
