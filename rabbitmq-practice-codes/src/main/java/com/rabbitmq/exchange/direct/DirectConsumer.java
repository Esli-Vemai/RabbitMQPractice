package com.rabbitmq.exchange.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectConsumer {

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection;
		Channel channel;
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.basicConsume("Mobile", true, (consumertag, message) -> { 
				String msg = new String(message.getBody());
				System.out.println("message: " + msg);
			}, consumertag -> {});
			
			channel.basicConsume("Tv", true, (consumertag, message) -> { 
				String msg = new String(message.getBody());
				System.out.println("message: " + msg);
			}, consumertag -> {});
			
			channel.basicConsume("Ac", true, (consumertag, message) -> { 
				String msg = new String(message.getBody());
				System.out.println("message: " + msg);
			}, consumertag -> {});
			
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
