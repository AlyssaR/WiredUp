/* Deliver.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle finding the drop off point and delivering the ping pong balls.

*/
import rxtxrobot.*;

public class Deliver {
    Movement go;
    int bridgeAt; //From starting spot looking across canyon: 0=left, 1=middle, 2=right

    public Deliver(int bridge) {
        go = new Movement();
        bridgeAt = bridge;
    }

    public void findDropoff(RXTXRobot mater) {
        mater.refreshAnalogPins();
    //    AnalogPin bumpSensor = getAnalogPin(0);

        go.right(mater); //Turn at end of bridge
   //     while(bumpSensor.getValue() == 0) {
            go.move(mater, 250, 30);
   //     }
        go.move(mater, -250, 50); //Back up ~5.75 inches

        dispenseBalls(mater);
    }

    public void dispenseBalls(RXTXRobot mater) {
        //Raise gate
        mater.moveServo(RXTXRobot.SERVO2, 20);

        //Wait and knock remaining balls out
        mater.sleep(7000);
        go.move(mater, -255, 15);
        go.move(mater, 255, 15);
    }
}
