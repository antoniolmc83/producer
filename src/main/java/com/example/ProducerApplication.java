package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ProducerApplication {

//	private final MessageChannel mychannel;
	
//	public ProducerApplication(ProducerChannel channels){
//		this.mychannel = channels.mychannel();
//	}
	@Autowired
	private SendingBean sendingBean;
	
	@PostMapping("greet/{name}")
	public void publish(@PathVariable String name){//@RequestBody Map<String, String> msg
		String greeting = "Hello, " + name + "!";
		
//		Message<String> msg = MessageBuilder.withPayload(greeting).build();
//		this.mychannel.send(msg);
		sendingBean.sayHello(greeting);
		System.out.println("Message sent");
	}
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}

