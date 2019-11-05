var P_server = require('./P_server');
var P_router = require('./P_router');
var P_handler = require('./P_handler');

var handle = {}
handle['/'] = P_handler.home;
handle['/home'] = P_handler.home;
handle['/review'] = P_handler.review;

P_server.startserver(P_router.route,handle);