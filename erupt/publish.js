#!/usr/bin/env node
var amqp = require('amqplib/callback_api');
console.log('Initing.');
amqp.connect('amqp://amnan:amnan101@vps280126.ovh.net:5672', function(err, conn) {

	console.log('Connecting..');
	conn.createChannel(function (err, ch) {
		var q = 'girrafe';
		ch.assertQueue(q, {durable: false});
		console.log('Sending..');
		var i =0;
		while (i <=100000) {
			ch.sendToQueue(q, new Buffer('hellonatangcelakaberuk' + i));
			i++;
		}
		console.log("[x] Sent Q");
	});
	//setTimeout(function() { conn.close(); process.exit(0) }, 500);
});