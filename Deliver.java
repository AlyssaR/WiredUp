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
    int stdSpeed = 125;

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
        go.forward(stdSpeed, DISTANCE);
        go.right(stdSpeed, DISTANCE); //Navigate to dropoff (factor in current location based on location of bridge)
        while(/*CannotSeeWall*/true) {//Use bump? to find wall behind dropoff
            go.forward(stdSpeed, DISTANCE);
        }
    }

    public void dispenseBalls() {
        //Use servo motors to raise arm and open gate
        go.backward(stdSpeed, DISTANCE); //Help final balls roll out?
    }
}