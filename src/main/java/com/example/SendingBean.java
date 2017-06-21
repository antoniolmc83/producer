package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(ProducerChannel.class)
public class SendingBean {

	private ProducerChannel source;
	
	@Autowired
	public SendingBean(ProducerChannel source) {
		this.source = source;
	}
	
	public void sayHello(String name){
		source.producerChannel().send(MessageBuilder.withPayload(name).build());
	}
	
}
