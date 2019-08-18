/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.dp.lift;

/**
 * Events of the elevator : GOINGUP, GOINGDOWN, STOP
 * States of the elevator : ONMOVE, WAITING (between door open and close), IDLE (serving no one), UNDERMAINTENANCE
 * Elevator movement is usually driven by two activites:
 * 1. Press-And-Wait, say PAW(Press Up or Down key outside the gate of elevator and wait for the elevator).
 * 2. Enter-And-Request, say EAR (Enter inside the elevator and make request by pressing keys)
 * So it can said that PAW from outside and EAR from inside can decide the hops of the elevator. But what about direction?
 * Two possible types of PAW: PAWup (press Up button) and PAWdown (press Down button)
 * Now, EAR can be any of the three types depending upon the users behavior. These are the critical challenges in deciding the
 * algorithm:
 * 1.) Normal - same direction as PAW (wanted to go down and enter lower floor#)
 * 2.) Opposite - wanted to go down BUT enter higher floor#
 * 3.) Indecisive - Do Nothing, no key press
 * Now comes all the important rules:
 * RULE 1: If at IDLE, use FCFS to decide between the DownList front and UpList front - whoever is oldest, serve it first to
 * ensure less waiting time.
 * RULE 2: When both lists (DownList and UpList) are empty, move elevator to IDLE state.
 * RULE 3: Elevator state change GOINGUP->STOP clears that floor# from UpList. Similarly, GOINGDOWN->STOP clears that floor from
 * DownList.
 * RULE 4: Absolute Zero Skipping: GOINGxxx serves as many floors in xxxList as possible.
 * RULE 5: Elevator doesn't favour Opposite-EAR, and obviously can't serve Indecisive-EAR.
 * RULE 6: Elevator in UNDERMAINTENANCE state is shunned from all external signals.
 * RULE 7: In the event of Power-cuts or Fire, the elevator goes and stops at Lobby. Flooding??
 * To achieve RULE#5, GOINGDOWN clears all the lower floor# in DownList in ONE GO. Similarly, GOINGUP clears all the higher floor#
 * in UpList.
 * Lets discuss one scenario to clear the above concepts:
 * Say, an elevator is resting at floor 7 is at IDLE state,
 * DownList :
 * UpList :
 * IDLE@7 - PAWdown@12 then PAWup@9 then PAWdown@13
 * DownList : 12, 13 (older requests at lower index.Push new requests at front.)
 * UpList : 9
 * Using RULE#2, in the above case,
 * Event: GOINGUP to Pick@12.
 * WAITING@12 - 12 cleared following RULE#3
 * MeanWhile, PAWup@8 then PAWup@10 then PAWdown@10, so updated lists are:
 * DownList : 13, 10
 * UpList : 9, 8, 10
 * So here, in the current situation, if the EAR is
 * 1.) Normal, GOINGDOWN(towards new EAR) is triggered.
 * 2.) Opposite/Indecisive, GOINGDOWN(towards 9) is triggered and add the new EAR in UpList.
 */
public class Lift {

}
