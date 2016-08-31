package natverkssaker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.pi4j.component.light.impl.GpioDimmableLightComponent;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.GpioPinAnalogOutput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import io.Controller;

public class Host implements Runnable {

	private ServerSocket serv_socket;
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private Controller controller;
	
	public Host(ServerSocket serv_socket) {
		create_gpio_stuff();
		this.serv_socket = serv_socket;
		this.controller = new Controller();
		
	}
	
	@Override
	public void run() {
		
		while(true){
			boolean disconnected = false;
			
			try {
				
				socket = serv_socket.accept();
				System.out.println("User connected");
				inputStream = new ObjectInputStream(socket.getInputStream());
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("connected");
			
			while(!disconnected){
				
				try{
					
					Object object = inputStream.readObject();
					natverkssaker.Message message = (natverkssaker.Message) object; //BAM där har du det.
					//Lägg till nödvändiga anrop.
					System.out.println("Msg recieved: " + message.toString() );
					if(message.getContent()[0] == 1){
						pin.blink(message.getContent()[1]);
					}
				}catch(Exception ex){
					
					//an exeption could be generated when parsing the packet
					//(since TCP is used this should not be a problem, but who knows)
					ex.printStackTrace();
					
				}
				
			}
			
		}
		
	}
	
	
	//START OF TEST CODE
	private GpioController gpio; //behöver initieras
	private boolean blinking = false;
	private GpioPinDigitalOutput pin;
	
	public void blink(int delay){
		
		pin.blink(delay);
		
	}
	
	public void create_gpio_stuff(){
		gpio = GpioFactory.getInstance();
		pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "?", PinState.HIGH);
		
		
		
	}	
	//END OF TEST CODE

	
	
}
