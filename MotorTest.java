import rxtxrobot.*; 

public class MotorTest {
	public static void main(String[] args) {
		RXTXRobot mater = new RXTXRobot(); // Create RXTXRobot object 
		mater.setPort("COM4"); // Set port to COM4
		mater.setHasEncodedMotors(true); 
		mater.connect(); 
		
		mater.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100000, RXTXRobot.MOTOR2, 255, 100000); 
		mater.sleep(5000);  
		
		mater.runEncodedMotor(RXTXRobot.MOTOR1, 200, 100000, RXTXRobot.MOTOR2, 255, 100000); 
		mater.sleep(5000); 
		
		mater.runEncodedMotor(RXTXRobot.MOTOR1, 150, 100000, RXTXRobot.MOTOR2, 255, 100000);
		mater.sleep(5000); 
		
		mater.runEncodedMotor(RXTXRobot.MOTOR1, 100, 100000, RXTXRobot.MOTOR2, 255, 100000);
		mater.sleep(5000); 
		
		mater.runEncodedMotor(RXTXRobot.MOTOR1, 50, 100000);
		mater.sleep(5000); 
		
		mater.runEncodedMotor(RXTXRobot.MOTOR1, 25, 100000);
		
		mater.close(); 
	}
}