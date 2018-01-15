<template lang="pug">
  #app
    .boxed
      Todos(:heading="'Todo App with Vue.js!'")
</template>

<script>
import Todos from './components/Todos'

export default {
  name: 'App',
  components: {
    Todos
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
.boxed {
  border: 3px dotted #AAA;
  margin: 1em;
  padding: 1em;
}
</style>
