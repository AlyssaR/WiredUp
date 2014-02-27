/* Movement.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle moving and maneuvering around the course.

*/
import rxtxrobot.*; 

public class Movement {
    RXTXRobot mater; //Note: Our robot name is "mater" like tuhmater except without the tuh.

    public Movement() {
        mater.setPort("COM4");
        mater.setHasEncodedMotors(true);
        mater.connect();
    }

    public void putAway() { //Deconstructor? Always needs to be called when done using object in other classes
        mater.close();
    }

    public void forward() {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100000, RXTXRobot.MOTOR2, 255, 100000); //Speed of 255 for 100,000 ticks
    }

    public void backward() {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, -255, 100000, RXTXRobot.MOTOR2, -255, 100000); //Speed of 255 for 100,000 ticks
    }

    public void left() {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, -255, 10000, RXTXRobot.MOTOR2, 255, 10000); //Speed of +-255 for 10,000 ticks
    }

    public void right() {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, 255, 10000, RXTXRobot.MOTOR2, -255, 10000); //Speed of +-255 for 10,000 ticks
    }
}