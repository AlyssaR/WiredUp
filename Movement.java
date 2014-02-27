/* Movement.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle moving and maneuvering around the course.

*/
import rxtxrobot.*; 

public class Movement {
public static void main(String[] args) {
	forward();

}

public static void forward() {
	RXTXRobot mater = new RXTXRobot(); //Note: Our robot name is "mater" like tuhmater except without the tuh.
    
	mater.setPort("COM4"); // Set port to COM4
	mater.setHasEncodedMotors(true); 
	mater.connect(); 
	mater.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100000); // Run motor 1 forward (speed of 255) for 100,000 ticks
	mater.close(); 


}
}