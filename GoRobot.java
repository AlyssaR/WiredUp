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
        
	System.out.println("       ------------");
        System.out.println("       | WiredUp! |");
        System.out.println("       ------------");
        System.out.println("\nIt's demo time! Let's party!\n\n");
        
        System.out.print("What port is the arduino in? Enter \"COM#\" - ");
                String port = input.next();

        System.out.print("Where is the bridge? Enter 0 for left, 1 for middle, 2 for right. ");
        int bridgeLoc = input.nextInt();

        System.out.print("Do we want to get the soccer ball first? Enter \"true\" for first and \"false\" for last. ");
        boolean getToken = input.nextBoolean();

        /*Well -> dispensing ping pong balls*/
        goGetEm(port);

        /*Crossed bridge -> delivery of ping pong balls*/
        Deliver deliver = new Deliver(bridgeLoc, port);
        deliver.findDropoff();
        deliver.putAway();
    }
    public static void goGetEm(String port) {
        /*Create objects and variables*/
        Movement go = new Movement(port);
        float salinReading = 0, turbidReading = 0;
        Dispense dispense = new Dispense(salinReading, turbidReading, port);

        /*Dispense*/
        go.move(SPEED, DISTANCE); //However much will align with dispenser after turning
        go.right();
        go.move(SPEED, DISTANCE);
        dispense.getTBalls(0); //Pass 0 as index for left well
        go.move(SPEED, DISTANCE); //However much needed to move to other well
        go.right();
        go.left();
        dispense.getTBalls(1); //Pass 1 as index for right well

        /*Close all objects*/
        go.putAway();
        dispense.putAway();
    }
}