/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.dp.lift;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Elevator {

    int currentFloor; // -2 to 15
    BlockingQueue<Floor> reqQueue = new ArrayBlockingQueue(10);
    String direction;

    void moveUp() {
        this.currentFloor += 1;
    }

    void moveDown() {
        this.currentFloor -= 1;
    }

    public Elevator() {
        currentFloor = -2;
    }

    void operate() {

        while (reqQueue.peek() != null) {

            Floor nextFloorInQueue = reqQueue.peek();

            while (this.currentFloor != nextFloorInQueue.request.destinationFloor) {
                if (this.direction == "Up") {
                    moveUp();
                } else if (this.direction == "down") {
                    moveDown();
                }
            }

            reqQueue.poll(); // remove the request from queue
            open(); // open door

            String backUpDirection = this.direction; // back up elevators direction to retrieve it later once dooor closes
            this.direction = "idle"; // set state to idle to let elevatorManager know that requests at current floor could be
                                     // offered to this elevator queue

            // Thread.sleep(10000); // sleep for 10 seconds so that people can leave elevator

            close(); // once people are out close door to move to next floor in queue
            this.direction = backUpDirection;
        }

        this.direction = "idle"; // once queue is empty set the direction to idle
    }

    /**
     * 
     */
    private void close() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    private void open() {
        // TODO Auto-generated method stub

    }

}

