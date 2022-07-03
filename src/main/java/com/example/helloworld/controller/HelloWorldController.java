package com.example.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.data.HelloWorld;
import com.example.helloworld.data.LazyLoadBean;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloWorldController {

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	private HelloWorld helloWorld;

	@Autowired
	@Lazy
	private LazyLoadBean lazyLoadBean;

	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping("/")
	public String getAppName() {
		log.info(applicationContext.getDisplayName());
		return appName;
	}

	@RequestMapping("/hello")
	public HelloWorld getHelloWorldBean() {
		return helloWorld;
	}

	@RequestMapping("/lazy")
	public LazyLoadBean getlazyLoadBean() {
		return lazyLoadBean;
	}
}
