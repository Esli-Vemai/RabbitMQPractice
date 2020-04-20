package com.rabbitmq.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MainClass {

	public static void main(String[] args) throws IOException, TimeoutException {
		Publisher.publish();
		String consumerTag = Consumer.consume();
		System.out.println("returned consumerTag: " + consumerTag);
	}

}
