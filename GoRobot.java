/* GoRobotGo.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This is the main class and will create/handle objects from all other created classes.  

Most commands are from the documentation on "RXTX Robot". 
*/
import rxtxrobot.*;

public class GoRobot {
public static void main(String[] args) {
    int salinReading, turbidReading, bridgeLocation;
    bool getToken;

    Movement go = new Movement(); //Create objects for all classes
    Dispense dispense = new Dispense(salinReading, turbidReading);
    Deliver deliver = new Deliver(bridgeLocation);



}
}