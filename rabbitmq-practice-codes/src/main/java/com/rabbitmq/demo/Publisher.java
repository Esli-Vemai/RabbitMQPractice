/**
 * 
 */
package com.rabbitmq.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author esliv
 *
 */
public class Publisher {

	/**
	 * Class that publishes the queue to the RabbbitMQ
	 * 
	 * @param args
	 */
	public static void publish() {
		final Logger LOG = LoggerFactory.getLogger(Publisher.class);
		try {
			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = factory.newConnection();
			LOG.debug("Connection established {} " + connection);
			Channel channel = connection.createChannel();
			LOG.debug("Channel established {} " + channel);
			String message = "Hello from my first RabbitMQ publisher";
			channel.basicPublish("", "queue-one", null, message.getBytes());
			LOG.debug("queue published {} " + message);
			channel.close();
			connection.close();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("TimeoutException");
			e.printStackTrace();
		} finally {

		}

	}
}
