WiredUp
=======

The following .java and .class files are currently included in this repo:
	GoRobot (main)
	Deliver (uses movement)
	Dispense (uses movement)
	Movement (independent)

	MotorTest (sample code to test all motors)

Use this command to compile the files. 
It will include the RXTXRobot.jar library and compile all the .java's at once. 

		javac -cp ./* *.java

For salinity use the getConductivity() method.
For turbidity, get digital pin reading.