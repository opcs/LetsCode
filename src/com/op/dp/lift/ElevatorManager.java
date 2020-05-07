/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.dp.lift;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ElevatorManager {

    private int currentFloor;
    private BlockingQueue<Request> queue = new ArrayBlockingQueue(10);
    private List<Elevator> elevators;

    void delegate() {

        // Instead of using one object, we could use a list to track idle and elevators moving in same direction
        // so that these list could be used for next requests in queue
        // but again to simplify pseudocode, I am using single objects instead of lists
        Elevator idleElevator = null; // track idle elevator
        Elevator elevatorMovingInSameDirection = null; // elevator moving in same direction as next request in main elevator
                                                       // manager queue

        while(!halt()) { //keep delegating until powered down or whole system is halted through main controls

            if(queue.peek() != null) {

                Request req = queue.peek();
                boolean startAgain = false; // flag to start from beginning if the request is already pushed to one of the elevators queue during iterating elevators

                for(Elevator elevator : elevators) {

                    // first find if there is an elevator at current floor going in same direction as current request in queue
                    if(req.currentFloor == elevator.currentFloor && req.direction == elevator.direction) {
                        // elevator.reqQueue.offer(req.destinationFloor);
                        queue.poll(); // remove this request from Elevator Manager queue

                        startAgain = true;
                        break;
                    }

                    // check if this elevator is idle
                    if (elevator.direction == "idle") {
                        idleElevator = elevator; // For this simple design, I am ok to overwrite idle elevator value and instead get the latest idle elevatior
                    }

                    // check if this elevator is moving in desired direction and elevator's current floor is behind desired floor in queue
                    if(elevator.direction == req.direction) {

                        // Make sure elevators moving in same direction should also be behind the floor where request is made
                        if(req.direction == "Up" && req.currentFloor - elevator.currentFloor > 0) {

                            elevatorMovingInSameDirection = elevator; // Same as above, it's ok to get this overwritten and instead get the latest elevator moving in same      direction
                        }

                        // Make sure elevators moving in same direction should also be behind the floor where request is made
                        if(req.direction == "Down" && req.currentFloor - elevator.currentFloor < 0) {
                            elevatorMovingInSameDirection = elevator;
                        }
                    }

                }

                // Only delegate to other floors if you could not find elevator going in same direction at same floor from where the request was made
                if(!startAgain && idleElevator != null) {
                    // idleElevator.reqQueue.offer(req.destinationFloor);
                    queue.poll();
                }

                // if we could neither find elevator at current floor nor idle elevator then send this request to elevator behind current Floor and moving in same direction as the request
                if(!startAgain && elevatorMovingInSameDirection != null) {
                    // elevatorMovingInSameDirection.reqQueue.offer(req.destinationFloor);
                    queue.poll();
                }


            }
        }
    }

    /**
     * @return
     */
    private boolean halt() {
        // TODO Auto-generated method stub
        return false;
    }
}

