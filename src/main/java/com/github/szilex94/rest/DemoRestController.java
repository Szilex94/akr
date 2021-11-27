package com.github.szilex94.rest;

import com.github.szilex94.service.SimpleService;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/testEndpoint")
public class DemoRestController {

	@Post
	public void toggleState(Test test) {
		System.out.println(test);
	}

}
