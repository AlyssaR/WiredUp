/* Deliver.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle finding the drop off point and delivering the ping pong balls.

*/
import rxtxrobot.*;

public class Deliver {
    RXTXRobot mater = new RXTXRobot(); //Note: Our robot name is "mater" like tuhmater except without the tuh.
    Movement go;
    int bridgeAt; //From starting spot looking across canyon: 0=left, 1=middle, 2=right

    public Deliver(int bridge, String port) {
        mater.setPort(port);
        mater.connect();
        go = new Movement(port);
        bridgeAt = bridge;
    }

    public void putAway() { //Always needs to be called when done using object in other classes
        mater.close();
    }

    public void findDropoff() {
        mater.refreshAnalogPins();
        AnalogPin bumpSensor = getAnalogPin(0);

        go.right(); //Turn at end of bridge
        while(bumpSensor == 0) { //Go til bump sensor is hit
            go.move(250, 100);
        }
    }

    public void dispenseBalls() {
        //Use servo motors to raise arm and open gate
        mater.moveServo(RXTXRobot.SERVO2, 30); //Starting position of 0

        //Knock balls roll out
        mater.sleep(7000);
        go.move(-255, 50);
        go.move(255, 50);
    }
}