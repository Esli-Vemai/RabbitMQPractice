package com.rabbitmq.exchange.header;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class HeaderPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "Message for Mobile and Ac";
		var headerMap = new HashMap<String, Object>();
		//HashMap<String, Object> headerMap = new HashMap<>();
		headerMap.put("item1", "mobile");
		headerMap.put("item2", "air-conditioner");
		BasicProperties bprops = new BasicProperties();
		bprops = bprops.builder().headers(headerMap).build();
		

		bprops.getHeaders().forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
		/* var maps = bprops.getHeaders();
		 * Set<Entry<String, Object>> entry = maps.entrySet(); for (Entry<String,
		 * Object> entry2 : entry) { System.out.println(entry2.getKey() + ": " +
		 * entry2.getValue()); }
		 */
		
		channel.basicPublish("headers-exchange", "", bprops, message.getBytes());
		
		channel.close();
		connection.close();

	}

}
