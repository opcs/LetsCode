/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.op.thread.countdown;
import java.util.concurrent.CountDownLatch;


public class NetworkHCService extends BaseHealthCheckService {

    private CountDownLatch latch;
    private boolean isServiceUp;
    public NetworkHCService(CountDownLatch latch) {
        super("Network Health Check Service", latch);
        this.latch = latch;
    }

    @Override
    public void verifyService() {

        if (!isServiceUp) {
            System.out.println(" start Network services");
            isServiceUp = true;
            latch.countDown();
        }
    }

    public boolean isServiceUp() {
        return isServiceUp;
    }

    public void setServiceUp(boolean isServiceUp) {
        this.isServiceUp = isServiceUp;
    }

}
