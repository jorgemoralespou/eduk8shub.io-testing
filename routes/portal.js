var express = require('express');
var rootCas = require('ssl-root-cas/latest').create();
var http    = require('https').globalAgent.options.ca = rootCas;

var router = express.Router();

var backend = "https://lab-markdown-sample.training.failk8s.dev";
var environments = "/workshops/catalog/environments/";

router.get('/environments', function(req, res){
    http.get(backend + environments, (res) => {
        console.log('statusCode:', res.statusCode);
        console.log('headers:', res.headers);
      
        res.on('data', (d) => {
          process.stdout.write(d);
        });
      
      }).on('error', (e) => {
        console.error(e);
      });
//  req.pipe(request[req.method.toLowerCase()](backend + environments)).pipe(res);
  res.json({'status': 'ok', 'hostname': 'localhost', 'port': '8080' })
});

//export this router to use in our index.js
module.exports = router;