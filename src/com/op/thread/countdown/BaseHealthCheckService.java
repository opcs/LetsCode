/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.countdown;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthCheckService implements Runnable {

    private String serviceType;
    private CountDownLatch latch;

    public abstract void verifyService();

    public BaseHealthCheckService(String sType, CountDownLatch latch) {
        this.serviceType = sType;
        this.latch = latch;
    }

    @Override
    public void run() {
        verifyService();

    }
    public String getServiceType() {
        return serviceType;
    }

    public CountDownLatch getLatch() {
        return latch;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

}
