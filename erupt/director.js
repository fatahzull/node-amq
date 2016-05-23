#!/usr/bin/env node
var amqp = require('amqplib/callback_api');
console.log('Initing.');
amqp.connect('amqp://amnan:amnan101@vps280126.ovh.net:5672', function(err, conn) {

	console.log('Connecting..');
	conn.createChannel(function (err, ch) {
		var q = 'wassap';
		ch.assertQueue(q, {durable: true});
		console.log('Sending..');
		var i =0;
		var msg = process.argv.slice(2).join(' ') || "Hello world";

		setTimeout(function (){
			while (i <=10) {
				ch.sendToQueue(q, new Buffer(msg +" " +i), {persistent: true});
				i++;
				console.log("con..");
			}
		}, 1000)
		console.log("[x] Sent Q");
	});
	setTimeout(function() { conn.close(); process.exit(0) }, 10500);
});