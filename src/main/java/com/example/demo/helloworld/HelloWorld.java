package com.example.demo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping("/hello")
	public String getHello() {
		return "Hello World";
	}

	@GetMapping("hello/{name}")
	public String getName(@PathVariable String name)
	{
		return ("Hello World"+name);
	}

}
