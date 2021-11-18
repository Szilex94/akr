package com.github.szilex94.service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;

@Singleton
public class SimpleService {

	private final GpioController gpio = GpioFactory.getInstance();

	private GpioPinDigitalOutput myLed;

	@PostConstruct
	public void postConstruct() {
		myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "My LED", PinState.LOW);
	}

	public void toogle(boolean state) {
		System.out.println("Desired State " + state);
		myLed.setState(state);
	}

	@PreDestroy
	public void preDestroy() {
		System.err.print("PreDestroy!");
		gpio.shutdown();
	}

}
