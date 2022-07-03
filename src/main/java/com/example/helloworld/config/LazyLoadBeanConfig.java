package com.example.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.example.helloworld.data.LazyLoadBean;

import lombok.extern.slf4j.Slf4j;

@Lazy
@Configuration
@Slf4j
public class LazyLoadBeanConfig {

	@Bean
	LazyLoadBean lazyLoadBeanNoArgs() {
		log.info("LazyLoad Bean is created");
		return LazyLoadBean.builder().callName("lazyLoad").orderNumber(2).build();
	}

}
