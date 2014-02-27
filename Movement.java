/* Movement.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle moving and maneuvering around the course.

*/
import rxtxrobot.*; 

public class Movement {
    private RXTXRobot mater = new RXTXRobot(); //Note: Our robot name is "mater" like tuhmater except without the tuh.

    public Movement() {
        mater.setPort("COM4");
        mater.setHasEncodedMotors(true);
        mater.connect();
    }
    
    public static void main(String[] args) {
        forward();
        mater.close();
    }

    public static void forward() {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, 255, RXTXRobot.MOTOR2, 255, 100000); //Speed of 255 for 100,000 ticks
    }
}