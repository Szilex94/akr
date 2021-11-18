package com.github.szilex94.service;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.platform.Platforms;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;

@Singleton
public class SimpleService {

	private static final int PIN_LED = 22; // PIN 15 = BCM 22

	private Context pi4j;

	private DigitalOutput led;

	@PostConstruct
	public void postConstruct() {
		pi4j = Pi4J.newAutoContext();
		Platforms platforms = pi4j.platforms();

		DigitalOutputConfigBuilder ledConfig = DigitalOutput.newConfigBuilder(pi4j)//
				.id("led")//
				.name("LED Flasher")//
				.address(PIN_LED)//
				.shutdown(DigitalState.LOW)//
				.initial(DigitalState.LOW)//
				.provider("pigpio-digital-output");

		led = pi4j.create(ledConfig);

	}

	public void toogle(boolean state) {
		System.out.println("Desired State " + state);
		led.setState(state);
	}

	@PreDestroy
	public void preDestroy() {
		System.err.print("PreDestroy!");
		System.out.println("Desired State OFF!");
		pi4j.shutdown();
	}

}
