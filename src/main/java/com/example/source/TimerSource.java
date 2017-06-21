package com.example.source;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.support.GenericMessage;


@EnableBinding(Source.class)
public class TimerSource {
	
	@Bean
	@InboundChannelAdapter(value=Source.OUTPUT,poller = @Poller(fixedDelay="5000", maxMessagesPerPoll="1") )
	public MessageSource<Long> timeMessageSource(){
		System.out.println("Message sent");
//		return () -> new GenericMessage<>(new SimpleDateFormat( "yyyy/MM/dd hh:mm:ss" ).format(new Date()));
		return () -> MessageBuilder.withPayload(new Date().getTime()).build();
	}
}
