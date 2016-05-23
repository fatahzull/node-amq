#!/usr/bin/env node
var amqp = require('amqplib/callback_api');
amqp.connect('amqp://amnan:amnan101@vps280126.ovh.net:5672', function(err, conn) {
	conn.createChannel(function (err, ch) {
		var q = "wassap";
		ch.assertQueue(q, {durable: true});
		ch.consume(q, function (msg) {
			var secs = msg.content.toString().split('.').length -1;
			console.log("[MSG] %s" , msg.content.toString());
			setTimeout(function (){
				console.log("[x] ACKSent" + msg.content.toString());
				ch.ack(msg);
			}, 30000 );
		})
	})
})