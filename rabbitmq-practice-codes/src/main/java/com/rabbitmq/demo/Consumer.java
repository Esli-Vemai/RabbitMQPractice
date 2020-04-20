package com.rabbitmq.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

	public static String consume() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// var Connection = factory.newConnection();

		// DeliverCallback deliveryCallback = (consumerTag, delivery) -> {};
		DeliverCallback deliveryCallback = (consumerTag, delivery) -> {
			String messageBody = new String(delivery.getBody());
			System.out.println("** consumerTag: " + consumerTag);
			System.out.println("Message received: " + messageBody);
		};

		// CancelCallback cancelCallback = consumerTag ->
		// System.out.println(consumerTag);
		CancelCallback cancelCallback = (consumerTag) -> {
			System.out.println(">> consumerTag: " + consumerTag);
		};
		
		return channel.basicConsume("queue-one", true, deliveryCallback, cancelCallback);
		//return channel.basicConsume("queue-one", true, (consumerTag, delivery) -> {} , consumerTag -> {});
		
	}
}
