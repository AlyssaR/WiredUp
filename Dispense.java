/* Dispense.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle dispensing the correct amount of ping pong balls.

*/
import rxtxrobot.*; 

public class Dispense {
    RXTXRobot mater = new RXTXRobot(); //Note: Our robot name is "mater" like tuhmater except without the tuh.
    int salinity[2] = 0, turbidity[2] = 0;
    int salinReading = 0, turbidReading = 0;
    Movement go;

    public Dispense(int salin, int turbid, String port) {
        mater.setPort(port);
        mater.connect();
        go = new Movement(port);
        salinReading = salin;
        turbidReading = turbid;
    }

    public void putAway() { //Deconstructor? Always needs to be called when done using object in other classes
        mater.close();
    }

    public void setSVal(int sensorInput) {
        //Do math here to figure out how many ping pong balls are needed
        salinity[0] = sensorInput;
    }

    public void setTVal(int sensorInput) {
        //Do math here to figure out how many ping pong balls are needed
        turbidity[0] = sensorInput;
    }

    public void getSBalls(int index) {
        go.move(SPEED, DISTANCE); //Some navigationaly stuff to find the dispenser
        if(/*CanSeeDispenser*/true) { //use ping
            for(; salinity[index] > 0; salinity[index]--) {
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward
            }
        }
        else {
            //LineUpAgain
        }
    }

    public void getTBalls() {
        go.move(SPEED, DISTANCE); //Some navigationaly stuff to find the dispenser
        if(/*CanSeeDispenser*/true) { //use ping
            for(; turbidity[index] > 0; turbidity[index]--) {
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward
            }
        }
        else {
            //LineUpAgain
        }
    }
}