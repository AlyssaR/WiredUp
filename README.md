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

For turbidity use the getConductivity() method. 
	(Uses digital pins 11 and 12, and analog pins 4 and 5. Returns: conductivity measurement)
