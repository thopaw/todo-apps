<template>
  <div>
    Text: {{ todo.text }}
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
