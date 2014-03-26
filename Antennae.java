/* STExamen.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will test all the things.

*/
import rxtxrobot.*; 

public class Antennae {

    private int turbidity, salinity, tRem, sRem;

    public test(RXTXRobot mater) {
        mater.refreshAnalogPins();

        AnalogPin sensor = mater.getAnalogPin(3);
        turbidity = sensor.getValue();
        salinity = mater.getConductivity();

        System.out.println("Turbidity is: " + turbidity);

        System.out.println("Salinity is: " + salinity);
    }

    public int tFix() {
        //Fun math

        return tRem;
    }
    public int sFix() {
        //Fun math

        return sRem;
    }
}