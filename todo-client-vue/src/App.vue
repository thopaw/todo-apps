<template>
  <div id="app">
    <div class="boxed">
      <Todos/>
    </div>
  </div>
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
  border: 1px dotted #AAA;
  padding: 1em;
}
</style>
