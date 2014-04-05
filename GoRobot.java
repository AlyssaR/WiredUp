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
    	Movement go = new Movement();
    	mater.setPort("COM8");
		mater.connect();

		/*I wanted a header1 okay.*/
		System.out.println("       ------------");
        System.out.println("       | WiredUp! |");
        System.out.println("       ------------");
        System.out.println("\nIt's demo time! Let's party!\n\n");
        
	//	mater.runMotor(RXTXRobot.MOTOR3, 300, 100);
		
		/*Get Parameter Input*/
        Scanner input = new Scanner(System.in);
        
 	  	System.out.print("What is the value of the left salinity dispenser? (1 or .1) ");
        float salinLeft = input.nextFloat();
        
  	  	System.out.print("What is the value of the right salinity dispenser? (1 or .1) ");
        float salinRight = input.nextFloat();
        
        System.out.print("What is the value of the left turbidity dispenser? (50 or 5) ");
        float turbidLeft = input.nextFloat();
        
  	  	System.out.print("What is the value of the right turbidity dispenser? (50 or 5) ");
        float turbidRight = input.nextFloat();

        boolean getToken = false;

        /*Get ball?*/
        if(getToken)
        	soccerTime(mater);
        
        /*Find and test water*/
/*        go.move(mater, 300, 600);
        SensorTester test = new SensorTester();
        float salinity = test.salinity(mater);
//      float turbidity = test.turbidity(mater);
        
        /*Well -> dispensing ping pong balls*/
/*        DEMOgoGetEm(mater, salinity, salinLeft, salinRight);

        /*Find and cross bridge*/
/*        go.move(mater, 300, 50);
        go.left(mater);
        go.move(mater, 300, 450);
        go.left(mater);
        
*/        TestBridget bridget = new TestBridget();
        int bridgeLoc = bridget.findBridge(mater);
        
        /*Find and deliver ping pong balls*/       
        Deliver deliver = new Deliver(bridgeLoc);
        deliver.findDropoff(mater);
        
        /*Close*/
        mater.close();
    }
    
    public static void soccerTime(RXTXRobot mater) {
    	Movement go = new Movement();
    	int speed = 300;
    	
    	//go.raiseDaRoof(mater, speed, 150); //just in case
		go.firstLeft(mater);
		go.move(mater, speed, 650);
		
		go.raiseDaRoof(mater, speed, 1000);
		go.raiseDaRoof(mater, -speed, 700); //Lower da roof
		
		go.move(mater, -speed, 600);
		mater.runEncodedMotor(RXTXRobot.MOTOR1, 300, 300, RXTXRobot.MOTOR2, -300, 300);
    }
    
    public static void DEMOgoGetEm(RXTXRobot mater, float salinReading, float salinLeft, float salinRight) {
        /*Create objects and variables*/
    	int speed = 300;
        Movement go = new Movement();
        Dispense dispense = new Dispense(salinReading, 0, salinLeft, salinRight, 0, 0);

        go.move(mater, -300, 150);
        go.left(mater);
        go.move(mater, -300, 600);
        
//        dispense.getSBalls(mater);
    }
    
    public static void goGetEm(RXTXRobot mater, float salinReading, float salinLeft, float salinRight, float turbidReading, float turbidLeft, float turbidRight) {
        /*Create objects and variables*/
    	int speed = 300;
        Movement go = new Movement();
        Dispense dispense = new Dispense(salinReading, turbidReading, salinLeft, salinRight, turbidLeft, turbidRight);

        /*Dispense Turbidity*/
        go.move(mater, -speed, 300);
        go.left(mater);
		go.move(mater, speed, 400);
		dispense.getTBalls(mater);
        
		/*Other Side*/
        go.turnAroundSitDown(mater);
        go.move(mater, 300, 750);
        
        /*Dispense Salinity*/
        dispense.getSBalls(mater);
    }
}