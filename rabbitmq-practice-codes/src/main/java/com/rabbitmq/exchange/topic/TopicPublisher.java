package com.rabbitmq.exchange.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		String message = "Topic Mobile, Topic Tv, Topic Ac";
		//String[] messages = message.split(",");
		channel.basicPublish("topic-exchange", "tv.mobile.ac", null, message.getBytes());
		channel.close();
		connection.close();

	}

}
