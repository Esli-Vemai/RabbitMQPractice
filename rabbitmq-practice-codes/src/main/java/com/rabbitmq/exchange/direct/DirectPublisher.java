package com.rabbitmq.exchange.direct;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		String[] messages = { "This is Mobile", "This is Tv", "This is Ac" };
		for (int i = 0; i < messages.length; i++) {
			if (i == 0) {
				channel.basicPublish("direct-exchange", "mobile", null, messages[i].getBytes());
			}
			if (i == 1) {
				channel.basicPublish("direct-exchange", "tv", null, messages[i].getBytes());
			}
			if (i == 2) {
				channel.basicPublish("direct-exchange", "ac", null, messages[i].getBytes());
			}
		}
		channel.close();
		connection.close();
	}

}
