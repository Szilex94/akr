package com.github.szilex94;

import io.micronaut.runtime.Micronaut;

public class Application {

	public static void main(String[] args) {
		Micronaut.build(args)//
				.mainClass(Application.class)//
				.eagerInitSingletons(true)//
				.start();
	}
}
