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
    	RXTXRobot mater = new RXTXRobot();
    	mater.setPort("COM8");
		mater.setVerbose(true);
		mater.connect();

        Scanner input = new Scanner(System.in);

        System.out.println("       ------------");
        System.out.println("       | WiredUp! |");
        System.out.println("       ------------");
        System.out.println("\nIt's demo time! Let's party!\n\n");

        System.out.print("What port is the arduino in? Enter \"COM#\" - ");
        String port = "COM8";//input.next();

        System.out.print("What is the salinity reading? ");
        float salinity = 10; //input.nextFloat();

        System.out.print("What is the turbidity reading? ");
        float turbidity = 22; //input.nextFloat();

        System.out.print("Where is the bridge? Enter 0 for left, 1 for middle, 2 for right. ");
        int bridgeLoc = 0; //input.nextInt();

        System.out.print("Do we want to get the soccer ball first? Enter \"true\" for first and \"false\" for last. ");
        boolean getToken = true; //input.nextBoolean();

        /*Well -> dispensing ping pong balls*/
        goGetEm(mater, salinity, turbidity);

        /*Crossed bridge -> delivery of ping pong balls*/
        Deliver deliver = new Deliver(bridgeLoc);
        deliver.findDropoff(mater);
    }
    public static void goGetEm(RXTXRobot mater, float salinReading, float turbidReading) {
        /*Create objects and variables*/
        Movement go = new Movement();
        Dispense dispense = new Dispense(salinReading, turbidReading);

        /*Dispense*/
    //    go.move(SPEED, DISTANCE); //However much will align with dispenser after turning
    //    go.right(mater);

    //    go.move(SPEED, DISTANCE);

        dispense.getTBalls(mater);

    //    go.move(SPEED, DISTANCE); //However much needed to move to other well
    //    go.right(mater);
    //    go.left(mater);

   //     dispense.getSBalls();

        /*Close*/
        mater.close();
    }
}
