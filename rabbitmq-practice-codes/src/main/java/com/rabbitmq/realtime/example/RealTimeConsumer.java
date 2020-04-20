package com.rabbitmq.realtime.example;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RealTimeConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection("Realtime-connection");
		Channel channel = connection.createChannel();
		//JSONObject jsonString = new JSONObject();
		DeliverCallback deliveryCallback = (consumerTag, message) -> {
			String json = new String(message.getBody());
			JSONObject jsonString = new JSONObject(json);
			System.out.println("DB Query: " + jsonString.get("query"));
			System.out.println("message: " + json);
		};
		channel.basicConsume("realtime-example", true, deliveryCallback, customerTag -> {});
		/*
		 * channel.close(); 
		 * connection.close();
		 */
	}

}
