package com.github.szilex94.rest;

import com.github.szilex94.service.SimpleService;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/state")
public class DemoRestController {

	@Inject
	private SimpleService sl;

	@Post("{state}")
	public void toggleState(boolean state) {
		sl.toogle(state);
	}

}
