package com.example.helloworld.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.helloworld.data.HelloWorld;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class HelloWorldConfig {

	@Bean
	@ConditionalOnProperty(name = "helloworld.call.name", havingValue = "noargs", matchIfMissing = false)
	HelloWorld helloWorldNoArgs() {
		log.info("helloWorld NoArgs Eager Bean is created");
		return new HelloWorld();
	}

	@Bean
	@ConditionalOnProperty(name = "helloworld.call.name", havingValue = "allargs", matchIfMissing = false)
	HelloWorld helloWorldAllArgs() {
		log.info("helloWorld AllArgs Eager Bean is created");
		return HelloWorld.builder().callName("allargs").orderNumber(1).build();
	}
}
