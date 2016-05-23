#!/usr/bin/env node
var amqp = require('amqplib/callback_api');
amqp.connect('amqp://amnan:amnan101@vps280126.ovh.net:5672', function(err, conn) {
	conn.createChannel(function (err, ch) {
		var q = "girrafe";
		ch.assertQueue(q, {durable: false});
		ch.consume(q, function (msg) {
			console.log("[MSG] %s" , msg.content.toString());
		}, {noAck:true})
	})
})