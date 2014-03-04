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
        while(bumpSensor.getValue() == 0) {
            go.move(250, 30);
        }
        go.move(-250, 50); //Back up ~5.75 inches

        dispenseBalls();
    }

    public void dispenseBalls() {
        //Raise gate
        mater.moveServo(RXTXRobot.SERVO2, 20);

        //Wait and knock remaining balls out
        mater.sleep(7000);
        go.move(-255, 15);
        go.move(255, 15);
    }
}