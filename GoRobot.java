/* GoRobotGo.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This is the main class and will create/handle objects from all other created classes.  

Most commands are from the documentation on "RXTX Robot". 
*/
import rxtxrobot.*;
import java.util.Scanner;

public class GoRobot {
    public static void main(String[] args) {
        /*Get Parameter Input*/
        Scanner input = new Scanner(System.in);

        System.out.print("What port is the arduino in? Enter \"COM#\". ");
        String port = input.next();

/*Not needed yet.
        System.out.print("Where is the bridge? Enter 0 for left, 1 for middle, 2 for right. ");
        int bridgeLoc = input.nextInt();

        System.out.print("Do we want the soccer ball? Enter \"true\" for first and \"false\" for last. ");
        boolean getToken = input.nextBoolean();
*/
        /*Well through dispensing ping pong balls*/
//      goGetEm(port);

        /*Crossed bridge through delivery of ping pong balls*/
//      deliveryForMater(bridgeLoc, port);

    }

    public static void goGetEm(String port) {
        Movement go = new Movement(port);
        int salinReading = 0, turbidReading = 0;
        Dispense dispense = new Dispense(salinReading, turbidReading, port);

        go.move(SPEED, DISTANCE); //However much will align with dispenser after turning
        go.right(SPEED, DISTANCE);
        go.move(SPEED, DISTANCE);
        dispense.getTBalls(0); //Pass 0 as index for left well
        go.move(SPEED, DISTANCE); //However much needed to move to other well
        go.right(SPEED, DISTANCE);
        go.left(SPEED, DISTANCE);
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