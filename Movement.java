/* Movement.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle moving and maneuvering around the course.

*/
import rxtxrobot.*; 

public class Movement {

	public void forever(RXTXRobot mater, int speed) {
		mater.runMotor(RXTXRobot.MOTOR1, speed, RXTXRobot.MOTOR2, speed, 0);
	}
    public void move(RXTXRobot mater, int speed, int distance) {
        mater.runEncodedMotor(RXTXRobot.MOTOR1, speed, distance, RXTXRobot.MOTOR2, speed, distance);
    }
    public void wellTurn(RXTXRobot mater) {
    	mater.runEncodedMotor(RXTXRobot.MOTOR1, -300, 175, RXTXRobot.MOTOR2, 300, 175);
    }
    public void left(RXTXRobot mater) {
    	mater.runEncodedMotor(RXTXRobot.MOTOR1, -300, 250, RXTXRobot.MOTOR2, 300, 250);
    }
    public void right(RXTXRobot mater) {
    	mater.runEncodedMotor(RXTXRobot.MOTOR1, 300, 250, RXTXRobot.MOTOR2, -300, 250);
    }
    public void firstLeft(RXTXRobot mater) {
    	mater.runEncodedMotor(RXTXRobot.MOTOR1, -300, 225, RXTXRobot.MOTOR2, 300, 225);
    }
    public void turnAroundSitDown(RXTXRobot mater) {
    	mater.runEncodedMotor(RXTXRobot.MOTOR1, 300, 320, RXTXRobot.MOTOR2, -300, 320);
    }
    public void raiseDaRoof(RXTXRobot mater, int speed, int height) {
    	mater.runMotor(RXTXRobot.MOTOR3, speed, height);
    }
}