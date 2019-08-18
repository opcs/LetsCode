/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.dp.builder;
public class AirOceanSCBuilder {

    public static void main(String[] args) {
        AirOceanSupplyChainBuilder builder = new AirOceanSupplyChainBuilder();
        SupplyChainEngineer engineer = new SupplyChainEngineer(builder);
        engineer.constructSupplyChain();
        final SupplyChain supplyChain = engineer.getSupplyChain();
        System.out.println("supply chain created: " + supplyChain);
    }

}
