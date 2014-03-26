/* Deliver.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle finding the drop off point and delivering the ping pong balls.

*/
import rxtxrobot.*;

public class TestBridget {

    public TestBridge(){
        go = new Movement();
    }

    public void findBridge((RXTXRobot mater){
        int value = 0, int maxValue = 700;

        DigitalPin bumpSensor = getDigitalPin(0);
        go.right(mater);
        go.move(mater, 300, 300);
        go.right(mater);

        while(value <= maxValue ){
            go.move(mater,300,1);
            value++;
            if (bumpSensor.getValue() /*bump sensor is hit)   digital*/){
                then value = maxValue;
            }
        }
        go.left(mater);
        go.move(mater,500,300);
        go.right(mater);

    }
}

