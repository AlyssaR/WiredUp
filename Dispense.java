/* Dispense.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle dispensing the correct amount of ping pong balls.

*/
import rxtxrobot.*; 

public class Dispense {
    RXTXRobot mater = new RXTXRobot(); //Note: Our robot name is "mater" like tuhmater except without the tuh.
    int salinity = 0, turbidity = 0;
    int salinReading = 0, turbidReading = 0;
    Movement go = new Movement();

    public Dispense(int salin, int turbid) {
        mater.setPort("COM4");
        mater.connect();
        salinReading = salin;
        turbidReading = turbid;
    }

    public void putAway() { //Deconstructor? Always needs to be called when done using object in other classes
        mater.close();
    }

    public void setSVal(int sensorInput) {
        //Do math here to figure out how many ping pong balls are needed
        salinity = sensorInput;
    }

    public void setTVal(int sensorInput) {
        //Do math here to figure out how many ping pong balls are needed
        turbidity = sensorInput;
    }

    public void getSBalls() {
        go.forward(); //Some navigationaly stuff to find the dispenser
        if(/*CanSeeDispenser*/true) { //use ping
            for(; salinity > 0; salinity--) {
                go.forward();
                mater.sleep(1000); //Waits 1 second
                go.backward();
            }
        }
        else {
            //LineUpAgain
        }
    }

    public void getTBalls() {
        go.forward(); //Some navigationaly stuff to find the dispenser
        if(/*CanSeeDispenser*/true) { //use ping
            for(; turbidity > 0; turbidity--) {
                go.forward();
                mater.sleep(1000); //Waits 1 second
                go.backward();
            }
        }
        else {
            //LineUpAgain
        }

    }
}