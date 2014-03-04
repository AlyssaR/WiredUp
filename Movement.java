/* Movement.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle moving and maneuvering around the course.

*/
import rxtxrobot.*;

public class Movement {

    public void move(RXTXRobot mater, int speed, int distance) {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, speed, distance, RXTXRobot.MOTOR2, speed, distance);
    }

    public void left(RXTXRobot mater) {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, 300, 175, RXTXRobot.MOTOR2, -300, 175);
    }

    public void right(RXTXRobot mater) {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, -300, 200, RXTXRobot.MOTOR2, 300, 200);
    }
}
