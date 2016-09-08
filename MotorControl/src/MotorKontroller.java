import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class MotorKontroller {
	

	private GpioController controller = GpioFactory.getInstance();
	
	private GpioPinDigitalOutput forsta = controller.provisionDigitalOutputPin(RaspiPin.GPIO_00, "0", PinState.LOW);
	private GpioPinDigitalOutput andra = controller.provisionDigitalOutputPin(RaspiPin.GPIO_02, "0", PinState.LOW);
	
	
	public static void main(String[] args) {
		new MotorKontroller();
	}
	
	public MotorKontroller() {
		
		while(true){
			
			forsta.high();
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			forsta.low();
			
			andra.high();
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			andra.low();
			
		}
		
	}
	

}