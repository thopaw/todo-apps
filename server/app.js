var express = require('express');
var app = express();

var todoRoutes = require('./routes/todo.js')
var todoService = require('./todo/service.js')

var port = process.env.PORT || 8000

// if(process.env.DEBUG_LIVE_RELOAD) {
//   console.log("Starting Livereload Server")
//   var livereload = require('./debug/livereload.js')
// }

app.set('view engine', 'pug')
app.set('views', './server/views/')

// static routes
app.use(express.static(__dirname + '/../node_modules/bootstrap/dist'))
app.use(express.static(__dirname + '/../node_modules/jquery/dist'))
app.use(express.static(__dirname + '/public/'))

app.get('/', function (req, res) {
  res.render('index',{
    'title': 'Todo App - NodeJS',
    'heading': 'Nodo Application with NodeJS'
  });
});

app.get('/todos', function (req, res) {
  res.render('todos',{
    'title': 'Todo App - NodeJS',
    'heading': 'Nodo Application with NodeJS',
    'todos': todoService.todos()
  });
});

app.use('/api/todos', todoRoutes)

app.listen(port, function () {
  console.log('todo app listening on port ' + port);
});
