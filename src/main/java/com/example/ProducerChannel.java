package com.example;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

interface ProducerChannel {
	String OUTPUT = "producer";
	
	@Output(ProducerChannel.OUTPUT)
	MessageChannel producerChannel();
}
