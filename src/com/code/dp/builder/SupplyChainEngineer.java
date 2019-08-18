/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.dp.builder;

public class SupplyChainEngineer {

    private SupplyChainBuilder supplyChainBuilder;

    public SupplyChainEngineer(SupplyChainBuilder supplyChainBuilder) {
        this.supplyChainBuilder = supplyChainBuilder;
    }

    public void constructSupplyChain() {
        this.supplyChainBuilder.buildStartStep();
        this.supplyChainBuilder.buildTransportStep();
        this.supplyChainBuilder.buildEndStep();
    }

    public SupplyChain getSupplyChain() {
        return this.supplyChainBuilder.getSupplyChain();
    }
}
