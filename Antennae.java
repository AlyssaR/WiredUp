import rxtxrobot.*;
import java.lang.Math;
 
public class SensorTester 
{ 
	public int turbidity(RXTXRobot mater) {
		mater.refreshAnalogPins(); 

		AnalogPin turbidity = mater.getAnalogPin(3); 
		int turVal = turbidity.getValue();
		
		System.out.println("Turbidity is: " + turVal);
		
		return turVal;
	}
	public float salinity(RXTXRobot mater) {
		int current;
		float average = 0;

		mater.moveServo(RXTXRobot.SERVO1, 0);
		mater.sleep(2000);
		
		for(int x = 0; x < 7; x++) {
			current = mater.getConductivity();
			System.out.printf("\nSalinity %d is: %d", x+1 , current);
			average += current;
		}
		
		mater.moveServo(RXTXRobot.SERVO1, 90);
		
		average /= 7; 
		
		//Converting reading to Salinity Val
		double exponent = -.009*average;
		double eVar = Math.exp(exponent);
		double converted = .107883*eVar;
		float salVal = (float)converted*1000000;
		
		System.out.printf("\nAverage: %.0f \nConverted: %.10f\nFinal Reading: %.2f", average, converted, salVal);
		
		return salVal;
	}
}