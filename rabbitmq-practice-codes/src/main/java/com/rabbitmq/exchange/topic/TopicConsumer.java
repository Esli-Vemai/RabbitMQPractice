package com.rabbitmq.exchange.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class TopicConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		DeliverCallback deliverCallback = (consumer, message) -> {
			String string = new String(message.getBody());
			System.out.println("message: " + string);
		}; 

		channel.basicConsume("Mobile", true, deliverCallback, consumer -> {});
		channel.basicConsume("Tv", true, deliverCallback, consumer -> {});
		channel.basicConsume("Ac", true, deliverCallback, consumer -> {});

	}

}
