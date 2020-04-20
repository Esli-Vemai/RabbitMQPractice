package com.rabbitmq.exchange.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class FanoutConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		DeliverCallback deliverCallback = (consumer, message) -> {
			String string = new String(message.getBody());
			System.out.println("message: " + string);
		}; 
		CancelCallback cancelCallback = consumer -> {
			String consumerTag = new String(consumer.getBytes());
			System.out.println("consumerTag: " + consumerTag);
		};
		channel.basicConsume("Mobile", true, deliverCallback, cancelCallback);
	}

}
