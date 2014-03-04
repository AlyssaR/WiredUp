/* Dispense.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle dispensing the correct amount of ping pong balls.

*/
import rxtxrobot.*;

public class Dispense {
    float sNeeded, leftS, rightS, tNeeded, leftT = 10, rightT = 1;
    int heldPingPongBalls = 0, SPEED = 300, BACKUP = 10, DISTANCE = 40;
    Movement go;

    public Dispense(float salin, float turbid) {
        go = new Movement();
        sNeeded = salin;
        tNeeded = turbid;
    }

    public void getSBalls(RXTXRobot mater) {
        if (leftS > rightS){
            while (sNeeded >= leftS){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                sNeeded -= leftS;
                heldPingPongBalls++;
            }
            while (sNeeded > 0){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                sNeeded -= rightS;
                heldPingPongBalls++;
            }
        }

        else{
            while (sNeeded >= rightS){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                sNeeded -= rightS;
                heldPingPongBalls++;
            }
            while (sNeeded > 0){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                sNeeded -= leftS;
                heldPingPongBalls++;
            }
        }
    }

    public void getTBalls(RXTXRobot mater) {
        if (leftT > rightT){
            while (tNeeded >= leftT){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= leftT;
                heldPingPongBalls++;
            }
            go.move(mater, -300, 30);
            go.right(mater);
            go.move(mater, 300, 250);
            go.left(mater);
            go.move(mater, 300, 30);
            while (tNeeded > 0){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= rightT;
                heldPingPongBalls++;
            }
        }

        else{
            while (tNeeded >= rightT){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= rightT;
                heldPingPongBalls++;
            }
            while (tNeeded > 0){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(1000); //Waits 1 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= leftT;
                heldPingPongBalls++;
            }
        }
    }
}
