import rxtxrobot.*;
import java.lang.Math;
 
public class Antennae
{ 
	public Antennae() { 
		RXTXRobot mater = new RXTXRobot(); 
		mater.setPort("COM8"); 
		mater.connect();
		
		mater.moveServo(RXTXRobot.SERVO1, 10);
		mater.sleep(2000);
	} 
	public int turbidity(RXTXRobot mater) {
		mater.refreshAnalogPins(); 

		AnalogPin turbidity = mater.getAnalogPin(3); 
		int turVal = turbidity.getValue();
		
		System.out.println("Turbidity is: " + turVal);
		
		return turVal;
	}
	public double salinity(RXTXRobot mater) {
		int current;
		double average = 0;
		
		for(int x = 0; x < 20; x++) {
			current = mater.getConductivity();
			System.out.printf("\nSalinity %d is: %d", x+1 , current);
			average += current;
		}
				
		average /= 20; 
		
		//Converting reading to Salinity Val
		double exponent = -.009*average;
		double eVar = Math.exp(exponent);
		double converted = .107883*eVar;
		double salVal = converted*1000000;
		
		System.out.printf("\nAverage: %.0f \nConverted: %.10f\nFinal Reading: %.2f", average, converted, salVal);
		
		return salVal;
	}
	
	public void allDone(RXTXRobot mater) {
		mater.moveServo(RXTXRobot.SERVO1, 90);
	}
}