package org.rsvlab.chapter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Every dependency has a class to do auto config. You can exclude it in
 * enable auto config annotation.
 * You can also change the default config value in application.properties file.
 * */
@EnableGlobalMethodSecurity
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


@RestController
class GreetingController {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@Autowired
	Environment env;//properties in applicatoin.properties will be loaded in to this class.
	
	
	@CrossOrigin
	@RequestMapping("/greeting")
	@ResponseBody
	public Greet sayHello() {
		logger.info("bootrest.customProperty: " + env.getProperty("bootrest.customProperty"));
		return new Greet("Hello, world!");
	}
}

class Greet {
	
	private String greet = "";
	
	public Greet(String message) {
		this.greet = message;
	}
	//没有getter setter 转换 json 会报错
	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}
	
	
	
}