/* Movement.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle moving and maneuvering around the course.

*/
import rxtxrobot.*; 

public class Movement {
public static void main(String[] args) {
	Move();

}

public static void Move() {
	RXTXRobot mater = new RXTXRobot(); // Create RXTXRobot object 
	mater.setPort("COM4"); // Set port to COM4
	mater.setHasEncodedMotors(true); 
	mater.connect(); 
	mater.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100000); // Run motor 1 forward (speed of 255) for 100,000 ticks 
	// Program stops until the command above is completed 
	mater.runEncodedMotor(RXTXRobot.MOTOR1, -255, 100000); // Run motor 1 backward (speed of 255) for 100,000 ticks 
	mater.close(); 


}
}