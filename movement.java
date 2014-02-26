import rxtxrobot.*;

public class movement
{ 
	public static void main(String[] args) 
	{ 
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