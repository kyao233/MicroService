package org.spring.hal;

import java.util.concurrent.LinkedTransferQueue;

import org.spring.hal.hello.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
@SpringBootApplication
public class SpringHypermediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHypermediaApplication.class, args);
	}
}



@RestController
class GreetingController {
	
	private static final String TEMPLATE = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(
			@RequestParam(value = "name", required = false, 
			defaultValue = "world") String name) {
		
		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		
		return new HttpEntity<Greeting>(greeting);
	}
	
}