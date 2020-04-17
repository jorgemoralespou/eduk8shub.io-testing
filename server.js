'use strict';

var express = require('express');
var rootCas = require('ssl-root-cas/latest').create();
var http    = require('https').globalAgent.options.ca;

var app = express();

var portal  = require('./routes/portal.js');
var status  = require('./routes/status.js');

// Simple request time logger
app.use(function(req, res, next){
  console.log("Requested: " + req.path);
  next();
});

// Status page
app.use('/portal', portal);
// Status page
app.use('/status', status);
// Static site
app.all('*', express.static(__dirname + '/site/public/'));

// // Anything else
// app.get('*', function(req, res){
//   res.send('Sorry, this URL is not defined');
// });


app.listen(8080, "localhost", function () {
//  console.log( 'Listening on ' + config.get('IP') + ', port ' + config.get('PORT') )
//  console.log( config.get('path_info') );
//if( !backend_host ){
//    console.error(config.get('backend_config_error'));
//  }else{
//    console.log(config.get('backend_config_info'));
//  }
});