var express = require('express')
var router = express.Router()

router.use(function timeLog (req, res, next) {
  console.log("Handling Request - ", req.path)
  console.log("params ", req.params)

  next()
})

router.get('/', function(req, res) {
  console.log('GET all todos');
  res.send("todos - "+ req)
});

module.exports = router
