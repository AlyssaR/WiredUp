/* Deliver.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will find the bridge and cross it. 
*/
import rxtxrobot.*;

public class TestBridget {
	Movement go;
	
    public TestBridget() {
    	go = new Movement();
    }
    
    public int findBridge(RXTXRobot mater){
        int value = 0, maxValue = 750;

        mater.resetEncodedMotorPosition(1);
        mater.resetEncodedMotorPosition(2);
        
		mater.resetEncodedMotorPosition(RXTXRobot.MOTOR1);
		go.forever(mater, -300);
        while(value < maxValue){
            mater.refreshDigitalPins();
            DigitalPin bumpSensor = mater.getDigitalPin(4);
            
            value = Math.abs(mater.getEncodedMotorPosition(RXTXRobot.MOTOR1));
            
            if (bumpSensor.getValue() == 1)
            	break;
        }
        go.right(mater);
        go.move(mater,-500,750);
        go.left(mater);
        
        return value;
    }
}