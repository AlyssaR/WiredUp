/* Deliver.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle finding the drop off point and delivering the ping pong balls.

*/
import rxtxrobot.*;

public class Deliver {
    Movement go;
    int bridgeAt; //From starting spot looking across canyon: 0=left, 1=middle, 2=right
    int speed = 300, distance = 30;

    public Deliver(int bridge) {
        go = new Movement();
        bridgeAt = bridge;
    }

    public void findDropoff(RXTXRobot mater) {
        
            go.move(mater, speed, 850);

        dispenseBalls(mater);
    }

    public void dispenseBalls(RXTXRobot mater) {
        //Raise gate
        mater.moveServo(RXTXRobot.SERVO1, 30);

        //Wait and knock remaining balls out
        mater.sleep(7000);
        go.move(mater, -speed, distance);
        go.move(mater, speed, distance);
    }
}