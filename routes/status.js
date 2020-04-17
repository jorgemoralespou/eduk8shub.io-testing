var express    = require('express');

var router = express.Router();

router.get('/', function(req, res){
  res.json({'status': 'ok', 'hostname': 'localhost', 'port': '8080' })
});

//export this router to use in our index.js
module.exports = router;