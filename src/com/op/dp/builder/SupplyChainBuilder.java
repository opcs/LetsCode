/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.dp.builder;

public interface SupplyChainBuilder {

    public void buildStartStep();

    public void buildTransportStep();

    public void buildEndStep();

    public SupplyChain getSupplyChain();
}
