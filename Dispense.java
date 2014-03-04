/* Dispense.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle dispensing the correct amount of ping pong balls.

*/
import rxtxrobot.*; 

public class Dispense {
    RXTXRobot mater = new RXTXRobot(); //Note: Our robot name is "mater" like tuhmater except without the tuh.
    float sNeeded, leftS, rightS, tNeeded, leftT, rightT;
    int PingPongBalls = 0;
    Movement go;

    public Dispense(float salin, float turbid, String port) {
        mater.setPort(port);
        mater.connect();
        go = new Movement(port);
        sNeeded = salin;
        tNeeded = turbid;
    }

    public void putAway() { //Always needs to be called when done using object in other classes
        mater.close();
    }

    public void getSBalls() {
        if (leftS > rightS){
            while (sNeeded >= leftS){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                sNeeded -= leftS;
                heldPingPongBalls++;
            }
            while (sNeeded > 0){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                sNeeded -= rightS;
                heldPingPongBalls++;
            }
        }

        else{
            while (sNeeded >= rightS){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                sNeeded -= rightS;
                heldPingPongBalls++;
            }
            while (sNeeded > 0){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                sNeeded -= leftS;
                heldPingPongBalls++;
            }
        }
    }

    public void getTBalls() {
        if (leftT > rightT){
            while (tNeeded >= leftT){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                tNeeded -= leftT;
                heldPingPongBalls++;
            }
            while (tNeeded > 0){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                tNeeded -= rightT;
                heldPingPongBalls++;
            }
        }

        else{
            while (tNeeded >= rightT){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                tNeeded -= rightT;
                heldPingPongBalls++;
            }
            while (tNeeded > 0){
                go.move(SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(SPEED, DISTANCE); //Backward

                tNeeded -= leftT;
                heldPingPongBalls++;
            }
        }
    }
}