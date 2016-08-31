package io;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Controller {

	/*
	 * This class controls the wheels, it has two wheel objects and tell them what or what not to do.
	 * 
	 */
	
	private GpioPinDigitalOutput pin;
	private boolean blink = false;
	private boolean state = false; //false = av | true = på
	
	public Controller() {

	}
	

	
	
	
}
