/* Dispense.java by Team WiredUp!
	Created by: Adam Goff and Alyssa Rahman
	Created on: February 26, 2014

This class will handle dispensing the correct amount of ping pong balls.

*/
import rxtxrobot.*;

public class Dispense {
    float sNeeded, leftS, rightS, tNeeded, leftT, rightT;
    int heldPingPongBalls = 0, SPEED = 300, BACKUP = 10, DISTANCE = 50;
    Movement go;

    public Dispense(float salin, float turbid, float salinLeft, float salinRight, float turbidLeft, float turbidRight) {
        go = new Movement();
        sNeeded = salin;
        tNeeded = turbid;
        leftS = salinLeft;
        rightS = salinRight;
        leftT = turbidLeft;
        rightT = turbidRight;
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
            go.move(mater, -300, 30);
            go.right(mater);
            go.move(mater, 300, 340);
            go.left(mater);
            go.move(mater, 300, 30);
            while (sNeeded > .05){
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
            go.move(mater, -300, 30);
            go.left(mater);
            go.move(mater, 300, 340);
            go.right(mater);
            go.move(mater, 300, 30);
            while (sNeeded > .05){
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
                go.move(mater, SPEED, DISTANCE+10); //Forward
                mater.sleep(500); //Waits .5 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= leftT;
                heldPingPongBalls++;
            }
            go.move(mater, -300, 30);
            go.right(mater);
            go.move(mater, 300, 340);
            go.left(mater);
            go.move(mater, 300, 30);
            while (tNeeded > 2.5){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(500); //Waits .5 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= rightT;
                heldPingPongBalls++;
            }
        }

        else{
            while (tNeeded >= rightT){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(500); //Waits .5 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= rightT;
                heldPingPongBalls++;
            }
            go.move(mater, -300, 30);
            go.left(mater);
            go.move(mater, 300, 340);
            go.right(mater);
            go.move(mater, 300, 30);
            while (tNeeded > 2.5){
                go.move(mater, SPEED, DISTANCE); //Forward
                mater.sleep(500); //Waits .5 second
                go.move(mater, -SPEED, BACKUP); //Backward

                tNeeded -= leftT;
                heldPingPongBalls++;
            }
        }
    }
}
