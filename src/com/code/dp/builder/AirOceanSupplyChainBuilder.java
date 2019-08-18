/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.dp.builder;
public class AirOceanSupplyChainBuilder implements SupplyChainBuilder {

    private SupplyChain supplyChain;

    public AirOceanSupplyChainBuilder() {
        supplyChain = new SupplyChain();
    }

    @Override
    public void buildStartStep() {
        supplyChain.setStartStep("build air startStep");
    }

    @Override
    public void buildTransportStep() {
        supplyChain.setTransportStep("build air transportStep");

    }

    @Override
    public void buildEndStep() {
        supplyChain.setEndStep("build air endStep");

    }
    @Override
    public SupplyChain getSupplyChain() {
        return this.supplyChain;
    }

}
