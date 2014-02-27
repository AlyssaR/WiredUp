/* GoRobotGo.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This is the main class and will create/handle objects from all other created classes.  

Most commands are from the documentation on "RXTX Robot". 
*/
import rxtxrobot.*; 

public class GoRobot {
public static void main(String[] args) {
	Move();

    //Testing comments
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