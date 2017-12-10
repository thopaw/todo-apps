var express = require('express');
var app = express();

var webRoutes = require('./routes/web.js')
var apiRoutes = require('./routes/api.js')

var bodyParser = require('body-parser');

var morgan     = require('morgan');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(morgan('dev'));

var port = process.env.PORT || 8000

app.set('view engine', 'pug')
app.set('views', './server/views/')

// static routes
app.use(express.static(__dirname + '/../node_modules/bootstrap/dist'))
app.use(express.static(__dirname + '/../node_modules/jquery/dist'))
app.use(express.static(__dirname + '/public/'))



app.use('/', webRoutes)
app.use('/api', apiRoutes)

app.listen(port, function () {
  console.log('todo app listening on port ' + port);
});
