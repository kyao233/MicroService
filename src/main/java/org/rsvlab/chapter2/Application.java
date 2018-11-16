package org.rsvlab.chapter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


@RestController
class HelloWorld {
	
	@RequestMapping("/greeting")
	@ResponseBody
	public Greet sayHello() {
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