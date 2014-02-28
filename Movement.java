/* Movement.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle moving and maneuvering around the course.

*/
import rxtxrobot.*; 

public class Movement {
    RXTXRobot mater; //Note: Our robot name is "mater" like tuhmater except without the tuh.

    public Movement(String port) {
        mater.setPort(port);
        mater.setHasEncodedMotors(true);
        mater.connect();
    }

    public void putAway() { //Deconstructor? Always needs to be called when done using object in other classes
        mater.close();
    }

    public void move(int speed, int distance) {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, speed, distance, RXTXRobot.MOTOR2, -255, 10000);
    }

    public void left() {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, speed, distance, RXTXRobot.MOTOR2, -255, 10000);
    }

    public void right() {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, speed, distance, RXTXRobot.MOTOR2, -255, 10000);
    }
}