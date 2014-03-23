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
    	RXTXRobot mater = new RXTXRobot();
    	mater.setPort("COM8");
		mater.setVerbose(true);
		mater.connect();

		/*I wanted a header okay.*/
		System.out.println("       ------------");
        System.out.println("       | WiredUp! |");
        System.out.println("       ------------");
        System.out.println("\nIt's demo time! Let's party!\n\n");
		
		/*Get Parameter Input*/
        Scanner input = new Scanner(System.in);

        System.out.print("What is the salinity reading? ");
        float salinity = input.nextFloat();
  	  	System.out.print("What is the value of the left salinity dispenser? (1 or .1) ");
        float salinLeft = input.nextFloat();
        
  	  	System.out.print("What is the value of the right salinity dispenser? (1 or .1) ");
        float salinRight = input.nextFloat();

        System.out.print("What is the turbidity reading? ");
        float turbidity = input.nextFloat();

  	  	System.out.print("What is the value of the left turbidity dispenser? (50 or 5) ");
        float turbidLeft = input.nextFloat();        
 
  	  	System.out.print("What is the value of the right turbidity dispenser? (50 or 5) ");
        float turbidRight = input.nextFloat();        
        
        //System.out.print("Where is the bridge? Enter 0 for left, 1 for middle, 2 for right. ");
        int bridgeLoc = 0;//input.nextInt();

        //System.out.print("Do we want to get the soccer ball first? Enter \"true\" for first and \"false\" for last. ");
        boolean getToken = false;//input.nextBoolean();

        /*Well -> dispensing ping pong balls*/
    //    goGetEm(mater, salinity, salinLeft, salinRight, turbidity, turbidLeft, turbidRight);

        /*Crossed bridge -> delivery of ping pong balls*/
        Deliver deliver = new Deliver(bridgeLoc);
       deliver.findDropoff(mater);
        
        /*Close*/
        mater.close();
    }
    public static void goGetEm(RXTXRobot mater, float salinReading, float salinLeft, float salinRight, float turbidReading, float turbidLeft, float turbidRight) {
        /*Create objects and variables*/
    	int speed = 300;
        Movement go = new Movement();
        Dispense dispense = new Dispense(salinReading, turbidReading, salinLeft, salinRight, turbidLeft, turbidRight);

        /*Dispense Turbidity*/
/*        go.move(mater, speed, 225);	
		go.firstLeft(mater);
		go.move(mater, speed, 495);
		dispense.getTBalls(mater);
 */       

 //       go.turnAroundSitDown(mater);
        
        /*Dispense Salinity*/
  //      go.move(mater, speed, DISTANCE);
  //      dispense.getSBalls(mater);
    }
}