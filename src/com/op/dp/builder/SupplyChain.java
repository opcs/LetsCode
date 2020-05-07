/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.dp.builder;

public class SupplyChain implements StepPlan {

    private String startStep;
    private String transportStep;
    private String endStep;


    @Override
    public void setStartStep(String startStep) {
        this.startStep = startStep;

    }


    @Override
    public void setTransportStep(String transportStep) {
        this.transportStep = transportStep;

    }


    @Override
    public void setEndStep(String endStep) {
        this.endStep = endStep;

    }

    @Override
    public String toString() {
        return "SupplyChain [" + startStep + ", " + transportStep + ", " + endStep + "]";
    }

}
