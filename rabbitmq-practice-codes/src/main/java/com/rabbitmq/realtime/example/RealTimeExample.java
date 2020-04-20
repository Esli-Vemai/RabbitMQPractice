package com.rabbitmq.realtime.example;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RealTimeExample {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		JSONObject json = new JSONObject();
		json.put("from-date", "02-03-2020");
		json.put("to_date", "12-07-2020");
		json.put("email", "json@gmail.com");
		json.put("query", "select * from db");
		json.put("producer", "RealTimeExample");
		channel.basicPublish("", "realtime-example", null, json.toString().getBytes());
		channel.close();
		connection.close();

	}

}
