package org.spring.hal.hello;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting extends ResourceSupport {

	
	private final String content;
	
	
	@JsonCreator
	public Greeting(@JsonProperty("Content") String content) {
		this.content = content;
	}


	public String getContent() {
		return content;
	}
	
	
	
}
