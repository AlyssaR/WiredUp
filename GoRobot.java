/* GoRobotGo.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This is the main class and will create/handle objects from all other created classes.  

Most commands are from the documentation on "RXTX Robot". 
*/
import rxtxrobot.*;

public class GoRobot {
    public static void main(String[] args) {
        int bridgeLoc = 0; //0=left, 1=middle, 2=right
        boolean getToken;
        String port = "COM4"; //Accept input for what port the arduino is in

        goGetEm(); //From well to end of dispensing
        deliveryForMater(bridgeLoc, port); //From crossed bridge to delivery
    }

    public static void goGetEm() {
        Movement go = new Movement(port);
        int salinReading = 0, turbidReading = 0;
        Dispense dispense = new Dispense(salinReading, turbidReading, port);

        go.backward(stdSpeed, DISTANCE); //However much will align with dispenser after turning
        go.right(stdSpeed, DISTANCE);
        go.straight(stdSpeed, DISTANCE);
        dispense.getTBalls(0); //Pass 0 as index for left well
        go.backward(stdSpeed, DISTANCE); //However much needed to move to other well
        go.right(stdSpeed, DISTANCE);
        go.left(stdSpeed, DISTANCE);
        dispense.getTBalls(1); //Pass 1 as index for right well

        dispense.putAway();
        go.putAway();
    }

    public static void deliveryForMater(int bridgeLoc, String port) {
        Deliver deliver = new Deliver(bridgeLoc, port);
        deliver.findDropoff();
        deliver.dispenseBalls();

        deliver.putAway();
    }
}